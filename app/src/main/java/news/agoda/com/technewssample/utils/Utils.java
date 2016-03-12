package news.agoda.com.technewssample.utils;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.net.ConnectivityManager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatDialog;
import android.widget.Toast;

import com.nostra13.universalimageloader.core.DisplayImageOptions;

import news.agoda.com.technewssample.R;

/**
 * Created by aabid-personal on 3/10/16.
 */
public class Utils {


    public static void showLongToast(Context context, String msg) {
        Toast.makeText(context, msg, Toast.LENGTH_LONG).show();
    }

    public static void showShortToast(Context context, String msg) {
        Toast.makeText(context, msg, Toast.LENGTH_SHORT).show();
    }

    public static void showThisMsg(Context activity, String title, String message, DialogInterface.OnClickListener
            onOkClickListener, DialogInterface.OnClickListener onCancelClickListener) {
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        if (title != null) {
            builder.setTitle(title);
            builder.setIcon(R.drawable.app_icon);
        } else {
            builder.setTitle(null);
        }
        builder.setMessage(message);
        builder.setPositiveButton(activity.getString(android.R.string.ok), onOkClickListener);
        if (onCancelClickListener != null) {
            builder.setNegativeButton(activity.getString(android.R.string.cancel), onCancelClickListener);
        }
        builder.setCancelable(false);
        AppCompatDialog dialog = builder.show();
        dialog.setCanceledOnTouchOutside(false);
        dialog.show();
    }


    public static boolean checkInternetConnection(Context mContext) {
        boolean retVal = false;
        try {
            ConnectivityManager conMgr = (ConnectivityManager) mContext.getSystemService(Context.CONNECTIVITY_SERVICE);
            retVal = conMgr.getActiveNetworkInfo() != null && conMgr.getActiveNetworkInfo().isAvailable() && conMgr
                    .getActiveNetworkInfo().isConnected();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return retVal;
    }


    public static Typeface getThisFont(Context context, int textStyleIndex) {
        final int FONT_LIGHT = 0;
        final int FONT_MEDIUM = 1;
        final int FONT_REGULAR = 2;

        Typeface typeface;
        switch (textStyleIndex) {
            case FONT_LIGHT:
                typeface = Typeface.createFromAsset(context.getAssets(), "fonts/Roboto-Light.ttf");
                break;
            case FONT_MEDIUM:
                typeface = Typeface.createFromAsset(context.getAssets(), "fonts/Roboto-Medium.ttf");
                break;
            case FONT_REGULAR:
                typeface = Typeface.createFromAsset(context.getAssets(), "fonts/Roboto-Regular.ttf");
                break;
            default:
                typeface = Typeface.createFromAsset(context.getAssets(), "fonts/Roboto-Medium.ttf");
                break;
        }
        return typeface;
    }


    public static DisplayImageOptions getDisplayOptions() {
        return new DisplayImageOptions.Builder().showImageOnLoading(new ColorDrawable(Color.WHITE))
                .showImageForEmptyUri(R.drawable.placeholder)
                .showImageOnFail(R.drawable.placeholder)
                .resetViewBeforeLoading(false)
                .cacheInMemory(true)
                .cacheOnDisk(true)
                .build();
    }


}
