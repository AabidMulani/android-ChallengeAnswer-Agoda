package news.agoda.com.technewssample.activities;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import news.agoda.com.technewssample.BaseActivity;
import news.agoda.com.technewssample.utils.AppConstants;

/**
 * Created by aabid-personal on 3/10/16.
 */
public class NewsSplashActivity extends BaseActivity {

    private boolean backKeyPressed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.);
        backKeyPressed = false;

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if (!backKeyPressed) {
                    // go to the main list screen
                    Intent intent = new Intent(activity, NewsMainScreenActivity.class);
                    startActivity(intent);
                    finish();
                }
            }
        }, AppConstants.SPLASH_SCREEN_DELAY);

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        backKeyPressed = true;
    }
}
