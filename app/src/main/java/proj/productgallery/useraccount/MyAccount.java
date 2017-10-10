package proj.productgallery.useraccount;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import proj.productgallery.NewsFragment;
import proj.productgallery.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class MyAccount extends Fragment {


    public MyAccount() {
        // Required empty public constructor
    }
    public static MyAccount newInstance()
    {
        return  new MyAccount();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_my_account, container, false);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //((AppCompatActivity) getActivity()).getSupportActionBar().hide();
    }
}
