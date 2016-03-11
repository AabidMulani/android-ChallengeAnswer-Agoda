package news.agoda.com.technewssample;

import android.app.Application;

/**
 * Created by aabid-personal on 3/10/16.
 */
public class BaseApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        if (BuildConfig.DEBUG) {
            Timber.plant(new Timber.DebugTree());
        } else {
            Timber.e("Initial Call");
            Timber.plant(new CrashlyticsTree());
        }

        Fresco.initialize(this);
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
    }
}
