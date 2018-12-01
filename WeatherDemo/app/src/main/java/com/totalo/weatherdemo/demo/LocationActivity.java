package com.totalo.weatherdemo.demo;


import com.baidu.location.BDAbstractLocationListener;
import com.baidu.location.BDLocation;
import com.baidu.location.BDLocationListener;
import com.baidu.location.LocationClient;
import com.baidu.location.Poi;

import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.BitmapDescriptor;
import com.baidu.mapapi.map.BitmapDescriptorFactory;
import com.baidu.mapapi.map.MapPoi;
import com.baidu.mapapi.map.MapStatus;
import com.baidu.mapapi.map.MapStatusUpdate;
import com.baidu.mapapi.map.MapStatusUpdateFactory;
import com.baidu.mapapi.map.MapView;
import com.baidu.mapapi.map.MarkerOptions;
import com.baidu.mapapi.model.LatLng;

import com.totalo.weatherdemo.R;
import com.totalo.weatherdemo.service.HttpCallbackListener;
import com.totalo.weatherdemo.service.HttpTool;
import com.totalo.weatherdemo.service.LocationService;

import android.app.Activity;
import android.os.Bundle;
import android.text.Layout;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/***
 * 单点定位示例，用来展示基本的定位结果，配置在LocationService.java中
 * 默认配置也可以在LocationService中修改
 * 默认配置的内容自于开发者论坛中对开发者长期提出的疑问内容
 *
 * @author baidu
 *
 */
public class LocationActivity extends Activity {
    private LocationService locationService;
    private MapView mMapView = null;
    private BaiduMap mBaiduMap;
    private BitmapDescriptor bitmap;
    private String address = "";
    private double mCurrentLat = 0.0;
    private double mCurrentLon = 0.0;
    private LocationClient mLocClient;
    private TextView city_tv, address_tv;
    private Button dw_bt;
    //自定义布局
    private BitmapDescriptor bd_tmp;
    private StringBuilder add;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        // -----------demo view config ------------
        setContentView(R.layout.activity_main);
//        LocationResult1 = (TextView) findViewById(R.id.textView1);
//        LocationResult2 = (TextView) findViewById(R.id.textView2);
//        LocationResult1.setMovementMethod(ScrollingMovementMethod.getInstance());
//        imageView = findViewById(R.id.image);
        city_tv = (TextView) findViewById(R.id.city_tv);
        address_tv = (TextView) findViewById(R.id.address_tv);
        dw_bt=(Button)findViewById(R.id.dw_bt);
        // 获取地图控件引用
        mMapView = (MapView) findViewById(R.id.bmapView);
        mBaiduMap = mMapView.getMap();
        // 设置是否显示比例尺控件
        mMapView.showScaleControl(false);
        // 设置是否显示缩放控件
        mMapView.showZoomControls(true);
        // 设置是否显示定位按钮
        dw_bt.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                // 先清除图层
                mBaiduMap.clear();
                // 定义Maker坐标点
                Log.d("msg",mCurrentLat+" "+mCurrentLon);
                LatLng point = new LatLng(mCurrentLat, mCurrentLon);
                // 构建MarkerOption，用于在地图上添加Marker
                View v_tmp = LayoutInflater.from(getApplicationContext()).inflate(R.layout.marker,null);
                TextView tv_tmp = v_tmp.findViewById(R.id.add);
                ImageView imageView = v_tmp.findViewById(R.id.marker);
                tv_tmp.setText(add);
                imageView.setImageResource(R.drawable.dy);
                bd_tmp = BitmapDescriptorFactory.fromView(v_tmp);
                MarkerOptions options = new MarkerOptions().position(point)
                        .icon(bd_tmp).anchor(0.5f,1.0f);

                // 在地图上添加Marker，并显示
                mBaiduMap.addOverlay(options);
                LatLng cenpt =  new LatLng(mCurrentLat,mCurrentLon);
                //定义地图状态
                MapStatus mMapStatus = new MapStatus.Builder()
                        .target(cenpt)
                        .zoom(12)
                        .build();
                //定义MapStatusUpdate对象，以便描述地图状态将要发生的变化

                MapStatusUpdate mMapStatusUpdate = MapStatusUpdateFactory.newMapStatus(mMapStatus);
                //改变地图状态
                mBaiduMap.setMapStatus(mMapStatusUpdate);
            }
        });

    }

    /**
     * 显示请求字符串
     *
     * @param str
     */
