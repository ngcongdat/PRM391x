package vn.edu.funix.ncdat.prm391x_googlemap_datncfx00499;

import android.Manifest;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.AsyncTask;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolylineOptions;
import org.json.JSONObject;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import vn.edu.funix.ncdat.prm391x_googlemap_datncfx00499.data.DBHistory;
import vn.edu.funix.ncdat.prm391x_googlemap_datncfx00499.model.History;

public class MainActivity extends AppCompatActivity implements OnMapReadyCallback, View.OnClickListener {

    GoogleMap map;
    Button findPathBtn;
    EditText beginLocation, endLocation;
    TextView txtDistance, txtDuration;
    LatLng startPoint, endPoint, mLocation;
    LocationManager mLocationManager;
    Intent mIntent, backIntent;
    DBHistory dbHistory;
    ProgressDialog dialog;

    public static final int MY_PERMISSIONS_REQUEST_LOCATION = 99;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addControl();

        // Check gps permission
        checkLocationPermission();

        // Get content from history activity
        getContent();

        // Set click listener for Find Path button
        findPathBtn.setOnClickListener(this);

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.mMap);
        mapFragment.getMapAsync(this);
    }

    // Method to set text on beginLocation and endLocation
    // After that can find path again
    private void getContent() {
        String origin = backIntent.getStringExtra("origin");
        String dest = backIntent.getStringExtra("dest");
        if (origin != null && dest != null) {
            beginLocation.setText(origin);
            endLocation.setText(dest);
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (ContextCompat.checkSelfPermission(this,
                Manifest.permission.ACCESS_FINE_LOCATION)
                == PackageManager.PERMISSION_GRANTED) {

            mLocationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 400, 1, mLocationListener);
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (ContextCompat.checkSelfPermission(this,
                Manifest.permission.ACCESS_FINE_LOCATION)
                == PackageManager.PERMISSION_GRANTED) {

            mLocationManager.removeUpdates(mLocationListener);
        }
    }

    // Create location listener
    private final LocationListener mLocationListener = new LocationListener() {
        @Override
        public void onLocationChanged(final Location location) {
            mLocation = new LatLng(location.getLatitude(), location.getLongitude());
            map.moveCamera(CameraUpdateFactory.newLatLngZoom(mLocation, 11.5f));
        }

        @Override
        public void onStatusChanged(String provider, int status, Bundle extras) {
        }

        @Override
        public void onProviderEnabled(String provider) {
        }

        @Override
        public void onProviderDisabled(String provider) {
        }
    };

    // Add all controls
    private void addControl() {
        findPathBtn = findViewById(R.id.findpathId);
        beginLocation = findViewById(R.id.beginLocation);
        endLocation = findViewById(R.id.endLocation);
        txtDistance = findViewById(R.id.txtDistance);
        txtDuration = findViewById(R.id.txtDuration);
        mIntent = new Intent(MainActivity.this, HistoryActivity.class);
        backIntent = getIntent();
        mLocationManager = (LocationManager) getSystemService(LOCATION_SERVICE);
        dbHistory = new DBHistory(this);
        dialog = new ProgressDialog(MainActivity.this);
        dialog.setTitle("Drawing Route");
        dialog.setMessage("Processing! Please wait...!");
    }

    // Check GPS permission and request user allow
    public boolean checkLocationPermission() {
        if (ContextCompat.checkSelfPermission(this,
                Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED) {

            if (ActivityCompat.shouldShowRequestPermissionRationale(this,
                    Manifest.permission.ACCESS_FINE_LOCATION)) {
                // Show alert dialog to request allow GPS
                new AlertDialog.Builder(this)
                        .setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                //Prompt the user once explanation has been shown
                                ActivityCompat.requestPermissions(MainActivity.this,
                                        new String[]{Manifest.permission.ACCESS_FINE_LOCATION},
                                        MY_PERMISSIONS_REQUEST_LOCATION);
                            }
                        })
                        .create()
                        .show();
            } else {
                // Denied permission
                ActivityCompat.requestPermissions(this,
                        new String[]{Manifest.permission.ACCESS_FINE_LOCATION},
                        MY_PERMISSIONS_REQUEST_LOCATION);
            }
            return false;
        } else {
            return true;
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {
        switch (requestCode) {
            case MY_PERMISSIONS_REQUEST_LOCATION: {
                // If request is cancelled, the result arrays are empty.
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    if (ContextCompat.checkSelfPermission(this,
                            Manifest.permission.ACCESS_FINE_LOCATION)
                            == PackageManager.PERMISSION_GRANTED) {

                        // Request location updates
                        mLocationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 400, 1, mLocationListener);
                        onMapReady(map);
                    }
                }
                return;
            }
        }
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        map = googleMap;
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        map.setMyLocationEnabled(true);
    }

    @Override
    public void onClick(View v) {
        if ((beginLocation.getText().toString().trim().equals("") || beginLocation.getText().toString() == null) || (endLocation.getText().toString().trim().equals("") || endLocation.getText().toString() == null)) {
            Toast.makeText(this, "Please input enough location!!", Toast.LENGTH_SHORT).show();
        } else {
            map.clear();
            // Call getLocationFromAddress() method to get Latitude and Longitude of two location
            startPoint = getLocationFromAddress(this, beginLocation.getText().toString());
            endPoint = getLocationFromAddress(this, endLocation.getText().toString());

            // Add marker for two location after search
            if (startPoint != null && endPoint != null) {
                map.addMarker(new MarkerOptions()
                        .position(startPoint)
                        .title(beginLocation.getText().toString())
                        .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));
                map.addMarker(new MarkerOptions()
                        .position(endPoint)
                        .title(endLocation.getText().toString())
                        .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE)));
                map.moveCamera(CameraUpdateFactory.newLatLngZoom(startPoint, 12));

                String URL = getDirectionUrl(startPoint, endPoint);

                new DownloadTask().execute(URL);
            } else {
                Toast.makeText(this, "Input more information!", Toast.LENGTH_SHORT).show();
            }
        }
    }


    // Return Latitude and Longitude of location
    public LatLng getLocationFromAddress(Context context, String strAddress) {

        Geocoder coder = new Geocoder(context);
        List<Address> address;
        LatLng point = null;

        try {
            // May throw an IOException
            address = coder.getFromLocationName(strAddress, 5);
            if (address == null) {
                return null;
            } else {
                if (address.size() > 0) {
                    Address location = address.get(0);
                    point = new LatLng(location.getLatitude(), location.getLongitude());
                } else {
                    return null;
                }
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return point;
    }

    // Return url directions api
    private String getDirectionUrl(LatLng origin, LatLng dest) {
        // Origin
        String str_origin = "origin=" + origin.latitude + "," + origin.longitude;

        // Destination
        String str_dest = "destination=" + dest.latitude + "," + dest.longitude;

        // Sensor
        String sensor = "sensor=false";

        // The parameters to the web service
        String parameters = str_origin + "&" + str_dest + "&" + sensor;

        // Output format
        String output = "json";

        // The url to the web service
        String url = "https://maps.googleapis.com/maps/api/directions/" + output + "?" + parameters + "&key=" + getString(R.string.google_maps_key);

        return url;
    }

    // Class DownloadTask to get data from url on backgroud task
    private class DownloadTask extends AsyncTask<String, Void, String> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            dialog.show();
        }

        @Override
        protected String doInBackground(String... url) {
            String data = "";
            try {
                data = downloadUrl(url[0]);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            return data;
        }

        @Override
        protected void onPostExecute(String result) {
            super.onPostExecute(result);
            ParserTask parserTask = new ParserTask();
            parserTask.execute(result);
        }
    }

    // Open connection and read line of data
    private String downloadUrl(String strUrl) throws IOException {
        String data = "";
        InputStream inputStream = null;
        HttpURLConnection urlConnection = null;
        try {
            URL url = new URL(strUrl);

            urlConnection = (HttpURLConnection) url.openConnection();

            urlConnection.connect();

            inputStream = urlConnection.getInputStream();

            BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
            StringBuffer sb = new StringBuffer();
            String line = "";
            while ((line = br.readLine()) != null) {
                sb.append(line);
            }
            data = sb.toString();
            br.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            inputStream.close();
            urlConnection.disconnect();
        }
        return data;
    }

    private class ParserTask extends AsyncTask<String, Integer, List<List<HashMap<String, String>>>> {

        @Override
        protected List<List<HashMap<String, String>>> doInBackground(String... jsonData) {

            JSONObject jsonObject;
            List<List<HashMap<String, String>>> routes = null;

            try {
                jsonObject = new JSONObject(jsonData[0]);
                // Initializer object DirectionJSONParser to parse JSON to Array
                DirectionJSONParser parser = new DirectionJSONParser();

                routes = parser.parse(jsonObject);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            return routes;
        }

        @Override
        protected void onPostExecute(List<List<HashMap<String, String>>> results) {

            ArrayList<LatLng> points = null;
            PolylineOptions polylineOptions = null;
            String distance = "";
            String duration = "";


            for (int i = 0; i < results.size(); i++) {
                points = new ArrayList<LatLng>();
                polylineOptions = new PolylineOptions();

                List<HashMap<String, String>> path = results.get(i);

                for (int j = 0; j < path.size(); j++) {
                    HashMap<String, String> point = path.get(j);

                    // Read first element of array and get distance between two location
                    if (j == 0) {
                        distance = point.get("distance");
                        continue;
                    }
                    // Read second element of array and get distance between two location
                    else if (j == 1) {
                        duration = point.get("duration");
                        continue;
                    }
                    // Get Latitude and Longitude to draw route
                    double lat = Double.parseDouble(point.get("lat"));
                    double lng = Double.parseDouble(point.get("lng"));
                    LatLng position = new LatLng(lat, lng);
                    points.add(position);
                }
                polylineOptions.addAll(points);
                polylineOptions.width(5);
                polylineOptions.color(Color.BLUE);
            }

            txtDistance.setText(distance);
            txtDuration.setText(duration);

            // Call addHistory() method to add history to database
            dbHistory.addHistory(new History(beginLocation.getText().toString(), endLocation.getText().toString()));

            if (polylineOptions != null) {
                map.addPolyline(polylineOptions);
            }

            beginLocation.setText("");
            endLocation.setText("");
            dialog.dismiss();
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.menuHistory) {
            startActivity(mIntent);
        }
        return super.onOptionsItemSelected(item);
    }
}
