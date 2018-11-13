package czzz.luhau.myapplication.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import czzz.luhau.myapplication.Model.Bread;
import czzz.luhau.myapplication.R;

public class Bread_Adapter extends RecyclerView.Adapter<MyViewHolder> {
    Context c;
    ArrayList<Bread> list_bread;

    public Bread_Adapter(Context c, ArrayList<Bread> list_bread) {
        this.c = c;
        this.list_bread = list_bread;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view  = LayoutInflater.from(c).inflate(R.layout.one_items,viewGroup,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int i) {
        Bread bread = list_bread.get(i);

        holder.name.setText(bread.getName());
        holder.price.setText(bread.getPrice());
        Picasso.get().load(bread.getImage()).into(holder.image);
    }

    @Override
    public int getItemCount() {
        return list_bread.size();
    }
}
