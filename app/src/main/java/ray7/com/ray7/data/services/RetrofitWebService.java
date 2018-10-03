package ray7.com.ray7.data.services;

import android.util.Log;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import ray7.com.ray7.ui.components.Activities.BaseActivity;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class RetrofitWebService extends BaseActivity {
    private static final String url = "https://newsapi.org/";
    private static final String TAG = RetrofitWebService.class.getSimpleName();
    private static final Map<String, NewsService> mServices = new HashMap<>();

    public RetrofitWebService() {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient client = new OkHttpClient.Builder()
                .writeTimeout(1, TimeUnit.MINUTES)
                .readTimeout(1, TimeUnit.MINUTES)
                .addInterceptor(interceptor)
                .build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        mServices.put(url, retrofit.create(NewsService.class));
    }

    public static NewsService getService() {
        if (null == mServices.get(url)) {
            new RetrofitWebService();
        }
        return mServices.get(url);
    }

    public static void log(Throwable t) {
        Log.e(TAG, null != t.getMessage() ? t.getMessage() : t.toString());
    }
}
