package proj.productgallery.wishlist;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import proj.productgallery.MainActivity;
import proj.productgallery.R;
import proj.productgallery.productview.Beanclass;

public class MyWishList extends Fragment {
    Toolbar toolbar;
    TextView toolbar_tvTitle;
    ImageView search_ahead;
    ArrayList<Beanclass> arrayList=new ArrayList<>();
    private int[] IMAGEgrid = {R.mipmap.p1, R.mipmap.product, R.mipmap.p1, R.mipmap.product};
    private String[] TITLeGgrid = {"LIST 1", "LIST 2", "LIST 3",  "LIST 4"};
    private String[] DIscriptiongrid = {"(4) Products", "(3) Products", "(0) Product","(0) Product"};
    private String[] Dategrid = {"Explore Now!","Grab Now!","Discover now!", "Great Savings!"};
    public static MyWishList newInstance()
    {
        return  new MyWishList();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.activity_my_wish_list, container, false);
        for (int i= 0; i< IMAGEgrid.length; i++) {

            Beanclass beanclass = new Beanclass(IMAGEgrid[i], TITLeGgrid[i], DIscriptiongrid[i], Dategrid[i]);
            arrayList.add(beanclass);

        }


        RecyclerView recyclerView = v.findViewById(R.id.recycle);

        RecyclerView.LayoutManager recylerViewLayoutManager = new LinearLayoutManager(getActivity(),LinearLayoutManager.HORIZONTAL,false);

        recyclerView.setLayoutManager(recylerViewLayoutManager);
        recyclerView.setAdapter(new SimpleStringRecyclerViewAdapter(recyclerView, arrayList,getActivity()));
        Bundle args=new Bundle();
        args.putString("data","LIST 2");


        WishlistFragment productFragment=new WishlistFragment();
        productFragment.setArguments(args);
        getActivity().getSupportFragmentManager()

                .beginTransaction()
                .replace(R.id.contain, productFragment)
                .commit();
        return v;
    }

    public static class SimpleStringRecyclerViewAdapter
            extends RecyclerView.Adapter<SimpleStringRecyclerViewAdapter.ViewHolder> {

        private ArrayList<Beanclass> mWishlistImageUri;
        private RecyclerView mRecyclerView;
Context context;
        public static class ViewHolder extends RecyclerView.ViewHolder {
            public final View mView;
            TextView wordTextView,translationTextView;
            public final ImageView mImageView;
            public final LinearLayout mLayoutItem;
            public final ImageView mImageViewWishlist;
            public ViewHolder(View view) {
                super(view);
                mView = view;
                mImageView = (ImageView) view.findViewById(R.id.image_wishlist);
                wordTextView = (TextView) view.findViewById(R.id.wordTextView);
                translationTextView = (TextView) view.findViewById(R.id.translationTextView);
                mLayoutItem = (LinearLayout) view.findViewById(R.id.layout_item_desc);
                mImageViewWishlist = (ImageView) view.findViewById(R.id.ic_wishlist);
            }
        }

        public SimpleStringRecyclerViewAdapter(RecyclerView recyclerView, ArrayList<Beanclass> wishlistImageUri,Context context) {
            mWishlistImageUri = wishlistImageUri;
            mRecyclerView = recyclerView;
            this.context=context;
        }

        @Override
        public SimpleStringRecyclerViewAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.wishlistdata, parent, false);
            return new SimpleStringRecyclerViewAdapter.ViewHolder(view);
        }

        /*@Override
        public void onViewRecycled(ViewHolder holder) {
            if (holder.mImageView.getController() != null) {
                holder.mImageView.getController().onDetach();
            }
            if (holder.mImageView.getTopLevelDrawable() != null) {
                holder.mImageView.getTopLevelDrawable().setCallback(null);
//                ((BitmapDrawable) holder.mImageView.getTopLevelDrawable()).getBitmap().recycle();
            }
        }*/

        @Override
        public void onBindViewHolder(final SimpleStringRecyclerViewAdapter.ViewHolder holder, final int position) {
            final Beanclass beanclass=mWishlistImageUri.get(position);
            holder.mImageView.setImageResource(beanclass.getImage1());
            holder.wordTextView.setText(beanclass.getTitle1());
            holder.translationTextView.setText(beanclass.getDiscription1());
            holder.mLayoutItem.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                   // Toast.makeText(mContext, ""+beanclass.getTitle1(), Toast.LENGTH_SHORT).show();

                    Bundle args=new Bundle();
                    args.putString("data",beanclass.getTitle1());

                    WishlistFragment productFragment=new WishlistFragment();
                    productFragment.setArguments(args);
                    ((FragmentActivity)context).getSupportFragmentManager()

                            .beginTransaction()
                            .replace(R.id.contain, productFragment)
                            .commit();
                    //Toast.makeText(mContext, "OK"+beanclass.getTitle1(), Toast.LENGTH_SHORT).show();
                   /* Intent intent = new Intent(mContext, ItemDetailsActivity.class);
                    intent.putExtra(STRING_IMAGE_URI,mWishlistImageUri.get(position));
                    intent.putExtra(STRING_IMAGE_POSITION, position);
                    mContext.startActivity(intent);*/
                }
            });

            //Set click action for wishlist
            holder.mImageViewWishlist.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mWishlistImageUri.remove(position);
                    notifyDataSetChanged();
                }
            });
        }

        @Override
        public int getItemCount() {
            return mWishlistImageUri.size();
        }
    }
}
