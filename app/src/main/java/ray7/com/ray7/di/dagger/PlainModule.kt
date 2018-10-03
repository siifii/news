package ray7.com.ray7.di.dagger

import com.google.gson.FieldNamingPolicy
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import ray7.com.ray7.data.services.NewsService
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import ray7.com.ray7.data.services.RetrofitWebService
import retrofit2.Retrofit
import java.util.concurrent.Executor
import java.util.concurrent.Executors
import javax.inject.Named
import javax.inject.Singleton

@Module
class PlainModule {
    @Provides
    @Singleton
    fun provideGson(): Gson {
        return GsonBuilder()
                .setPrettyPrinting()
                .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
                .create()
    }

    @Provides
    @Singleton
    fun retrofit(): RetrofitWebService = RetrofitWebService()

    @Provides
    @Singleton
    @Named("baseUrl")
    fun provideBaseUrl(): String {
        return "https://newsapi.org/"
    }

    @Provides
    @Singleton
    fun provideRetrofitService(fit: Retrofit): NewsService = fit.create(NewsService::class.java)

    @Provides
    @Singleton
    fun providesNetworkExecutor(): Executor = Executors.newFixedThreadPool(5)

    @Provides
    @Singleton
    fun provideLoggingInterceptor(): HttpLoggingInterceptor =
            HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)

/*
    @Provides
    @Singleton
    fun provideAuthInterceptor(): AuthInterceptor = AuthInterceptor()
*/

    @Provides
    @Singleton
    fun provideHttpClient(logging: HttpLoggingInterceptor): OkHttpClient {
        return OkHttpClient.Builder()
                .addInterceptor(logging)
                .build()
    }
}
