package proj.productgallery;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;


import butterknife.ButterKnife;
import proj.productgallery.category.CategoryFragment;
import proj.productgallery.home.HomeFragment;
import proj.productgallery.productview.ProductFragment;
import proj.productgallery.useraccount.MyAccount;
import proj.productgallery.wishlist.MyWishList;
import proj.productgallery.wishlist.WishlistFragment;

public class NewsFragment extends Fragment {
    Bundle bundle=new Bundle();

    public static NewsFragment newInstance()
    {
        return  new NewsFragment();
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_news,container,false);
        ButterKnife.bind(this,view);
        Toast.makeText(getActivity(), ""+getArguments().getString("position"), Toast.LENGTH_SHORT).show();

        if (getArguments().getString("position").equalsIgnoreCase("Category")){

            CategoryFragment productFragment=new CategoryFragment();
            getActivity().getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.flContainerFragment, productFragment)
                    .commit();
        }

        if (getArguments().getString("position").equalsIgnoreCase("Home")){

            HomeFragment productFragment=new HomeFragment();
            getActivity().getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.flContainerFragment, productFragment)
                    .commit();
        }
        if (getArguments().getString("position").equalsIgnoreCase("My Wishlist")){

      /*      Intent intent=new Intent(getActivity(), MyWishList.class);
            startActivity(intent);*/
        }
        if (getArguments().getString("position").equalsIgnoreCase("My Account")){

            MyAccount productFragment=new MyAccount();
            getActivity().getSupportFragmentManager()
                    .beginTransaction()

                    .replace(R.id.flContainerFragment, productFragment)
                    .commit();
        }
        return view;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("hhhhh","caleled");

    }
}