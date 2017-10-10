package proj.productgallery.category;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import proj.productgallery.R;
import proj.productgallery.wishlist.DialogWish;


public class GridviewAdapter extends BaseAdapter {

    Context context;

    ArrayList<Beanclass> bean;
//    Typeface fonts1, fonts2;


    public GridviewAdapter(Context context, ArrayList<Beanclass> bean) {
        this.bean = bean;
        this.context = context;
    }

    @Override
    public int getCount() {
        return bean.size();
    }

    @Override
    public Object getItem(int position) {
        return bean.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

//        fonts1 = Typeface.createFromAsset(context.getAssets(),
//                "fonts/Lato-Light.ttf");
//
//        fonts2 = Typeface.createFromAsset(context.getAssets(),
//                "fonts/Lato-Regular.ttf");

        ViewHolder viewHolder = null;

        if (convertView == null) {
            LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(R.layout.gridview2, null);

            viewHolder = new ViewHolder();

            viewHolder.image1 = (ImageView) convertView.findViewById(R.id.image1);
            viewHolder.title1 = (TextView) convertView.findViewById(R.id.title1);
            viewHolder.discription1 = (TextView) convertView.findViewById(R.id.description1);
            viewHolder.date1 = (TextView) convertView.findViewById(R.id.date1);
            viewHolder.ic_wishlist = (ImageView) convertView.findViewById(R.id.ic_wishlist);

//            viewHolder.title1.setTypeface(fonts2);
//            viewHolder.discription1.setTypeface(fonts1);
//            viewHolder.date1.setTypeface(fonts2);

            convertView.setTag(viewHolder);


        } else {

            viewHolder = (ViewHolder) convertView.getTag();
        }


        Beanclass bean = (Beanclass) getItem(position);

        viewHolder.image1.setImageResource(bean.getImage1());
        viewHolder.title1.setText(bean.getTitle1());
        viewHolder.discription1.setText(bean.getDiscription1());
        viewHolder.date1.setText(bean.getDate1());
        final ViewHolder finalViewHolder = viewHolder;
        viewHolder.ic_wishlist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*ImageUrlUtils imageUrlUtils = new ImageUrlUtils();
                imageUrlUtils.addWishlistImageUri(mValues[position]);*/
                //add category
                finalViewHolder.ic_wishlist.setImageResource(R.mipmap.ic_favorite_black_18dp);
                notifyDataSetChanged();

                Intent intent=new Intent(context, DialogWish.class);
                context.startActivity(intent);;
                Toast.makeText(context,"Item added to wishlist.",Toast.LENGTH_SHORT).show();

            }
        });

        return convertView;
    }

    private class ViewHolder {
        ImageView image1;
        TextView title1;
        TextView discription1;
        TextView date1;
        ImageView ic_wishlist;

    }
}







//package ws.wolfsoft.get_detail;
//
//import android.app.Activity;
//import android.content.Context;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.BaseAdapter;
//import android.widget.ImageView;
//
//import java.util.ArrayList;
//
///**
// * Created by Rp on 3/30/2016.
// */
//public class GridviewAdapter extends BaseAdapter {
//
//    Context context;
//    ArrayList<Beanclass> beans;
//
//    public GridviewAdapter(Context context,ArrayList<Beanclass> beans) {
//        this.beans = beans;
//        this.context = context;
//    }
//
//
//
//
//    @Override
//    public int getCount() {
//        return beans.size();
//    }
//
//    @Override
//    public Object getItem(int position) {
//        return beans.get(position);
//    }
//
//    @Override
//    public long getItemId(int position) {
//        return position;
//    }
//
//    @Override
//    public View getView(int position, View convertView, ViewGroup parent) {
//
//        ViewHolder viewHolder = null;
//        if (convertView == null){
//
//            LayoutInflater layoutInflater = (LayoutInflater)context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
//
//            viewHolder = new ViewHolder();
//
//            convertView = layoutInflater.inflate(R.layout.gridview,null);
//
//
//            viewHolder.image= (ImageView)convertView.findViewById(R.id.image);
//
//
//
//
//            convertView.setTag(viewHolder);
//
//
//        }else {
//
//            viewHolder = (ViewHolder)convertView.getTag();
//
//        }
//
//
//        Beanclass beans = (Beanclass)getItem(position);
//
//        viewHolder.image.setImageResource(beans.getImage());
//        return convertView;
//    }
//
//    private class ViewHolder{
//        ImageView image;
//
//
//    }
//
//}
