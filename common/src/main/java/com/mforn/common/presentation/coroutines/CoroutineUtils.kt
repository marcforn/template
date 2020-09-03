package com.mforn.common.presentation.coroutines

import com.mforn.common.domain.exception.CustomErrorType
import com.mforn.common.domain.exception.CustomException
import kotlinx.coroutines.*
import retrofit2.HttpException
import java.io.IOException


private const val API_RETRIES = 3

/**
 * Launch Coroutine task to run block in Background and respond onSuccess/onError in UI
 * Documentation: https://proandroiddev.com/android-coroutine-recipes-33467a4302e9
 *
 * @param T -> Object that will be send on the response
 * @param block -> Code to execute [IO Dispatcher]
 * @param onCancel -> Code to execute when coroutine is canceled [Main Dispatcher]
 * @param onSuccess -> Success callback [Main Dispatcher]
 * @param onError -> Error callback [Main Dispatcher]
 * @return Job that can be cancelled
 *
 */
fun <T> launchTask(block: suspend (() -> T), onCancel: (() -> Unit)? = null, onSuccess: ((T) -> Unit)? = null, onError: ((CustomException) -> Unit)? = null, dispatchers: CoroutineDispatchers): Job {
    return CoroutineScope(dispatchers.main).launch {
        try {
            val result = withContext(dispatchers.io) { block() }
            onSuccess?.let { it(result) }
        } catch (c: CancellationException) {
            onCancel?.let { it() }
        } catch (e: CustomException) {
            onError?.let { it(e) }
        } catch (t: Throwable) {
            onError?.let { it(CustomErrorType.InternalError(t.localizedMessage ?: "Unexpected Internal Error")) }
        }
    }
}

/**
 * Default Coroutine Dispatcher
 */
data class CoroutineDispatchers(
        val main: CoroutineDispatcher = Dispatchers.Main,
        val default: CoroutineDispatcher = Dispatchers.Default,
        val io: CoroutineDispatcher = Dispatchers.IO)

/**
 * Testing Coroutine Dispatcher
 */
val testCoroutineDispatchers = CoroutineDispatchers(Dispatchers.Unconfined, Dispatchers.Unconfined, Dispatchers.Unconfined)

/**
 * Retry coroutine in case of error.
 * First we launch block, if this causes an exception that is not IOException we retry it.
 * In case of IOException we immediately throw the exception to interrupt the execution flow.
 * After all retries have been done and no IOException has been launched, we try the block for last attempt. In case of success we just populate the response,
 * otherwise we will throw the proper exception.
 *
 * @param block -> Block of code that will be executed
 * @throws CustomException ->
 * If a connectivity exception is captured (IOException) we do not retry and populate a CustomErrorType.NetworkError()
 * Otherwise we will retry API_RETRIES with API_RETRY_DELAY.
 */
@Throws(CustomException::class)
suspend fun <T> retryIO(block: suspend () -> T): T {
    repeat(API_RETRIES) {
        try {
            return block()
        } catch (exception: Exception) {
            when (exception) {
                is IOException -> throw CustomErrorType.NetworkError(exception.message ?: "Unknown NetworkError")
            }
        }
    }

    try {
        return block()
    } catch (exception: Exception) {
        when (exception) {
            is IOException -> throw CustomErrorType.NetworkError(exception.message ?: "Unknown NetworkError")
            is HttpException -> throw CustomErrorType.ApiError(exception.code(), exception.message)
            else -> throw CustomErrorType.InternalError(exception.message ?: "Unknown InternalError")
        }
    }
}