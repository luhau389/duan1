package czzz.luhau.myapplication.Adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import czzz.luhau.myapplication.R;

public class MyViewHolder extends RecyclerView.ViewHolder{
    public ImageView image;
    public TextView name,price;
    public MyViewHolder(View view)
    {
        super(view);
        this.image= view.findViewById(R.id.breadImage);
        this.name= view.findViewById(R.id.breadnameTxt);
        this.price= view.findViewById(R.id.breadpriceTxt);
    }
}

