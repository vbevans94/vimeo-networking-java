package com.vimeo.networking2.requests

import com.vimeo.networking2.adapters.VimeoCall

/**
 * Common actions such as canceling all API requests.
 */
interface VimeoRequest {

    /**
     * Cancels the API request for you.
     */
    fun cancel()

}

/**
 * No-op API request. Used when an invalid param was given by the client. In this case,
 * the actual API request is not made. So, there is nothing to cancel.
 */
class NoOpVimeoRequest: VimeoRequest {

    override fun cancel() {}

}

/**
 * Cancellable request.
 *
 * @param call  A [VimeoCall] object for the API request.
 */
class CancellableVimeoRequest<T>(private val call: VimeoCall<T>): VimeoRequest {

    override fun cancel() {
        call.cancel()
    }

}
