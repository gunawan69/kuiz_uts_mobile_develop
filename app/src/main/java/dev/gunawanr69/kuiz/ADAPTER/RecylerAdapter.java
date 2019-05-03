package dev.gunawanr69.kuiz.ADAPTER;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import dev.gunawanr69.kuiz.MODEL.DataModel;
import dev.gunawanr69.kuiz.MainActivity;
import dev.gunawanr69.kuiz.R;


public class RecylerAdapter extends
        RecyclerView.Adapter<RecylerAdapter.MyHolder> {
    List<DataModel> mList ;
    Context ctx;
    public RecylerAdapter(Context ctx, List<DataModel> mList) {
        this.mList = mList;
        this.ctx = ctx;
    }
    @Override
    public RecylerAdapter.MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View layout = LayoutInflater.from(parent.getContext()).inflate(R.layout.layoutlist,
                parent, false);
        MyHolder holder = new MyHolder(layout);
        return holder;
    }
    @Override
    public void onBindViewHolder(RecylerAdapter.MyHolder holder,
                                 final int position) {
        holder.kode.setText(mList.get(position).getKode());
        holder.nama.setText(mList.get(position).getNama());
        holder.url.setText(mList.get(position).getUrl());
        holder.pemilik.setText(mList.get(position).getPemilik());
        holder.itemView.setOnClickListener(new View.OnClickListener()
        {

            @Override
            public void onClick(View view) {
                Intent goInput = new Intent(ctx, MainActivity.class);
                try {
                    goInput.putExtra("id",
                            mList.get(position).getId());
                    goInput.putExtra("kode",
                            mList.get(position).getKode());
                    goInput.putExtra("nama",
                            mList.get(position).getNama());
                    goInput.putExtra("url",
                            mList.get(position).getUrl());
                    goInput.putExtra("pemilik",
                            mList.get(position).getPemilik());
                    ctx.startActivity(goInput);
                }catch (Exception e){
                    e.printStackTrace();
                    Toast.makeText(ctx, "Error data " +e,
                            Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    @Override
    public int getItemCount()
    {
        return mList.size();
    }
    public class MyHolder extends RecyclerView.ViewHolder {
        TextView nama,kode, url, pemilik;
        DataModel dataModel;
        public MyHolder(View v)
        {
            super(v);
            kode = (TextView) v.findViewById(R.id.tvKode);
            nama = (TextView) v.findViewById(R.id.tvNama);
            url = (TextView) v.findViewById(R.id.tvUrl);
            pemilik= (TextView) v.findViewById(R.id.tvPemilik);
        }
    }
}

