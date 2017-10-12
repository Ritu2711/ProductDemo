package proj.productgallery.wishlist;


import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupMenu;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;

import proj.productgallery.R;
import proj.productgallery.productview.Beanclass;

/**
 * A simple {@link Fragment} subclass.
 */
public class WishlistFragment extends Fragment {
    private static Context mContext;
    ArrayList<Beanclass> arrayList=new ArrayList<>();
    private int[] IMAGEgrid = {R.mipmap.p1, R.mipmap.product, R.mipmap.p1, R.mipmap.product};
    private String[] TITLeGgrid = {"PRODUCT 1", "PRODUCT 2", "PRODUCT 3",  "PRODUCT 4"};
    private String[] DIscriptiongrid = {"Straight Razor Olive Wood Set", "Ustraa Shaving Mug", "Ustraa Travel Kit","Aftersave"};
    private String[] Dategrid = {"Explore Now!","Grab Now!","Discover now!", "Great Savings!"};

    RecyclerView.LayoutManager recylerViewLayoutManager;
    private int[] IMAGEgrid2 = {R.mipmap.p1, R.mipmap.p1, R.mipmap.p1};
    private String[] TITLeGgrid2 = {"PRODUCT 4", "PRODUCT 5", "PRODUCT 6"};
    private String[] DIscriptiongrid2 = {"Straight Razor Olive Wood Set", "Ustraa Shaving Mug", "Ustraa Travel Kit"};
    private String[] Dategrid2 = {"Explore Now!","Grab Now!","Discover now!"};
    FloatingActionMenu menu;
    ImageView gridlayout,listlayout;
    String data="";
    public WishlistFragment() {
        // Required empty public constructor
    }
CoordinatorLayout coordinate;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v=inflater.inflate(R.layout.fragment_wishlist, container, false);
        RelativeLayout rel=v.findViewById(R.id.hide);
        coordinate=v.findViewById(R.id.coordinate);
        mContext = getActivity();
        data=getArguments().getString("data");
        gridlayout=v.findViewById(R.id.gridlayout);
        listlayout=v.findViewById(R.id.listlayout);
   menu= (FloatingActionMenu) v.findViewById(R.id.fabshare);
        //menu.setMultipleOfFB(3.2f);
        menu.setMultipleOfFB(1.5f);


