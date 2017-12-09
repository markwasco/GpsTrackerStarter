package com.blinkymap.gpslocationlist.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.blinkymap.gpslocationlist.R;

/**
 * Created by markw on 12/2/2017.
 */

public class LatLongAdapter extends RecyclerView.Adapter<LatLongAdapter.LatLongViewHolder> {

    private String[] mLocation;

    public LatLongAdapter(String[] location) {
        mLocation = location;
    }

    @Override
    public LatLongViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.lat_long_list_layout, parent, false);
        LatLongViewHolder viewHolder = new LatLongViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(LatLongViewHolder holder, int position) {
        holder.bindLatLong(mLocation[position]);
    }

    @Override
    public int getItemCount() {
        return mLocation.length;
    }

    public class LatLongViewHolder extends RecyclerView.ViewHolder {

        public TextView mLatitudeLongitudeLabel;

        public LatLongViewHolder(View itemView) {
            super(itemView);

            mLatitudeLongitudeLabel = (TextView) itemView.findViewById(R.id.latLongLabel);
        }

        public void bindLatLong(String location) {
            mLatitudeLongitudeLabel.setText(location + "");
        }
    }
}
