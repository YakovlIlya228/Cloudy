package com.example.cloudy.domain.usecase

import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext

typealias CompletionBlock<T> = UseCase.MainHandler<T>.() -> Unit

abstract class UseCase<T> {


    private var parentJob: Job = Job()
    private var backgroundContext: CoroutineContext = Dispatchers.IO
    private var foregroundContext: CoroutineContext = Dispatchers.Main


    abstract suspend fun executeOnBackground(): T

    // default
    fun execute() {
        execute {}
    }

    fun execute(block: CompletionBlock<T>) {
        val mainHandler = MainHandler<T>().apply { block() }
        unsubscribe()
        mainHandler(State.ON_START)

        parentJob = Job()
        CoroutineScope(foregroundContext + parentJob).launch {
            try {
                val result = withContext(backgroundContext) {
                    executeOnBackground()
                }
                mainHandler(result)
            } catch (e: Exception) {
                mainHandler.invoke("$e")
            } finally {
                mainHandler(State.ON_STOP)
            }
        }
    }

    fun unsubscribe() {
        parentJob.apply {
            cancelChildren()
            cancel()
        }
    }

    enum class State {
        ON_START,
        ON_STOP
    }

    class MainHandler<T> {
        private var onStart: (() -> Unit) = {}
        private var onStop: (() -> Unit) = {}
        private var onComplete: ((T) -> Unit) = {}
        private var onError: ((String) -> Unit) = {}
        private var onCancel: ((CancellationException) -> Unit) = {}

        fun onStart(block: () -> Unit) {
            onStart = block
        }

        fun onStop(block: () -> Unit) {
            onStop = block
        }

        fun onComplete(block: (T) -> Unit) {
            onComplete = block
        }

        fun onError(block: (String) -> Unit) {
            onError = block
        }

        fun onCancel(block: (CancellationException) -> Unit) {
            onCancel = block
        }

        operator fun invoke(state: State) {
            when (state) {
                State.ON_START -> onStart.invoke()
                State.ON_STOP -> onStop.invoke()
            }
        }

        operator fun invoke(result: T) {
            onComplete.invoke(result)
        }

        operator fun invoke(error: String) {
            onError.invoke(error)
        }

        operator fun invoke(error: CancellationException) {
            onCancel.invoke(error)
        }
    }
}