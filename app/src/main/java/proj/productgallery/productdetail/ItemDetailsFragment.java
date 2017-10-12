package proj.productgallery.productdetail;


import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import proj.productgallery.MainActivity;
import proj.productgallery.R;
import proj.productgallery.category.CategoryFragment;

/**
 * A simple {@link Fragment} subclass.
 */
public class ItemDetailsFragment extends Fragment {
    RecyclerView product_images_recycler_view, moreproducts;
    ArrayList<String> imgUrls = new ArrayList<>();
    private RadioGroup radioGroup1;
    Toolbar toolbar;
    LinearLayout layoutrating;
    private TextView productNameTv,title;
    ScrollView sv;
    public ItemDetailsFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        getActivity().setTitle("Product Details");
        if (getChildFragmentManager()!=null){
            Log.d("hhhhh","Yes");
        }
        else {
            Log.d("hhhhh","No");
        }
        View v = inflater.inflate(R.layout.fragment_item_details, container, false);
         sv = (ScrollView)v.findViewById(R.id.scrl);



        GridLayoutManager grid = new GridLayoutManager(getActivity(), 3);


        radioGroup1 = (RadioGroup) v.findViewById(R.id.radioGroup1);
        layoutrating = (LinearLayout) v.findViewById(R.id.layoutrating);
        product_images_recycler_view = (RecyclerView) v.findViewById(R.id.product_images_recycler_view);
        moreproducts = (RecyclerView) v.findViewById(R.id.moreproducts);
        moreproducts.setLayoutManager(grid);


        v.findViewById(R.id.radioAndroid).setEnabled(true);
        layoutrating.setVisibility(View.VISIBLE);

        radioGroup1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.radioAndroid:

                        imgUrls.clear();

                            layoutrating.setVisibility(View.VISIBLE);





                        break;
                    case R.id.radioWindows:
                        layoutrating.setVisibility(View.GONE);

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
                        layoutrating.setVisibility(View.GONE);


                        if (imgUrls != null) {

                            imgUrls.clear();
                            imgUrls.add("https://cdn3.iconfinder.com/data/icons/line-icons-set/128/1-02-256.png");

                            MyImageAdaterGrid myImageAdaters2 = new MyImageAdaterGrid(imgUrls, getActivity());

                            moreproducts.setAdapter(myImageAdaters2);
                            moreproducts.setVisibility(View.VISIBLE);
                        }

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
