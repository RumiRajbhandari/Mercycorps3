package com.mercycorps.ews;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;


import com.mercycorps.ews.activity.AboutUsActivity;
import com.mercycorps.ews.activity.ApatkalinAwasthaActivity;
import com.mercycorps.ews.activity.CommunicationActivity;
import com.mercycorps.ews.activity.ThresholdActivity;
import com.mercycorps.ews.fragments.ClusterFragment;
import com.mercycorps.ews.fragments.DHMFragment;
import com.mercycorps.ews.fragments.EWSResponse;
import com.mercycorps.ews.fragments.EmergencyNumbers;
import com.mercycorps.ews.fragments.GaugeReaderFragment;
import com.mercycorps.ews.fragments.MapFragment;

import java.util.ArrayList;
import java.util.List;

import pub.devrel.easypermissions.AfterPermissionGranted;
import pub.devrel.easypermissions.EasyPermissions;

public class MainActivity extends AppCompatActivity {
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    ActionBarDrawerToggle toggle;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private Toolbar toolbar;
    ImageView img_drawer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        requestPermissionForMaps();
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(false);
        viewPager = (ViewPager) findViewById(R.id.viewpager);
        setupViewPager(viewPager);
        drawerLayout = (DrawerLayout)findViewById(R.id.drawer);
        navigationView = (NavigationView)findViewById(R.id.navigation);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {

            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem) {
                menuItem.setChecked(true);
                Intent intent;
                switch (menuItem.getItemId()){
                    case  R.id.home:
                        intent =new Intent(MainActivity.this, MainActivity.class);
                        startActivity(intent);
                        break;
                    case R.id.apatkalin:
                        intent =new Intent(MainActivity.this, ApatkalinAwasthaActivity.class);
                        startActivity(intent);
                        break;
                    case R.id.dhmTollFree:
                        Intent callIntent = new Intent(Intent.ACTION_CALL);
                        callIntent.setData(Uri.parse("tel:" + "1155"));
                        if (ActivityCompat.checkSelfPermission(MainActivity.this, android.Manifest.permission.CALL_PHONE) !=
                                PackageManager.PERMISSION_GRANTED) {

                        }
                        callIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        startActivity(callIntent);
                        break;

                    case R.id.commCha:
                        intent=new Intent(MainActivity.this, CommunicationActivity.class);
                        startActivity(intent);
                        break;
                    case R.id.AboutUs:
                        intent=new Intent(MainActivity.this, AboutUsActivity.class);
                        startActivity(intent);
                        break;
                    case R.id.threshold:
                        intent=new Intent(MainActivity.this, ThresholdActivity.class);
                        startActivity(intent);
                        break;





                }

                return false;
            }
        });
        toggle = new ActionBarDrawerToggle(this, drawerLayout,toolbar,R.string.drawer_open, R.string.drawer_close) {

            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
                getSupportActionBar().setTitle(R.string.app_name);
            }

            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
                getSupportActionBar().setTitle(R.string.app_name);

            }
        };
        drawerLayout.setDrawerListener(toggle);
        toggle.syncState();

        tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);

    }
    @AfterPermissionGranted(1)
    public void requestPermissionForMaps() {

        String[] perms = {Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.ACCESS_FINE_LOCATION,Manifest.permission.CALL_PHONE};
        if (EasyPermissions.hasPermissions(this, perms)) {

        }
        else
        {
            EasyPermissions.requestPermissions(this, "App needs permission to show Maps", 1, perms);
        }

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        EasyPermissions.onRequestPermissionsResult(requestCode, permissions, grantResults, this);
    }

    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new MapFragment(), "नक्सा");
        adapter.addFragment(new EWSResponse(), "पूर्व सूचना प्रणाली प्रतिकार्य  ");
        adapter.addFragment(new DHMFragment()," जल तथा  मौसम बिज्ञान बिभाग  ");
        adapter.addFragment(new EmergencyNumbers(),"आपत्कालिन नम्बर");
        adapter.addFragment(new ClusterFragment(),"क्षेत्रगत समूह ");
        adapter.addFragment(new GaugeReaderFragment(),"अवलोकन कर्ता");
        viewPager.setAdapter(adapter);
    }

    /*@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.my_menu, menu);
        return true;
    }*/

   /* @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent intent = new Intent(MainActivity.this, AboutUsActivity.class);
        startActivity(intent);
        // return true;

//
        return super.onOptionsItemSelected(item);
    }*/
}

class ViewPagerAdapter extends FragmentPagerAdapter {
    private final List<Fragment> mFragmentList = new ArrayList<>();
    private final List<String> mFragmentTitleList = new ArrayList<>();

    public ViewPagerAdapter(FragmentManager manager) {
        super(manager);
    }

    @Override
    public Fragment getItem(int position) {
        return mFragmentList.get(position);
    }

    @Override
    public int getCount() {
        return mFragmentList.size();
    }

    public void addFragment(Fragment fragment, String title) {
        mFragmentList.add(fragment);
        mFragmentTitleList.add(title);
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mFragmentTitleList.get(position);
    }


}

