package com.mercycorps.ews.utils

import android.content.Context
import android.content.Intent
import android.net.Uri

fun giveCallTo(context: Context, phoneNo: String) {
    val callIntent = Intent()
    callIntent.apply {
        action = Intent.ACTION_DIAL
        data = Uri.parse("tel:$phoneNo")
        flags = Intent.FLAG_ACTIVITY_NEW_TASK
    }
    context.startActivity(callIntent)
}

fun sendMessage(context: Context, phoneNo: String, message: String){
    val intent = Intent().apply {
        action = Intent.ACTION_SENDTO
        data = Uri.parse("smsto:$phoneNo")
        flags = Intent.FLAG_ACTIVITY_NEW_TASK
        putExtra("sms_body", message)
    }
    if (intent.resolveActivity(context.packageManager) != null) {
        context.startActivity(intent)
    }
}