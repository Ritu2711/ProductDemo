package proj.productgallery.category;


import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.daimajia.slider.library.SliderTypes.BaseSliderView;

import proj.productgallery.NewsFragment;
import proj.productgallery.R;
import proj.productgallery.filteroptions.FilterActivity;

/**
 * A simple {@link Fragment} subclass.
 */
public class CategoryFragment extends Fragment implements  BaseSliderView.OnSliderClickListener {


    LinearLayout fab_filter;

    public CategoryFragment() {
        // Required empty public constructor
    }
    public static CategoryFragment newInstance()
    {
        return  new CategoryFragment();
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_category, container, false);
        TabLayout tabLayout = (TabLayout) v.findViewById(R.id.tab_layout);
         fab_filter = (LinearLayout) v.findViewById(R.id.fab_filter);
        tabLayout.addTab(tabLayout.newTab().setText("FURNITURE"));
        tabLayout.addTab(tabLayout.newTab().setText("LIGHTINGS"));
        tabLayout.addTab(tabLayout.newTab().setText("DECOR"));
        fab_filter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getActivity(), FilterActivity.class);
                startActivity(intent);
            }
        });
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        final ViewPager viewPager = (ViewPager) v.findViewById(R.id.pager);

        PagerAdapter1 adapter = new PagerAdapter1(getActivity().getSupportFragmentManager(), tabLayout.getTabCount());

        viewPager.setAdapter(adapter);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        return v;


    }

    @Override
    public void onSliderClick(BaseSliderView slider) {

    }
}
