package news.agoda.com.technewssample.activities;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.FrameLayout;

import butterknife.Bind;
import butterknife.ButterKnife;
import news.agoda.com.technewssample.BaseActivity;
import news.agoda.com.technewssample.BaseFragment;
import news.agoda.com.technewssample.R;
import news.agoda.com.technewssample.fragments.NewsListFragment;

/**
 * Created by aabid-personal on 3/10/16.
 */
public class NewsMainScreenActivity extends BaseActivity {

    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.container)
    FrameLayout container;
    private Fragment currentFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        ButterKnife.bind(this);
        updateToolbar();
        addThisFragment(NewsListFragment.getInstance(), false, false);
    }

    private void updateToolbar() {
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(getString(R.string.app_name_title));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void addThisFragment(Fragment fragment, boolean addToBackStack, boolean animate) {
        currentFragment = fragment;
        FragmentTransaction fragmentTransaction =
                getSupportFragmentManager().beginTransaction();
        if (animate) {
            fragmentTransaction.setCustomAnimations(R.anim.slide_in_left, R.anim.slide_out_left, R.anim.slide_in_right, R.anim.slide_out_right);
        }
        fragmentTransaction.replace(R.id.container, fragment);
        if (addToBackStack) {
            fragmentTransaction.addToBackStack("");
        }
        fragmentTransaction.commit();
    }


    @Override
    public void onBackPressed() {
        if (currentFragment instanceof BaseFragment) {
            if (!((BaseFragment) currentFragment).onBackPressConsumed()) {
                super.onBackPressed();
            }
        } else
            super.onBackPressed();
    }


}
