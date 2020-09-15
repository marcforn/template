package com.mforn.common.data.network.configuration

import com.google.gson.GsonBuilder
import com.mforn.common.BuildConfig
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit


private const val TIME_OUT_MILLIS = 5000L
private const val USER_AGENT_HEADER = "User-Agent"
private const val HOST_URL = ""


class RetrofitAdapter() {

    private val retrofit: Retrofit

    init {
        val okHttpClient = initializeOkHttpClient()

        val retrofitBuilder = Retrofit.Builder()
            .baseUrl(HOST_URL)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))

        retrofit = retrofitBuilder.build()
    }

    private fun initializeOkHttpClient(): OkHttpClient {
        val httpClient = OkHttpClient.Builder()

        // Logging OkHttp requests
        val logging = HttpLoggingInterceptor()
        logging.level = HttpLoggingInterceptor.Level.BODY

        // Setting Connection Timeout
        httpClient.connectTimeout(TIME_OUT_MILLIS, TimeUnit.MILLISECONDS)
        httpClient.writeTimeout(TIME_OUT_MILLIS, TimeUnit.MILLISECONDS)
        httpClient.readTimeout(TIME_OUT_MILLIS, TimeUnit.MILLISECONDS)

        //Sets Redirects
        httpClient.followRedirects(true)
        httpClient.followSslRedirects(true)

        // Interceptors
        httpClient.addInterceptor(HeaderInterceptor())
        httpClient.addInterceptor(logging)

        return httpClient.build()
    }

    fun <T> createApi(serviceClass: Class<T>): T = retrofit.create(serviceClass)

    /**
     * Header Interceptor
     */
    private inner class HeaderInterceptor : Interceptor {
        override fun intercept(chain: Interceptor.Chain): Response {
            return chain.proceed(addRequestHeaders(chain.request()))
        }

        private fun addRequestHeaders(request: Request): Request =
            request.newBuilder()
                .header(USER_AGENT_HEADER, "Template/Android/" + BuildConfig.VERSION_NAME)
                .method(request.method, request.body)
                .build()
    }

}