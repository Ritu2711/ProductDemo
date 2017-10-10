package proj.productgallery.productdetail;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import proj.productgallery.MainActivity;
import proj.productgallery.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class ItemDetailsFragment extends Fragment {
    RecyclerView product_images_recycler_view, moreproducts;
    ArrayList<String> imgUrls = new ArrayList<>();
    private RadioGroup radioGroup1;
    Toolbar toolbar;
    private TextView productNameTv,title;
    ScrollView sv;
    public ItemDetailsFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
/*
        ((AppCompatActivity) getActivity()).getSupportActionBar().hide();
*/
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_item_details, container, false);
         sv = (ScrollView)v.findViewById(R.id.scrl);

/*
toolbar=v.findViewById(R.id.toolbarwish);
       title=v.findViewById(R.id.toolbar_tvTitle);
        title.setText("PRODUCT DETAILS");*/

        GridLayoutManager grid = new GridLayoutManager(getActivity(), 3);


        radioGroup1 = (RadioGroup) v.findViewById(R.id.radioGroup1);
        product_images_recycler_view = (RecyclerView) v.findViewById(R.id.product_images_recycler_view);
        moreproducts = (RecyclerView) v.findViewById(R.id.moreproducts);
        moreproducts.setLayoutManager(grid);

        radioGroup1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.radioAndroid:
                        if (imgUrls != null) {

                            imgUrls.clear();
                            imgUrls.add("https://dt4f7ywfipgvt.cloudfront.net/products_images/optimized/85-3034.png");
                            imgUrls.add("https://dt4f7ywfipgvt.cloudfront.net/products_images/optimized/85-3034.png");
                            imgUrls.add("https://dt4f7ywfipgvt.cloudfront.net/products_images/optimized/85-3034.png");
                            imgUrls.add("https://dt4f7ywfipgvt.cloudfront.net/products_images/optimized/85-3034.png");

                            MyImageAdaterGrid myImageAdater1 = new MyImageAdaterGrid(imgUrls, getActivity());

                            moreproducts.setAdapter(myImageAdater1);
                            moreproducts.setVisibility(View.VISIBLE);

                        }

                        break;
                    case R.id.radioWindows:
                        if (imgUrls != null) {

                            imgUrls.clear();
                            imgUrls.add("https://dt4f7ywfipgvt.cloudfront.net/products_images/optimized/85-3034.png");
                            imgUrls.add("https://dt4f7ywfipgvt.cloudfront.net/products_images/optimized/85-3034.png");
                            imgUrls.add("https://dt4f7ywfipgvt.cloudfront.net/products_images/optimized/85-3034.png");
                            imgUrls.add("https://dt4f7ywfipgvt.cloudfront.net/products_images/optimized/85-3034.png");


                            imgUrls.add("https://dt4f7ywfipgvt.cloudfront.net/products_images/optimized/85-3034.png");
                            imgUrls.add("https://dt4f7ywfipgvt.cloudfront.net/products_images/optimized/85-3034.png");
                            imgUrls.add("https://dt4f7ywfipgvt.cloudfront.net/products_images/optimized/85-3034.png");

                            MyImageAdaterGrid myImageAdaters = new MyImageAdaterGrid(imgUrls, getActivity());

                            moreproducts.setAdapter(myImageAdaters);
                            moreproducts.setVisibility(View.VISIBLE);

                        }
                        break;
                    case R.id.radioiPhone:
                        moreproducts.setVisibility(View.GONE);
                        break;
                    default:
                        break;
                }
            }
        });
        imgUrls.add("https://dt4f7ywfipgvt.cloudfront.net/products_images/optimized/85-3034.png");
        imgUrls.add("https://dt4f7ywfipgvt.cloudfront.net/products_images/optimized/85-3034.png");
        imgUrls.add("https://dt4f7ywfipgvt.cloudfront.net/products_images/optimized/85-3034.png");
        imgUrls.add("https://dt4f7ywfipgvt.cloudfront.net/products_images/optimized/85-3034.png");
        MyImageAdater myImageAdater = new MyImageAdater(imgUrls, getActivity());
        LinearLayoutManager horizontalLayoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
        product_images_recycler_view.setLayoutManager(horizontalLayoutManager);

        product_images_recycler_view.setAdapter(myImageAdater);

        return v;
    }


    public class MyImageAdaterGrid extends RecyclerView.Adapter<MyImageAdaterGrid.MyViewHolder> {

        ArrayList<String> arrayList;
        Context context;

        public MyImageAdaterGrid(ArrayList<String> arrayList, Context context) {
            this.arrayList = arrayList;
            this.context = context;
        }

        @Override
        public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_product_image_grid, parent, false);

            return new MyViewHolder(itemView);
        }

        @Override
        public void onBindViewHolder(final MyViewHolder holder, final int position) {


            Picasso.with(context).load(arrayList.get(position)).error(R.mipmap.ic_launcher).into(holder.imageView);
          /*  holder.txtview.setText(horizontalList.get(position).txt);

            holder.imageView.setOnClickListener(new View.OnClickListener() {
                @Override

                public void onClick(View v) {
                    String list = horizontalList.get(position).txt.toString();
                    Toast.makeText(MainActivity.this, list, Toast.LENGTH_SHORT).show();
                }

            });*/

        }


        @Override
        public int getItemCount() {
            return arrayList.size();
        }


        public class MyViewHolder extends RecyclerView.ViewHolder {

            ImageView imageView;
            TextView txtview;

            public MyViewHolder(View view) {
                super(view);
                imageView = (ImageView) view.findViewById(R.id.list_item_product_images_view);
            }
        }

    }


    public class MyImageAdater extends RecyclerView.Adapter<MyImageAdater.MyViewHolder> {

        ArrayList<String> arrayList;
        Context context;

        public MyImageAdater(ArrayList<String> arrayList, Context context) {
            this.arrayList = arrayList;
            this.context = context;
        }

        @Override
        public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_product_image, parent, false);

            return new MyViewHolder(itemView);
        }

        @Override
        public void onBindViewHolder(final MyViewHolder holder, final int position) {


            Picasso.with(context).load(arrayList.get(position)).error(R.mipmap.ic_launcher).into(holder.imageView);
          /*  holder.txtview.setText(horizontalList.get(position).txt);

            holder.imageView.setOnClickListener(new View.OnClickListener() {
                @Override

                public void onClick(View v) {
                    String list = horizontalList.get(position).txt.toString();
                    Toast.makeText(MainActivity.this, list, Toast.LENGTH_SHORT).show();
                }

            });*/

        }


        @Override
        public int getItemCount() {
            return arrayList.size();
        }


        public class MyViewHolder extends RecyclerView.ViewHolder {

            ImageView imageView;
            TextView txtview;

            public MyViewHolder(View view) {
                super(view);
                imageView = (ImageView) view.findViewById(R.id.list_item_product_images_view);
            }
        }

    }

}
