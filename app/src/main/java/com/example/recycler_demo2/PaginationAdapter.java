package com.example.recycler_demo2;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class PaginationAdapter extends RecyclerView.Adapter<PaginationAdapter.ViewHolder> {

    List<Modals> list;

    public PaginationAdapter(List<Modals> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.row_item, viewGroup,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        Modals model = list.get(i);
        viewHolder.tv_name.setText(model.getFood_Name());
        viewHolder.tv_address.setText(model.getAddress());
        viewHolder.tv_review.setText(model.getReviews());
        viewHolder.tv_date.setText(model.getDate());
        viewHolder.tv_price.setText(model.getPrice());
        viewHolder.imageView.setImageResource(model.getImage());
        viewHolder.ratingBar.setRating(model.getRating());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView tv_name, tv_address, tv_review, tv_date, tv_price;
        CircleImageView imageView;
        RatingBar ratingBar;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_name = itemView.findViewById(R.id.TV1);
            tv_address = itemView.findViewById(R.id.TV2);
            tv_review = itemView.findViewById(R.id.TV3);
            tv_date = itemView.findViewById(R.id.TV4);
            tv_price = itemView.findViewById(R.id.TV5);
            imageView = itemView.findViewById(R.id.image);
            ratingBar = itemView.findViewById(R.id.rating);

        }
    }
}
