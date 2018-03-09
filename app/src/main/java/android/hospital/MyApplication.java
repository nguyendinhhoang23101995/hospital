package android.hospital;

import android.app.Application;
import android.content.Context;
import android.content.res.Resources;
import android.hospital.api.OkHttpStack;
import android.hospital.di.ApplicationComponent;
import android.hospital.di.DaggerApplicationComponent;
import android.hospital.module.RoomModule;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.annotation.VisibleForTesting;
import android.text.TextUtils;
import android.util.DisplayMetrics;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

import java.util.Locale;


public class MyApplication extends Application {
    public static final String PACKAGE_NAME = MyApplication.class.getPackage().getName();
    private static final String TAG = MyApplication.class.getSimpleName();
    public static String APP_VERSION = "0.0.0";
    public static String ANDROID_ID = "0000000000000000";
    private static MyApplication mInstance;
    private RequestQueue mRequestQueue;

    private ApplicationComponent applicationComponent;

    public static synchronized MyApplication getInstance() {
        return mInstance;
    }

    public static void setAppLocale(String lang) {
        Resources res = mInstance.getResources();
        DisplayMetrics dm = res.getDisplayMetrics();
        android.content.res.Configuration conf = res.getConfiguration();
        conf.locale = new Locale(lang);
        res.updateConfiguration(conf, dm);
    }

    public static DefaultRetryPolicy getDefaultRetryPolice() {
        return new DefaultRetryPolicy(10000, 2, 1);
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mInstance = this;
        applicationComponent = DaggerApplicationComponent
                .builder()
                .roomModule(new RoomModule(this))
                .build();
    }

    public ApplicationComponent getApplicationComponent() {
        return applicationComponent;
    }

    public boolean isDataConnected() {
        ConnectivityManager connectMan = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectMan.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnectedOrConnecting();
    }

    public boolean isWiFiConnection() {
        ConnectivityManager connectMan = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectMan.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.getType() == ConnectivityManager.TYPE_WIFI;
    }

    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //////////////////////// Volley request ///////////////////////////////////////////////////////////////////////////////////////
    public RequestQueue getRequestQueue() {
        if (mRequestQueue == null) {
            mRequestQueue = Volley.newRequestQueue(this, new OkHttpStack());
        }
        return mRequestQueue;
    }

    @VisibleForTesting
    public void setRequestQueue(RequestQueue requestQueue) {
        mRequestQueue = requestQueue;
    }

    public <T> void addToRequestQueue(Request<T> req, String tag) {
        // set the default tag if tag is empty
        req.setTag(TextUtils.isEmpty(tag) ? TAG : tag);
        getRequestQueue().add(req);
    }

    public void cancelPendingRequests(Object tag) {
        if (mRequestQueue != null) {
            mRequestQueue.cancelAll(tag);
        }
    }
}
