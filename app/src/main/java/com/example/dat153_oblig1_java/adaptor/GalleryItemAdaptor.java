package com.example.dat153_oblig1_java.adaptor;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dat153_oblig1_java.Database.Entry;
import com.example.dat153_oblig1_java.R;

import java.util.Arrays;
import java.util.List;

public class GalleryItemAdaptor extends RecyclerView.Adapter<GalleryItemAdaptor.GalleryViewHolder> {

    private Context context;
    private List<Entry> entries;

    public GalleryItemAdaptor(Context context, LiveData<List<Entry>> entries) {
        this.context = context;
        this.entries = entries.getValue();
    }

    @NonNull
    @Override
    public GalleryItemAdaptor.GalleryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.recycler_view_entry, parent, false);
        return new GalleryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull GalleryItemAdaptor.GalleryViewHolder holder, int position) {
        List<String> defaultEntries = Arrays.asList("horse", "dog", "cat");
        Entry entry = entries.get(position);
        holder.entryImg.setImageURI(entry.getImgUri());
        holder.entryName.setText(entry.getAnswer());
        if (defaultEntries.contains(entry.getAnswer())) {
            holder.deleteButton.setVisibility(View.INVISIBLE);
        }
    }

    @Override
    public int getItemCount() {
        return entries.size();
    }

    public static class GalleryViewHolder extends RecyclerView.ViewHolder {

        ImageView entryImg;
        TextView entryName;
        View deleteButton;

        public GalleryViewHolder(@NonNull View itemView) {
            super(itemView);

            entryImg = itemView.findViewById(R.id.gallery_recycler_view_img);
            entryName = itemView.findViewById(R.id.gallery_recycle_view_name);
            deleteButton = itemView.findViewById(R.id.gallery_recycle_view_delete_button);


        }
    }
}
