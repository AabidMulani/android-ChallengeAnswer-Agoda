package news.agoda.com.technewssample.utils;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.DialogInterface;

/**
 * Created by aabid-personal on 3/11/16.
 */
public class AppProgressDialog {

    private static ProgressDialog progressDialog;

    public static void showProgressBar(Activity activity, String message, boolean isCancellable,
                                       DialogInterface.OnCancelListener onCancelListener) {
        if (!isProgressShowing()) {
            progressDialog = ProgressDialog.show(activity, null, message, true, isCancellable,
                    onCancelListener);
        } else {
            updateProgressMsg(message);
        }
    }


    public static boolean isProgressShowing() {
        if (progressDialog == null) {
            return false;
        }
        return progressDialog.isShowing();
    }

    public static void updateProgressMsg(String msg) {
        if (progressDialog != null) {
            progressDialog.setMessage(msg);
        }
    }

    public static void hideProgressDialog() {
        if (progressDialog != null) {
            progressDialog.dismiss();
        }
    }


}