        menu.setIsCircle(true);
        menu.setOnMenuItemClickListener(new FloatingActionMenu.OnMenuItemClickListener() {
            @Override
            public void onMenuItemClick(FloatingActionMenu fam, int index, FloatingActionButton item) {
                String str = "";
                switch (index) {
                    case 0:
                        str = "Share List";
                        Snackbar bar = Snackbar.make(coordinate, "Share your list", Snackbar.LENGTH_LONG)
                                .setAction("Click here", new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        // Handle user action
                                        Intent intent = new Intent(Intent.ACTION_SEND);
                                        intent.setType("text/plain");
                                        intent.putExtra(Intent.EXTRA_TEXT, "http://66.201.99.67/~producdemo/dist/#!/dashboard/");
                                        intent.putExtra(android.content.Intent.EXTRA_SUBJECT, "Check out this site!");
                                        startActivity(Intent.createChooser(intent, "Share"));
                                    }
                                });

                        bar.show();
                        break;
                    case 1:
                        str="Request Quotes";
                        break;

                    default:
                }
                Toast.makeText(getActivity().getApplicationContext(), str, Toast.LENGTH_SHORT).show();
            }
        });
       /* Toast.makeText(mContext, "df"+data, Toast.LENGTH_SHORT).show();*/

        if (data!=null && !data.isEmpty()){
            if (data.equalsIgnoreCase("LIST 1")){

                rel.setVisibility(View.GONE);
                menu.setVisibility(View.VISIBLE);

                for (int i= 0; i< IMAGEgrid.length; i++) {

                    Beanclass beanclass = new Beanclass(IMAGEgrid[i], TITLeGgrid[i], DIscriptiongrid[i], Dategrid[i]);
                    arrayList.add(beanclass);

                }

            }

            if (data.equalsIgnoreCase("LIST 2")){
                rel.setVisibility(View.GONE);
                menu.setVisibility(View.VISIBLE);

                for (int i= 0; i< IMAGEgrid2.length; i++) {

                    Beanclass beanclass = new Beanclass(IMAGEgrid2[i], TITLeGgrid2[i], DIscriptiongrid2[i], Dategrid2[i]);
                    arrayList.add(beanclass);

                }

            }
            if (data.equalsIgnoreCase("LIST 3")){
                rel.setVisibility(View.VISIBLE);
                menu.setVisibility(View.GONE);

            }
            if (data.equalsIgnoreCase("LIST 4")){
                rel.setVisibility(View.VISIBLE);
                menu.setVisibility(View.GONE);

            }
        }


        final RecyclerView recyclerView = (RecyclerView)v.findViewById(R.id.recyclerview);
        recylerViewLayoutManager = new GridLayoutManager(mContext,2);

        recyclerView.setLayoutManager(recylerViewLayoutManager);
        recyclerView.setAdapter(new SimpleStringRecyclerViewAdapter(recyclerView, arrayList));
        gridlayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                recylerViewLayoutManager = new GridLayoutManager(getActivity(),2);

                recyclerView.setLayoutManager(recylerViewLayoutManager);
                listlayout.setVisibility(View.VISIBLE);
                gridlayout.setVisibility(View.GONE);




            }
        });

        listlayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 recylerViewLayoutManager = new LinearLayoutManager(getActivity());

                recyclerView.setLayoutManager(recylerViewLayoutManager);

                gridlayout.setVisibility(View.VISIBLE);
                listlayout.setVisibility(View.GONE);


            }
        });


        return v;
    }


    public static class SimpleStringRecyclerViewAdapter
            extends RecyclerView.Adapter<WishlistFragment.SimpleStringRecyclerViewAdapter.ViewHolder> {

        private ArrayList<Beanclass> mWishlistImageUri;
        private RecyclerView mRecyclerView;

        public static class ViewHolder extends RecyclerView.ViewHolder {
            public final View mView;
            TextView wordTextView;
            public final ImageView mImageView;
            public final LinearLayout mLayoutItem;
            public final ImageView mImageViewWishlist;
            public ViewHolder(View view) {
                super(view);
                mView = view;

                mImageView = (ImageView) view.findViewById(R.id.image_wishlist);
                mLayoutItem = (LinearLayout) view.findViewById(R.id.layout_item_desc);
                mImageViewWishlist = (ImageView) view.findViewById(R.id.ic_wishlist);
                wordTextView = (TextView) view.findViewById(R.id.wordTextView);


            }
        }

        public SimpleStringRecyclerViewAdapter(RecyclerView recyclerView, ArrayList<Beanclass> wishlistImageUri) {
            mWishlistImageUri = wishlistImageUri;
            mRecyclerView = recyclerView;
        }

        @Override
        public WishlistFragment.SimpleStringRecyclerViewAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_wishlist_item, parent, false);
            return new WishlistFragment.SimpleStringRecyclerViewAdapter.ViewHolder(view);
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
        public void onBindViewHolder(final WishlistFragment.SimpleStringRecyclerViewAdapter.ViewHolder holder, final int position) {
            final Beanclass beanclass=mWishlistImageUri.get(position);
            holder.mImageView.setImageResource(beanclass.getImage1());
            holder.wordTextView.setText(beanclass.getTitle1());

            holder.mLayoutItem.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                   // Toast.makeText(mContext, "OK"+beanclass.getTitle1(), Toast.LENGTH_SHORT).show();

                }
            });

            holder.mLayoutItem.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View view) {
                    LayoutInflater layoutInflaterAndroid = LayoutInflater.from(mContext);

                    View mView = layoutInflaterAndroid.inflate(R.layout.user_input_dialog_box, null);
                    AlertDialog.Builder alertDialogBuilderUserInput = new AlertDialog.Builder(mContext);

                    alertDialogBuilderUserInput.setView(mView);
                    final EditText userInputDialogEditText = (EditText) mView.findViewById(R.id.userInputDialog);
                    alertDialogBuilderUserInput
                            .setCancelable(false)
                            .setPositiveButton("SAVE", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialogBox, int id) {
                                    // ToDo get user input here
                                }
                            })

                            .setNegativeButton("Cancel",
                                    new DialogInterface.OnClickListener() {
                                        public void onClick(DialogInterface dialogBox, int id) {
                                            dialogBox.cancel();
                                        }
                                    });

                    AlertDialog alertDialogAndroid = alertDialogBuilderUserInput.create();
                    alertDialogAndroid.show();



                 //   Toast.makeText(mContext, "long click"+beanclass.getTitle1(), Toast.LENGTH_SHORT).show();

                    return false;
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
        public static void setForceShowIcon(PopupMenu popupMenu) {
            try {
                Field[] fields = popupMenu.getClass().getDeclaredFields();
                for (Field field : fields) {
                    if ("mPopup".equals(field.getName())) {
                        field.setAccessible(true);
                        Object menuPopupHelper = field.get(popupMenu);
                        Class<?> classPopupHelper = Class.forName(menuPopupHelper
                                .getClass().getName());
                        Method setForceIcons = classPopupHelper.getMethod(
                                "setForceShowIcon", boolean.class);
                        setForceIcons.invoke(menuPopupHelper, true);
                        break;
                    }
                }
            } catch (Throwable e) {
                e.printStackTrace();
            }
        }

        @Override
        public int getItemCount() {
            return mWishlistImageUri.size();
        }
    }
}



