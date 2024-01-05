package com.example.cmrlproject;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.Console;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
public class zjeviewreq extends AppCompatActivity{
    private JSONArray successArray;

    String eid;
    ImageButton b1, b2, b3,b4;
    private ListView faultListView;
    private List<String> faultList;
    private ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.zjeviewreq);

        faultListView = findViewById(R.id.faultListView);
        faultList = new ArrayList<>();
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, faultList);
        faultListView.setAdapter(adapter);

        // Execute the AsyncTask to make the HTTP POST request
        new HttpRequestTask().execute("https://ac94-2401-4900-6299-a16-79ee-b71b-9e80-c8e7.ngrok-free.app/cmo_view");

        b1 = findViewById(R.id.approvereq);
        b2 = findViewById(R.id.homebut);
        b3 = findViewById(R.id.viewreqbut);
        b4=  findViewById(R.id.profilebut);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(zjeviewreq.this, zjeapprovereq.class);
                startActivity(i);
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(zjeviewreq.this, zjehome.class);

                startActivity(i);
            }
        });
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(zjeviewreq.this, zjeprofile.class);
                startActivity(i);
            }
        });

        // Handle item click to open details page
        faultListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                try {
                    JSONObject successObject = successArray.getJSONObject(position);
                    Log.d("POSITION",Integer.toString(position));

                    openFaultDetails(successObject);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });

    }
    private void openFaultDetails(JSONObject successObject) throws JSONException {
        Intent intent = new Intent(this, zjefaultdetail.class);
        String ackno = successObject.getString("ackno");
        Log.d("ACKNO",ackno);
        String date = successObject.getString("dt");
        String station = successObject.getString("station");
        String device = successObject.getString("device");
        String deviceno = successObject.getString("deviceno");
        String status = successObject.getString("description");
        intent.putExtra("ackno", ackno);
        intent.putExtra("date", date);
        intent.putExtra("station", station);
        intent.putExtra("device", device);
        intent.putExtra("deviceno", deviceno);
        intent.putExtra("status", status);
        startActivity(intent);
    }

    private class HttpRequestTask extends AsyncTask<String, Void, String> {
        @Override
        protected String doInBackground(String... params) {
            String urlString = params[0];
            try {
                // Create a URL object and open a connection
                URL url = new URL(urlString);
                HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();

                // Set the request method to POST
                urlConnection.setRequestMethod("POST");

                // Set the request headers (if needed)
                // urlConnection.setRequestProperty("Content-Type", "application/json");

                // Enable input/output streams for writing/reading data
                urlConnection.setDoOutput(true);
                urlConnection.setDoInput(true);

                // Create the POST data (replace with your own data)
                Map<String, String> postData = new HashMap<>();
                postData.put("key1", "value1");
                postData.put("key2", "value2");

                // Write the POST data to the output stream
                DataOutputStream outputStream = new DataOutputStream(urlConnection.getOutputStream());
                StringBuilder postDataString = new StringBuilder();
                for (Map.Entry<String, String> entry : postData.entrySet()) {
                    postDataString.append(entry.getKey()).append("=").append(entry.getValue()).append("&");
                }
                postDataString.deleteCharAt(postDataString.length() - 1); // Remove the trailing "&"
                outputStream.writeBytes(postDataString.toString());
                outputStream.flush();
                outputStream.close();

                // Read the input stream into a String
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
                StringBuilder stringBuilder = new StringBuilder();

                String line;
                while ((line = bufferedReader.readLine()) != null) {
                    stringBuilder.append(line).append("\n");
                }

                bufferedReader.close();
                return stringBuilder.toString();
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }

        @Override
        protected void onPostExecute(String result) {
            if (result != null) {
                try {
                    // Parse the JSON response
                    JSONObject jsonResponse = new JSONObject(result);
                    successArray = jsonResponse.getJSONArray("success");

                    // Iterate through the success array
                    for (int i = 0; i < successArray.length(); i++) {
                        JSONObject successObject = successArray.getJSONObject(i);

                        // Get values from JSON
                        String station = successObject.getString("station");
                        String device = successObject.getString("device");

                        // Add station and ackno to the list
                        String fault = station + ": " + device;
                        faultList.add(fault);
                    }

                    // Notify the adapter that the data set has changed
                    adapter.notifyDataSetChanged();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else {
                // Handle the case where the result is null
                Toast.makeText(zjeviewreq.this, "Error fetching data from server", Toast.LENGTH_SHORT).show();
            }
        }
    }
}
