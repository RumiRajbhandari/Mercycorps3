package com.example.user.mercycorpsfinal.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.TextView;

import com.example.user.mercycorpsfinal.R;

public class AboutUsActivity extends AppCompatActivity {
    Toolbar toolbar;
    TextView tvMercyLInk,tvSushmaLink,tvRumiLink;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_us);
        toolbar = (Toolbar) findViewById(R.id.toolbar2);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        tvMercyLInk=(TextView)findViewById(R.id.mercy_link);
        tvMercyLInk.setText(R.string.mercy_link);
        tvMercyLInk.setMovementMethod(LinkMovementMethod.getInstance());

        tvSushmaLink=(TextView)findViewById(R.id.sushma_link);
        tvSushmaLink.setText(R.string.sushma_link);
        tvSushmaLink.setMovementMethod(LinkMovementMethod.getInstance());
        tvRumiLink=(TextView)findViewById(R.id.rumi_link);
        tvRumiLink.setText(R.string.rumi_link);
        tvRumiLink.setMovementMethod(LinkMovementMethod.getInstance());

    }
}
