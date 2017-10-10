package proj.productgallery;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Build;
import android.os.Handler;
import android.support.annotation.RequiresApi;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import proj.productgallery.about.AboutUsFragment;
import proj.productgallery.category.CategoryFragment;
import proj.productgallery.home.HomeFragment;
import proj.productgallery.searchcontent.SearchActivity;
import proj.productgallery.useraccount.MyAccount;
import proj.productgallery.wishlist.MyWishList;

import static android.view.Gravity.RIGHT;

public class MainActivity extends AppCompatActivity {

    DrawerLayout drawer;
    private boolean homeFrag = true;


    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.toolbar_ivNavigation)
    ImageView toolbar_ivNavigation;
    @BindView(R.id.toolbar_tvTitle)
    TextView tvTitle;

    ImageView search_ahead;
    public static int navItemIndex=0;

    @OnClick(R.id.toolbar_ivNavigation) void onClickNavigation() {
        openCloseDrawer();
    }

    Unbinder unbinder;

    @SuppressWarnings("deprecation")
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);unbinder = ButterKnife.bind(this);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setToolbarTitle(getString(R.string.title_navigation_activity));
        toolbar.setNavigationIcon(null);
        setSupportActionBar(toolbar);

        search_ahead =toolbar.findViewById(R.id.search_ahead);

        search_ahead.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this, SearchActivity.class);
                startActivity(intent);
                overridePendingTransition(android.R.anim.slide_in_left,android.R.anim.slide_out_right);
                finish();
            }
        });

        drawer = (DrawerLayout) findViewById(R.id.drawerLayout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, null, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        replaceFragment(0);
        replaceNavigationFragment();
    }
    private void setToolbarTitle() {
        String activityTitles []= getResources().getStringArray(R.array.array_navigation);

        getSupportActionBar().setTitle(activityTitles[navItemIndex]);
    }
    @SuppressLint("RtlHardcoded")
    @Override
    public void onBackPressed() {
        String activityTitles []= getResources().getStringArray(R.array.array_navigation);

        if (drawer.isDrawerOpen(RIGHT)) {
            drawer.closeDrawer(RIGHT);
        }
        else {
            super.onBackPressed();
        }




        if (getFragmentManager().getBackStackEntryCount() > 0) {
            Log.d("dasddfta",""+getFragmentManager().getBackStackEntryCount());
            Fragment fragment = getSupportFragmentManager().findFragmentByTag(String.valueOf(navItemIndex));
            if (fragment instanceof CategoryFragment) {
                setToolbarTitle(activityTitles[navItemIndex]);
                FragmentManager childFm = fragment.getChildFragmentManager();
                if (childFm.getBackStackEntryCount() > 0) {
                    // update the main content by replacing

                }
                // add your code to change title of toolbar
            }
            if (fragment instanceof HomeFragment) {
                setToolbarTitle("Home");
                // add your code to change title of toolbar
            }
            if (fragment instanceof MyAccount) {
                setToolbarTitle(activityTitles[navItemIndex]);
                // add your code to change title of toolbar
            }
            if (fragment instanceof MyWishList) {
                setToolbarTitle(activityTitles[navItemIndex]);
                // add your code to change title of toolbar
            }
        } else {
            Toast.makeText(this, "done", Toast.LENGTH_SHORT).show();
            Handler mHandler =new Handler();
            Runnable mPendingRunnable = new Runnable() {
                @Override
                public void run() {


                    // update the main content by replacing fragments
                    Fragment fragment = HomeFragment.newInstance();
                    FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                    fragmentTransaction.setCustomAnimations(android.R.anim.fade_in,
                            android.R.anim.fade_out);
                    fragmentTransaction.replace(R.id.flContainerFragment, fragment);
                    fragmentTransaction.commitAllowingStateLoss();
                    setToolbarTitle("Home");

                }
            };
            if (mPendingRunnable != null) {
                mHandler.post(mPendingRunnable);
            }





            super.onBackPressed();
        }
    }


    private void openCloseDrawer() {
        if (drawer.isDrawerOpen(RIGHT)) drawer.closeDrawer(RIGHT);
        else drawer.openDrawer(RIGHT);
    }

    public void replaceNavigationFragment() {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.flContainerNavigationMenu, NavigationFragment.newInstance(), "Navigation").commit();
    }

    @Override
    protected void onResume() {
        super.onResume();


            Log.d("hello","its is home again");
            // add your code to change title of toolbar



    }

    public void replaceFragment(int position) {
        Fragment fragment = null;
        String tag = null;
        String array_navigation []= getResources().getStringArray(R.array.array_navigation);

        Log.d("data",""+position);

        switch (position){
            case 0:
                navItemIndex=0;
                Bundle args=new Bundle();
                args.putString("position",array_navigation[position]);

                fragment = HomeFragment.newInstance();
                fragment.setArguments(args);
                tag = array_navigation[position];

                break;

            case 1:
                navItemIndex=1;
                Bundle args2=new Bundle();
                args2.putString("position",array_navigation[position]);

                fragment = CategoryFragment.newInstance();
                fragment.setArguments(args2);
                tag = array_navigation[position];
                break;


            case 2:
                navItemIndex=2;
                Bundle args3=new Bundle();
                args3.putString("position",array_navigation[position]);

                fragment = MyWishList.newInstance();
                fragment.setArguments(args3);
                tag = array_navigation[position];



                break;
            case 3:
                navItemIndex=3;

                Bundle args5=new Bundle();
                args5.putString("position",array_navigation[position]);

                fragment = MyAccount.newInstance();
                fragment.setArguments(args5);
                tag = array_navigation[position];
                break;

            case 4:
                navItemIndex=4;

                Bundle args6=new Bundle();
                args6.putString("position",array_navigation[position]);

                fragment = AboutUsFragment.newInstance();
                fragment.setArguments(args6);
                tag = array_navigation[position];
                break;




        }



        replaceFragment(fragment,tag);

    }

    public void replaceFragment(Fragment fragment, String tag) {
        getSupportFragmentManager()
                .beginTransaction()
                .addToBackStack(tag)
                .replace(R.id.flContainerFragment, fragment,tag)
                .commit();



        setToolbarTitle(tag);
        closeNavigationDrawer();
    }

    public void setToolbarTitle(String title) {
        tvTitle.setText(title);
    }

    public void closeNavigationDrawer() {
        if (drawer.isDrawerOpen(RIGHT)) drawer.closeDrawer(RIGHT);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
    }


}