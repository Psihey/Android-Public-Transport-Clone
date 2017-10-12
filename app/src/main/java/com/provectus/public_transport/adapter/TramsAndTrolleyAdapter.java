package com.provectus.public_transport.adapter;

import android.support.v7.widget.AppCompatCheckBox;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import com.provectus.public_transport.R;
import com.provectus.public_transport.eventbus.BusEvents;
import com.provectus.public_transport.model.TransportEntity;

import org.greenrobot.eventbus.EventBus;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class TramsAndTrolleyAdapter extends RecyclerView.Adapter<TramsAndTrolleyAdapter.TramsAndTrolleyViewHolder> {
    private List<TransportEntity> mTransportRoutesData;

    public TramsAndTrolleyAdapter(List<TransportEntity> data) {
        this.mTransportRoutesData = data;
    }

    @Override
    public TramsAndTrolleyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View rootView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_bundle_tram_trolleybus, parent, false);

        return new TramsAndTrolleyViewHolder(rootView);
    }

    @Override
    public void onBindViewHolder(TramsAndTrolleyViewHolder holder, int position) {
        final TransportEntity transportRoutes = mTransportRoutesData.get(position);
        holder.mTvRoutesNumber.setText(String.valueOf(mTransportRoutesData.get(position).getNumber()));

        holder.mCheckBoxSelectRout.setOnCheckedChangeListener(null);
        holder.mCheckBoxSelectRout.setChecked(transportRoutes.isSelected());
        holder.mCheckBoxSelectRout.setOnCheckedChangeListener((buttonView, isChecked) -> transportRoutes.setIsSelected(isChecked));
        if (!transportRoutes.isAvailable()){
            holder.mCheckBoxSelectRout.setVisibility(View.INVISIBLE);
        }else  holder.mCheckBoxSelectRout.setVisibility(View.VISIBLE);
        holder.mCheckBoxSelectRout.setOnClickListener(view -> EventBus.getDefault().post(new BusEvents.SendChosenRoute(transportRoutes)));
        holder.mImageButtonRouteInfo.setOnClickListener(v ->EventBus.getDefault().post(new BusEvents.OpenRouteInformation(transportRoutes)));

    }

    @Override
    public int getItemCount() {
        return mTransportRoutesData.size();
    }

    class TramsAndTrolleyViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.text_view_number_routes)
        TextView mTvRoutesNumber;
        @BindView(R.id.checkbox_select_rout)
        AppCompatCheckBox mCheckBoxSelectRout;
        @BindView(R.id.image_button_route_info)
        ImageButton mImageButtonRouteInfo;

        TramsAndTrolleyViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

}
