/*
 * Copyright (c) 2020 Vimeo (https://vimeo.com)
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package com.vimeo.networking2.internal

import com.vimeo.networking2.Authenticator
import com.vimeo.networking2.VimeoAccount
import com.vimeo.networking2.VimeoCallback
import com.vimeo.networking2.VimeoRequest

/**
 * An [Authenticator] that delegates its implementation to an internal mutable instance [actual]. The purpose of this
 * class is to allow the [Authenticator] instance to be re-initialized on the fly. It delegates to an underlying actual
 * implementation that can be changed dynamically. This allows the [Authenticator.initialize] function to change the
 * implementation used without changing the reference returned by [Authenticator.instance].
 *
 * @param actual The actual implementation of [Authenticator], defaults to null.
 */
class MutableAuthenticatorDelegate(var actual: Authenticator? = null) : Authenticator {
    private val authenticator: Authenticator
        get() = actual ?: throw IllegalStateException(
            "Must call Authenticator.initialize() before calling Authenticator.instance()"
        )

    override val currentAccount: VimeoAccount?
        get() = authenticator.currentAccount

    override fun clientCredentials(callback: VimeoCallback<VimeoAccount>): VimeoRequest =
        authenticator.clientCredentials(callback)

    override fun google(
        token: String,
        email: String,
        marketingOptIn: Boolean,
        callback: VimeoCallback<VimeoAccount>
    ): VimeoRequest = authenticator.google(token, email, marketingOptIn, callback)

    override fun facebook(
        token: String,
        email: String,
        marketingOptIn: Boolean,
        callback: VimeoCallback<VimeoAccount>
    ): VimeoRequest = authenticator.facebook(token, email, marketingOptIn, callback)

    override fun emailJoin(
        displayName: String,
        email: String,
        password: String,
        marketingOptIn: Boolean,
        callback: VimeoCallback<VimeoAccount>
    ): VimeoRequest = authenticator.emailJoin(displayName, email, password, marketingOptIn, callback)

    override fun emailLogin(email: String, password: String, callback: VimeoCallback<VimeoAccount>): VimeoRequest =
        authenticator.emailLogin(email, password, callback)

    override fun exchangeOAuthOneToken(
        token: String,
        tokenSecret: String,
        callback: VimeoCallback<VimeoAccount>
    ): VimeoRequest = authenticator.exchangeOAuthOneToken(token, tokenSecret, callback)

    override fun logOut(callback: VimeoCallback<Unit>): VimeoRequest =
        authenticator.logOut(callback)
}