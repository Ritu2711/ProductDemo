package proj.productgallery.category;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.LinearLayout;

import java.util.ArrayList;

import proj.productgallery.R;
import proj.productgallery.filteroptions.FilterActivity;
import proj.productgallery.productdetail.ItemDetailsFragment;
import proj.productgallery.wishlist.WishlistFragment;

/**
 * Created by apple on 18/03/16.
 */
public class TabFragment1 extends Fragment {

    private ExpandableHeightGridView gridview;
    private ArrayList<Beanclass> beanclassArrayList;
    private GridviewAdapter gridviewAdapter;
    RecyclerView recyclerView;
    private View view;
    ArrayList<GetSet> al=new ArrayList();

    private int[] IMAGEgrid = {R.mipmap.product, R.mipmap.product,R.mipmap.product, R.mipmap.product,R.mipmap.product, R.mipmap.product};
    private String[] TITLeGgrid = {"Min 70% off", "Min 50% off", "Min 45% off",  "Min 60% off", "Min 70% off", "Min 50% off"};
    private String[] DIscriptiongrid = {"Wrist Watch", "Wrist Watch", "Wrist Watch","Wrist Watch", "Wrist Watch", "Wrist Watch"};
    private String[] Dategrid = {"Explore Now!","Grab Now!","Discover now!", "Great Savings!", "Explore Now!","Grab Now!"};




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragmenttab1, container, false);

        gridview = (ExpandableHeightGridView)view.findViewById(R.id.gridview);
        recyclerView = (RecyclerView)view.findViewById(R.id.newRecycle);
        GetSet g1=new GetSet(R.mipmap.sofa,"BedRoom  Furniture");
        GetSet g2=new GetSet(R.mipmap.product,"LivingRoom Furniture");
        GetSet g3=new GetSet(R.mipmap.sofa2,"Modular Kitchen Furniture");
        GetSet g4=new GetSet(R.mipmap.p1,"Home Office Furniture");
        GetSet g5=new GetSet(R.mipmap.p1,"Outdoor Kids Furniture");


        al.add(g1);
        al.add(g2);
        al.add(g3);
        al.add(g4);
        al.add(g5);
        LinearLayoutManager layoutManager=new LinearLayoutManager(getActivity(),LinearLayoutManager.HORIZONTAL,false);
        recyclerView.setLayoutManager(layoutManager);
        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                ItemDetailsFragment itemDetailsFragment=new ItemDetailsFragment();
                getActivity().getSupportFragmentManager()
                        .beginTransaction()
                        .addToBackStack("ItemDetails")
                        .replace(R.id.flContainerFragment, itemDetailsFragment)
                        .commit();
            }
        });
        beanclassArrayList= new ArrayList<Beanclass>();
        MyAdapter myAdapter=new MyAdapter(al,getActivity());
        recyclerView.setAdapter(myAdapter);
        for (int i= 0; i< IMAGEgrid.length; i++) {

            Beanclass beanclass = new Beanclass(IMAGEgrid[i], TITLeGgrid[i], DIscriptiongrid[i], Dategrid[i]);
            beanclassArrayList.add(beanclass);

        }
        gridviewAdapter = new GridviewAdapter(getActivity(), beanclassArrayList);
        gridview.setExpanded(true);

        gridview.setAdapter(gridviewAdapter);
     return view;

    }
}