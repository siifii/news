package ray7.com.ray7.utils;

import android.app.Activity;
import android.content.Context;
import androidx.annotation.StringRes;
import com.google.android.material.snackbar.Snackbar;
import android.view.View;

import ray7.com.ray7.R;

public final class Utils {

    public static boolean isNotConnected(Throwable t) {
        return null == t.getMessage()
                || t.getMessage().contains("No address associated with hostname")
                || t.getMessage().contains("connect timed out")
                || t.getMessage().contains("timeout");
    }


    public static void snackbar(Context context, @StringRes int id) {
        Snackbar.make(((Activity) context).findViewById(android.R.id.content), id, Snackbar.LENGTH_SHORT).show();
    }

    public static void snackbar(Activity activity, @StringRes int id) {
        Snackbar.make(activity.findViewById(android.R.id.content), id, Snackbar.LENGTH_SHORT).show();
    }

    public static void snackbar(Activity activity, String s) {
        Snackbar.make(activity.findViewById(android.R.id.content), s, Snackbar.LENGTH_SHORT).show();
    }

    public static void snackbar(Context context, String s) {
        Snackbar.make(((Activity) context).findViewById(android.R.id.content), s, Snackbar.LENGTH_SHORT).show();
    }

    public static void errorSnackbar(Activity activity, @StringRes int id, View.OnClickListener action) {
        Snackbar.make(activity.findViewById(android.R.id.content), id, Snackbar.LENGTH_SHORT)
                .setAction(R.string.retry, action)
                .setActionTextColor(activity.getResources().getColor(R.color.error))
                .setDuration(8000).show();

    }

    public static void errorSnackbar(Context context, @StringRes int id, View.OnClickListener action) {
        Snackbar.make(((Activity) context).findViewById(android.R.id.content), id, Snackbar.LENGTH_SHORT)
                .setAction(R.string.retry, action)
                .setActionTextColor(context.getResources().getColor(R.color.error))
                .setDuration(8000).show();
    }

}
