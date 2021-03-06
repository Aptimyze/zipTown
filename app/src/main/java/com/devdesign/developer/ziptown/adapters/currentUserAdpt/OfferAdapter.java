package com.devdesign.developer.ziptown.adapters.currentUserAdpt;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.devdesign.developer.ziptown.activities.CurrentUserActivity;
import com.devdesign.developer.ziptown.activities.LoginActivity;
import com.devdesign.developer.ziptown.models.mockerClasses.Offer;
import com.devdesign.developer.ziptown.R;
import com.devdesign.developer.ziptown.connection.ServerRequest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OfferAdapter extends RecyclerView.Adapter<OfferAdapter.OfferViewHolder> implements ServerRequest.OnTaskCompleted {
    private final Context context;
    private List<Offer> offersList;
    @NonNull
    @Override
    public OfferViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.private_user_offers, parent, false);
        return new OfferViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull OfferViewHolder holder, final int position) {
        final Offer offer = offersList.get(position);
        holder.ttvCity.setText("City: " + CurrentUserActivity.titleCase(offer.getCity()));
        holder.ttvContact.setText("Contact: " + CurrentUserActivity.titleCase(offer.getContact()));
        holder.ttvCreated.setText("Posted on: " + CurrentUserActivity.titleCase(offer.getCreated()).split("T")[0]);
        holder.ttvDays.setText("Days: " + CurrentUserActivity.titleCase(offer.getDays()));
        holder.ttvOrigin.setText("Origin: " + CurrentUserActivity.titleCase(offer.getOrigin()));
        holder.ttvDestination.setText("Destination: " + CurrentUserActivity.titleCase(offer.getDestination()));
        holder.ttvPublisher.setText("Published by: " + CurrentUserActivity.titleCase(offer.getPublisher()));
        holder.ttvTime.setText("Time: " + offer.getTime().toLowerCase());
        holder.btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                offersList.remove(position);
                Map<String, Object> map =  new HashMap<>();
                map.put("type", "DeletePost");
                map.put("postType", offer.getPostType());
                map.put("id", offer.getPostId());
                LoginActivity.showProgress("Delete", "Deleting post "+offer.getPostId().toString()+" from server", context);
                new ServerRequest(OfferAdapter.this).execute(map);
                notifyDataSetChanged();
            }
        });

    }

    @Override
    public int getItemCount() {
        return offersList.size();
    }

    @Override
    public void onTaskCompleted() {
        LoginActivity.dismissProgress();
        notifyDataSetChanged();
    }

    @Override
    public void onDataFetched(Map<String, Object> object) {

    }

    @Override
    public void onTaskFailed() {

    }

    public class OfferViewHolder extends RecyclerView.ViewHolder {
        public TextView ttvPublisher, ttvContact, ttvCreated, ttvDays, ttvTime, ttvCity, ttvDestination, ttvOrigin;
        public Button btnDelete;
        public OfferViewHolder(View itemView) {
            super(itemView);

            ttvCity = itemView.findViewById(R.id.ttv_city);
            ttvDestination = itemView.findViewById(R.id.ttv_destination);
            ttvOrigin = itemView.findViewById(R.id.ttv_origin);
            ttvTime = itemView.findViewById(R.id.ttv_time);
            ttvDays = itemView.findViewById(R.id.ttv_days);
            ttvPublisher = itemView.findViewById(R.id.ttv_publisher);
            ttvContact = itemView.findViewById(R.id.ttv_contact);
            ttvContact = itemView.findViewById(R.id.ttv_contact);
            ttvCreated = itemView.findViewById(R.id.ttv_created);
            btnDelete = itemView.findViewById(R.id.btn_delete);


        }
    }
    public OfferAdapter(List<Offer> offers, Context context){
        this.offersList = offers;
        this.context = context;
    }

}
