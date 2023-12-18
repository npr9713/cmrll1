package com.example.cmrlproject;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class l1home extends AppCompatActivity {
    String eid;
    ImageButton b1, b2, b3;
    private ListView faultListView;
    private List<String> faultList;
    private ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.l1home);

        // Initialize views and variables
        faultListView = findViewById(R.id.faultListView);
        faultList = new ArrayList<>();
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, faultList);
        faultListView.setAdapter(adapter);

        // Execute the AsyncTask to make the HTTP POST request
        new HttpRequestTask().execute("https://76e7-103-28-246-125.ngrok.io");

        // Other initialization code
        Intent i = getIntent();
        eid = i.getStringExtra("employeeid_key");
        b1 = findViewById(R.id.logsbut);
        b2 = findViewById(R.id.homebut);
        b3 = findViewById(R.id.profilebut);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(l1home.this, l1acceptedreq.class);
                startActivity(i);
            }
        });

        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(l1home.this, l1profile.class);
                i.putExtra("employeeid_key", eid);
                startActivity(i);
            }
        });

        // Handle item click to open details page
        faultListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selectedFault = faultList.get(position);
                openFaultDetails(selectedFault);
            }
        });
    }

    private void openFaultDetails(String fault) {
        Intent intent = new Intent(this, faultdetail.class);
        intent.putExtra("fault", fault);
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
                    JSONArray successArray = jsonResponse.getJSONArray("success");

                    // Iterate through the success array
                    for (int i = 0; i < successArray.length(); i++) {
                        JSONObject successObject = successArray.getJSONObject(i);

                        // Get values from JSON
                        String station = successObject.getString("station");
                        String ackno = successObject.getString("ackno");

                        // Add station and ackno to the list
                        String fault = station + ": " + ackno;
                        faultList.add(fault);
                    }

                    // Notify the adapter that the data set has changed
                    adapter.notifyDataSetChanged();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else {
                // Handle the case where the result is null
                Toast.makeText(l1home.this, "Error fetching data from server", Toast.LENGTH_SHORT).show();
            }
        }
    }
}