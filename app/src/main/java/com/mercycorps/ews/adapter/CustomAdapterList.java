package com.mercycorps.ews.adapter;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.mercycorps.ews.R;
import com.mercycorps.ews.model.ListItem;

import java.util.List;

public class CustomAdapterList extends RecyclerView.Adapter<CustomAdapterList.CustomViewHolder> {
  private   List<ListItem> entityArrayList;

    private final OnItemClickListener listener;

    public interface OnItemClickListener {
        void onItemClick(ListItem item);
    }



    @Override
    public CustomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_item_list_item, parent, false);
        CustomViewHolder vh = new CustomViewHolder(v);
        return vh;


    }



    public CustomAdapterList(List<ListItem> entityArrayList, OnItemClickListener listener) {
        this.entityArrayList = entityArrayList;
        this.listener = listener;


    }

    @Override
    public void onBindViewHolder(CustomViewHolder holder, int position) {
        holder.bind(entityArrayList.get(position), listener);


    }

    @Override
    public int getItemCount() {
        return entityArrayList.size();

    }

    public static class CustomViewHolder extends RecyclerView.ViewHolder{
        public CardView cardView;
        public TextView tv_Org,tv_Name,tv_phoneNo,tv_mobNo;
        public CustomViewHolder(final View itemView) {
            super(itemView);

            cardView=(CardView)itemView.findViewById(R.id.card);
            tv_Org=(TextView)itemView.findViewById(R.id.txt_org);
            tv_Name=(TextView)itemView.findViewById(R.id.txt_person);
            tv_phoneNo=(TextView)itemView.findViewById(R.id.txt_phoneNo);
            tv_mobNo=(TextView)itemView.findViewById(R.id.txt_mobNo);





        }

        public void bind(final ListItem listItem, final OnItemClickListener listener) {


            if(listItem.getLandline()!=null && !listItem.getLandline().isEmpty())
            {
                tv_phoneNo.setVisibility(View.VISIBLE);
                tv_phoneNo.setText(listItem.getLandline());
            }
            else
            {
                tv_phoneNo.setVisibility(View.GONE);
            }
                if( listItem.getMob()!=null && !listItem.getMob().isEmpty()) {
                      tv_mobNo.setVisibility(View.VISIBLE);
                    tv_mobNo.setText(listItem.getMob());
                }
                else {
                    tv_mobNo.setVisibility(View.GONE);

                }

                    tv_Org.setText(listItem.getOrganization());
                    tv_Name.setText(listItem.getPerson());







            itemView.setOnClickListener(new View.OnClickListener() {
                @Override public void onClick(View v) {
                    listener.onItemClick(listItem);
                }
            });

    }
        }


}
