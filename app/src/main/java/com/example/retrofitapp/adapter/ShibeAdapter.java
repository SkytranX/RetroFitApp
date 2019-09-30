package com.example.retrofitapp.adapter;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.bumptech.glide.Glide;
import com.example.retrofitapp.R;

import java.util.List;

public class ShibeAdapter extends RecyclerView.Adapter<ShibeAdapter.ShibeViewHolder> {
    //Declare/Creating list in ShibeAdapter
    private List<String> shibeUrls;

    private Context context;
    // passing in List<String> labeling it shibeUrls into ShibeAdapter
    public ShibeAdapter(List<String> shibeUrls) {
        this.shibeUrls = shibeUrls;
        //assigning new label to this. shibeUrls to shibeUrls
    }

    @NonNull
    @Override
    public ShibeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        // creating a View and assigning it shibe_item which is passed into
        // LayoutINflator().inflate() method
        View view = LayoutInflater.from(context).inflate(

                R.layout.shibe_item,
                parent,
                false);

        // is returned ShibeViewHolder = shibe_item(view)
        return new ShibeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ShibeViewHolder holder, int position) {
      // Binding ViewHolders
        String shibeUrl = shibeUrls.get(position);

        Glide.with(context)
                .load(shibeUrl)
                .circleCrop()
                .into(holder.ivShibeImage)
                ;
    }

    @Override
    public int getItemCount() {
       // returns shibeUrl's layout size
        return shibeUrls.size();
    }

    class ShibeViewHolder extends RecyclerView.ViewHolder {
        ImageView ivShibeImage;
        //Declaring ImageView labeling it to ivShibeImage
        ShibeViewHolder(@NonNull View itemView) {
            super(itemView);
            // initializing ivShibeImage using itemView.findViewById to iv_shibe_image
            ivShibeImage = itemView.findViewById(R.id.iv_shibe_image);

        }
    }
}