//    public void logMsg(String str) {
//        final String s = str;
//        try {
//            if (LocationResult1 != null){
//                new Thread(new Runnable() {
//                    @Override
//                    public void run() {
//                        LocationResult1.post(new Runnable() {
//                            @Override
//                            public void run() {
//                                LocationResult1.setText(s);
//                            }
//                        });
//
//                    }
//                }).start();
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//    public void logMsg2(String str) {
//        final String s = str;
//        try {
//            if (LocationResult2 != null){
//                new Thread(new Runnable() {
//                    @Override
//                    public void run() {
//                        LocationResult2.post(new Runnable() {
//                            @Override
//                            public void run() {
//                                LocationResult2.setText(s);
//                            }
//                        });
//
//                    }
//                }).start();
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//    public void logImg(String str) {
//        final Integer value;
//        final String s = "w"+str+".png";
//        Class<?> cls = R.drawable.class;
//        try {
//            value = cls.getDeclaredField(s).getInt(null);
//            if (imageView != null){
//                new Thread(new Runnable() {
//                    @Override
//                    public void run() {
//                        imageView.post(new Runnable() {
//                            @Override
//                            public void run() {
//                                imageView.setImageResource(value);
//                            }
//                        });
//
//                    }
//                }).start();
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }


    /***
     * Stop location service
     */
    @Override
    protected void onStop() {
        // TODO Auto-generated method stub
        locationService.unregisterListener(mListener); //注销掉监听
        locationService.stop(); //停止定位服务
        super.onStop();
    }

    @Override
    protected void onStart() {
        // TODO Auto-generated method stub
        super.onStart();
        // -----------location config ------------
        locationService = ((LocationApplication) getApplication()).locationService;
        //获取locationservice实例，建议应用中只初始化1个location实例，然后使用，可以参考其他示例的activity，都是通过此种方式获取locationservice实例的
        locationService.registerListener(mListener);
        //注册监听
        int type = getIntent().getIntExtra("from", 0);
        if (type == 0) {
            locationService.setLocationOption(locationService.getDefaultLocationClientOption());
        } else if (type == 1) {
            locationService.setLocationOption(locationService.getOption());
        }
       // startLocation.setOnClickListener(new OnClickListener() {

//            @Override
//            public void onClick(View v) {
//                if (startLocation.getText().toString().equals(getString(R.string.startlocation))) {
                    locationService.start();// 定位SDK
                    // start之后会默认发起一次定位请求，开发者无须判断isstart并主动调用request
                    //startLocation.setText(getString(R.string.stoplocation));
        Toast.makeText(this,"开始定位",Toast.LENGTH_LONG).show();
                //} else {
                    locationService.stop();
        Toast.makeText(this,"定位完成",Toast.LENGTH_LONG).show();
                    //startLocation.setText(getString(R.string.startlocation));
               // }
            //}
        //});
    }


    /*****
     *
     * 定位结果回调，重写onReceiveLocation方法，可以直接拷贝如下代码到自己工程中修改
     *
     */
    private BDAbstractLocationListener mListener = new BDAbstractLocationListener() {

        @Override
        public void onReceiveLocation(BDLocation location) {
            // TODO Auto-generated method stub
            if (null != location && location.getLocType() != BDLocation.TypeServerError) {
                //final StringBuffer sb = new StringBuffer(256);
                add = new StringBuilder(256);
                //sb.append("time : ");
                /**
                 * 时间也可以使用systemClock.elapsedRealtime()方法 获取的是自从开机以来，每次回调的时间；
                 * location.getTime() 是指服务端出本次结果的时间，如果位置不发生变化，则时间不变
                 */
                mCurrentLat = location.getLatitude();
                mCurrentLon = location.getLongitude();
//                sb.append(location.getTime());
//                sb.append("\nlocType : ");// 定位类型
//                sb.append(location.getLocType());
//                sb.append("\nlocType description : ");// *****对应的定位类型说明*****
//                sb.append(location.getLocTypeDescription());
//                sb.append("\nlatitude : ");// 纬度
//                sb.append(location.getLatitude());
//                sb.append("\nlontitude : ");// 经度
//                sb.append(location.getLongitude());
//                sb.append("\nradius : ");// 半径
//                sb.append(location.getRadius());
//                sb.append("\nCountryCode : ");// 国家码
//                sb.append(location.getCountryCode());
//                sb.append("\nCountry : ");// 国家名称
//                sb.append(location.getCountry());
//                sb.append("\ncitycode : ");// 城市编码
//                sb.append(location.getCityCode());
//                sb.append("\ncity : ");// 城市
//                sb.append(location.getCity());
//                sb.append("\nDistrict : ");// 区
//                sb.append(location.getDistrict());
                add.append("地址：");
                add.append(location.getCity());
                add.append(location.getDistrict());
                add.append(location.getStreet());
                String url = "https://free-api.heweather.com/s6/weather/now?location="+location.getDistrict()+"&key=xx";
                HttpTool.sendGetRequest("GET", url, null, new HttpCallbackListener() {
                    @Override
                    public void onFinish(String response) throws JSONException {
                        StringBuffer sbs = new StringBuffer(256);
                        JSONObject jsonObject = new JSONObject(response);
                        JSONArray jsonArray1 = jsonObject.getJSONArray("HeWeather6");
                        JSONObject jb = jsonArray1.getJSONObject(0);
//                        sbs.append("云量：");
//                        sbs.append(jb.getString("cloud"));
//                        sbs.append("\n天气状况:");
//                        sbs.append(jb.getString("cond_txt"));
//                        sbs.append("\n温度：");
//                        sbs.append(jb.getString("fl"));
                       // logMsg2(jb.toString());
                        //logImg(jb.getString("cond_code"));
                        add.append("\n天气信息："+jb.getString("status"));
                        Log.i("msg",jb.getString("status"));

                    }

                    @Override
                    public void onError(Exception e) {

                    }
                });
//                sb.append("\nStreet : ");// 街道
//                sb.append(location.getStreet());
//                sb.append("\naddr : ");// 地址信息
//                sb.append(location.getAddrStr());
//                sb.append("\nUserIndoorState: ");// *****返回用户室内外判断结果*****
//                sb.append(location.getUserIndoorState());
//                sb.append("\nDirection(not all devices have value): ");
//                sb.append(location.getDirection());// 方向
//                sb.append("\nlocationdescribe: ");
//                sb.append(location.getLocationDescribe());// 位置语义化信息
//                sb.append("\nPoi: ");// POI信息
//                if (location.getPoiList() != null && !location.getPoiList().isEmpty()) {
//                    for (int i = 0; i < location.getPoiList().size(); i++) {
//                        Poi poi = (Poi) location.getPoiList().get(i);
//                        sb.append(poi.getName() + ";");
//                    }
//                }
//                if (location.getLocType() == BDLocation.TypeGpsLocation) {// GPS定位结果
//                    sb.append("\nspeed : ");
//                    sb.append(location.getSpeed());// 速度 单位：km/h
//                    sb.append("\nsatellite : ");
//                    sb.append(location.getSatelliteNumber());// 卫星数目
//                    sb.append("\nheight : ");
//                    sb.append(location.getAltitude());// 海拔高度 单位：米
//                    sb.append("\ngps status : ");
//                    sb.append(location.getGpsAccuracyStatus());// *****gps质量判断*****
//                    sb.append("\ndescribe : ");
//                    sb.append("gps定位成功");
//                } else if (location.getLocType() == BDLocation.TypeNetWorkLocation) {// 网络定位结果
//                    // 运营商信息
//                    if (location.hasAltitude()) {// *****如果有海拔高度*****
//                        sb.append("\nheight : ");
//                        sb.append(location.getAltitude());// 单位：米
//                    }
//                    sb.append("\noperationers : ");// 运营商信息
//                    sb.append(location.getOperators());
//                    sb.append("\ndescribe : ");
//                    sb.append("网络定位成功");
//                } else if (location.getLocType() == BDLocation.TypeOffLineLocation) {// 离线定位结果
//                    sb.append("\ndescribe : ");
//                    sb.append("离线定位成功，离线定位结果也是有效的");
//                } else if (location.getLocType() == BDLocation.TypeServerError) {
//                    sb.append("\ndescribe : ");
//                    sb.append("服务端网络定位失败，可以反馈IMEI号和大体定位时间到loc-bugs@baidu.com，会有人追查原因");
//                } else if (location.getLocType() == BDLocation.TypeNetWorkException) {
//                    sb.append("\ndescribe : ");
//                    sb.append("网络不同导致定位失败，请检查网络是否通畅");
//                } else if (location.getLocType() == BDLocation.TypeCriteriaException) {
//                    sb.append("\ndescribe : ");
//                    sb.append("无法获取有效定位依据导致定位失败，一般是由于手机的原因，处于飞行模式下一般会造成这种结果，可以试着重启手机");
//                }
               // logMsg(sb.toString());
            }
        }

    };



}
