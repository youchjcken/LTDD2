package com.example.myapplication;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;


import java.util.ArrayList;
import java.util.Objects;

public class NhanVienAdapter extends RecyclerView.Adapter<NhanVienAdapter.MyViewHolder> {

    Context context;
    ArrayList<NhanVien> data;
    int layoutID;
    public static final int Nam = 0;
    public static final int Nu = 1;

    public NhanVienAdapter(Context context, ArrayList<NhanVien> data, int layoutID) {
        this.context = context;
        this.data = data;
        this.layoutID = layoutID;
    }


    public int getItemViewType(int position) {
        if (position % 3 == 0)
            return Nu;
        else
            return Nam;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        RadioButton rbtNam = null;
        RadioButton rbtNu = null;
        LayoutInflater inflater = ((Activity) context).getLayoutInflater();
        View row = inflater.inflate(layoutID, viewGroup, false);
        switch (i) {
            case Nam:
                row = inflater.inflate(R.layout.activity_nhan_vien, viewGroup, false);
                break;


            case Nu:

                row = inflater.inflate(R.layout.activity_nhan_vien2, viewGroup, false);

                break;
        }


        return new MyViewHolder(row);
    }

    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder viewHolder, final int i) {
        viewHolder.tenNV.setText(data.get(i).getTenNV());
        viewHolder.maNV.setText(data.get(i).getMaNV());
        viewHolder.img.setImageResource(data.get(i).getImg());

        viewHolder.img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                removeItem(i);
            }
        });

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        ImageView img;
        TextView tenNV, maNV;
        TextView Delete;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            tenNV = itemView.findViewById(R.id.tennv);
            maNV = itemView.findViewById(R.id.manv);
            img = itemView.findViewById(R.id.img);;
        }
    }

    public void removeItem(int position) {
        data.remove(position);
        notifyDataSetChanged();

    }

}
