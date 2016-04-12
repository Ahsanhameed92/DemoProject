package com.ahsan.demoapplication;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ahsan.demoapplication.data.DataObject;

import java.util.List;

/**
 * Created by Vengile on 4/12/2016.
 */

public class NamesListAdapter extends RecyclerView.Adapter<NamesListAdapter.MyViewHolder> {

    private final List<DataObject> dataSet;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public final TextView firstName;
        public final TextView lastName;

        public MyViewHolder(View view) {
            super(view);
            firstName = (TextView) view.findViewById(R.id.first_name);
            lastName = (TextView) view.findViewById(R.id.last_name);
        }
    }


    public NamesListAdapter(List<DataObject> dataSet) {
        this.dataSet = dataSet;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.layout_name_list_row, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        DataObject movie = dataSet.get(position);
        holder.lastName.setText(movie.getLastName()+",");
        holder.firstName.setText(movie.getFirstName());

    }

    @Override
    public int getItemCount() {
        return dataSet == null ? 0 : dataSet.size();
    }
}