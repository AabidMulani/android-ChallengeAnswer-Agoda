package news.agoda.com.technewssample;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by aabid-personal on 3/10/16.
 */
public class BaseActivity extends AppCompatActivity {

    public Activity activity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activity = this;
    }

    @Override
    protected void onResume() {
        super.onResume();
        // register listeners and broadcast receivers here
    }

    @Override
    protected void onStop() {
        super.onStop();
        // Un-register listeners and broadcast receivers here
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

}
