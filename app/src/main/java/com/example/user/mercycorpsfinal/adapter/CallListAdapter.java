package com.example.user.mercycorpsfinal.adapter;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.RecyclerView;
import android.telephony.SmsManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.user.mercycorpsfinal.R;
import com.example.user.mercycorpsfinal.model.Contact;

import java.util.List;

/**
 * Created by root on 7/26/17.
 */
public class CallListAdapter extends RecyclerView.Adapter<CallListAdapter.MyViewHolder>{
    private List<Contact> contactList;
    private Context context;


    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView name, phone;
        ImageButton call,mail;

        public MyViewHolder(View view) {
            super(view);
            name = (TextView) view.findViewById(R.id.name);
            phone = (TextView) view.findViewById(R.id.phone);
            call = (ImageButton) view.findViewById(R.id.call);
            mail=(ImageButton)view.findViewById(R.id.mail);
        }
    }

    public CallListAdapter(Context context, List<Contact> list){
        this.context=context;
        this.contactList=list;
    }
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.single_row, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        final Contact contact=contactList.get(position);
        holder.name.setText(contact.getName());
        holder.phone.setText(contact.getPhone());
        holder.call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                giveCall(contact.getPhone());
            }
        });
        holder.mail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendMail(contact);
            }
        });
    }


    @Override
    public int getItemCount() {
        return contactList.size();
    }

    public void giveCall(String phone){
         Intent callIntent = new Intent(Intent.ACTION_CALL);
               callIntent.setData(Uri.parse("tel:" + phone));
               if (ActivityCompat.checkSelfPermission(context, android.Manifest.permission.CALL_PHONE) !=
                       PackageManager.PERMISSION_GRANTED) {
                   return;
               }
        callIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
               context.startActivity(callIntent);
    }

    public void sendMail(final Contact contact){
        final EditText msgBody = new EditText(context);

        msgBody.setHint("Enter message");

        new AlertDialog.Builder(context)
                .setTitle("Message")
                .setMessage("\n"+"To: "+contact.getPhone())
                .setView(msgBody)
                .setPositiveButton("Send", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int whichButton) {
                        String message = msgBody.getText().toString();
                        Log.e("TAG", "onClick: "+message );
                        SmsManager sms = SmsManager.getDefault();
                        sms.sendTextMessage(contact.getPhone(), null, message, null, null);
                    }
                })
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int whichButton) {
                    }
                })
                .show();


    }
}
