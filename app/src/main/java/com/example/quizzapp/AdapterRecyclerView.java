package com.example.quizzapp;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;

import java.util.List;

public class AdapterRecyclerView extends RecyclerView.Adapter<AdapterRecyclerView.ViewHolder> {

    private List<ItemObjectKelas> SubjectValues;
    private Context context;

    AdapterRecyclerView(Context context1, List<ItemObjectKelas> SubjectValues1) {

        SubjectValues = SubjectValues1;
        context = context1;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView textView;
        ImageView imageView;
        LinearLayout parentLayout;

        ViewHolder(final View v) {

            super(v);
            textView = v.findViewById(R.id.textItem);
            imageView = v.findViewById(R.id.imgItem);
            parentLayout = v.findViewById(R.id.parent_layout);

        }

    }



    @NonNull
    @Override
    public AdapterRecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.list_item, parent, false);
        return new ViewHolder(view);
    }


    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        holder.textView.setText(SubjectValues.get(position).namaKelas);
        holder.parentLayout.setOnClickListener( view -> {
            Intent intent = new Intent(context, QuizClass.class);
            intent.putExtra("KELAS", SubjectValues.get(position).namaKelas);
            context.startActivity(intent);
        });

        Glide.with(context).load(SubjectValues.get(position).namaKelas).placeholder(SubjectValues.get(position).imgKelas).into(holder.imageView);

    }

    @Override
    public int getItemCount() {

        return SubjectValues.size();
    }
}
