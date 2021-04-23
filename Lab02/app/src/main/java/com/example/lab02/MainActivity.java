package com.example.lab02;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.icu.text.IDNA;
import android.location.*;
import android.net.sip.SipSession;
import android.provider.Settings;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.core.app.ActivityCompat;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    LocationManager locationManager;
    TextView textView;
    String bestProvider;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView=findViewById(R.id.tv);

        //1.获取LocationManager
        LocationManager locationManager =
                (LocationManager) getSystemService(Context.LOCATION_SERVICE);

        //如果GPS 和移动基站Provider都可以,取最好的
        if (locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER)||
                (locationManager.isProviderEnabled(locationManager.NETWORK_PROVIDER))) {
            bestProvider = locationManager.getBestProvider(getCriteria(), true);
            if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)
                    != PackageManager.PERMISSION_GRANTED &&
                    ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION)
                            != PackageManager.PERMISSION_GRANTED) {
                return;
            }
            //返回上一次的定位数据
            Location location=locationManager.getLastKnownLocation(bestProvider);
            //更新页面
            updateView(location);
            //设置locationManager监听器
            locationManager.requestLocationUpdates(bestProvider,1000,1,listener);
        }else {
            Toast.makeText(this, "请开启GPS导航...", Toast.LENGTH_SHORT).show();

            Intent intent=new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivityForResult(intent,0);

        }
    }

        LocationListener listener=new LocationListener() {
            @Override
            public void onLocationChanged(Location arg0) {
                updateView(arg0);
            }

            @Override
            public void onStatusChanged(String arg0, int arg1, Bundle arg2) {

            }

            @Override
            public void onProviderEnabled(String arg0) {
                if (ActivityCompat.checkSelfPermission(MainActivity.this, Manifest.permission.ACCESS_FINE_LOCATION)
                        != PackageManager.PERMISSION_GRANTED &&
                        ActivityCompat.checkSelfPermission(MainActivity.this, Manifest.permission.ACCESS_COARSE_LOCATION)
                                != PackageManager.PERMISSION_GRANTED) {
                    return;
                }
                Location location=locationManager.getLastKnownLocation(bestProvider);
                updateView(location);
            }

            @Override
            public void onProviderDisabled(String arg0) {
                updateView(null);
            }
        };




    private void updateView (final Location location){
        final StringBuilder sb=new StringBuilder();

        //location 显示内容，
                new Thread(new Runnable() {
                    @Override public void run() {
                        //需要执行的代码
                //Address 显示内容，根据需要显示
                Address address=getAddress(MainActivity.this,
                        location.getLatitude(),
                        location.getLongitude());

                if (location!=null) {

                    sb.append("设备的经度："+location.getLongitude()+"\n");
                    sb.append("设备的纬度："+location.getLatitude()+"\n");
                    sb.append("设备的海拔："+location.getAltitude()+"\n");
                    sb.append("设备的时间："+location.getTime()+"\n");
                    sb.append("得到的方式："+location.getProvider());
                    textView.setText(sb.toString());
                }else {
                    textView.setText("location is null");
                }

                 } }).start();
            }

    private Criteria getCriteria(){
        Criteria criteria = new Criteria();
        criteria.setAccuracy(Criteria.ACCURACY_FINE);//设置定位精准度
        criteria.setAltitudeRequired(false);//是否要求海拔
        criteria.setBearingRequired(true);//是否要求方向
        criteria.setCostAllowed(true);//是否要求收费
        criteria.setSpeedRequired(true);//是否要求速度
        criteria.setPowerRequirement(Criteria.NO_REQUIREMENT);//设置电池耗电要求
        criteria.setBearingAccuracy(Criteria.ACCURACY_HIGH);//设置方向精确度
        criteria.setSpeedAccuracy(Criteria.ACCURACY_HIGH);//设置速度精确度
        criteria.setHorizontalAccuracy(Criteria.ACCURACY_HIGH);//设置水平方向精确度
        criteria.setVerticalAccuracy(Criteria.ACCURACY_HIGH);//设置垂直方向精确度
        return criteria;
    }
    private static Address getAddress(Context c,double latitude, double longitude){

        Geocoder geocoder=new Geocoder(c, Locale.getDefault());
        try {
            List<Address> address=geocoder.getFromLocation(latitude,longitude,1);
            if (address.size()>0){
                return address.get(0);
            }
        }catch (IOException e){
            e.printStackTrace();
        }
        return null;
    }
//    private Location getLastKnownLocation() {
//        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)
//                != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION)
//                != PackageManager.PERMISSION_GRANTED) {
//            return null;
//        }
//        LocationManager locationManager = (LocationManager) getSystemService(LOCATION_SERVICE);
//        List<String> providers = locationManager.getAllProviders();
//        Location bestlocation = null;
//        for (String provider : providers) {
//            Location l = locationManager.getLastKnownLocation(provider);
//            if (l == null) {
//                continue;
//            }
//            if (bestlocation == null || l.getAccuracy() < bestlocation.getAccuracy()) {
//                bestlocation = l;
//            }
//        }
//        return bestlocation;
//    }
}










