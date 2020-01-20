package com.example.f1standings;

import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.net.http.HttpResponseCache;
import android.os.AsyncTask;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.util.JsonReader;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

import java.io.FileReader;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


public class ScrollingActivity extends AppCompatActivity {

    ArrayAdapter<String> adapter = null;
    ProgressDialog p;
    ListView rv = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scrolling);


        final ArrayList<String> standings = new ArrayList<>();

        adapter = new ArrayAdapter<String>(this, R.layout.standing_item, R.id.textView, new ArrayList<String>());

        rv = (ListView) findViewById(R.id.list);
        rv.setAdapter(adapter);

        AsyncStandingFetcher task = new AsyncStandingFetcher();
        task.execute();
    }


    private class AsyncStandingFetcher extends AsyncTask<String, String, ArrayList<String>> {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            p = new ProgressDialog(ScrollingActivity.this);
            p.setMessage("Please wait...It is downloading");
            p.setIndeterminate(false);
            p.setCancelable(false);
            p.show();
        }


        @Override
        protected ArrayList<String> doInBackground(String... strings) {
            ArrayList<String> standings = new ArrayList<>();

            try {

// -------------

                // Create URL
                URL githubEndpoint = null;
                try {
                    githubEndpoint = new URL("https://ergast.com/api/f1/current/driverStandings.json");
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }

                // Create connection
                HttpsURLConnection myConnection =
                        null;
                try {
                    myConnection = (HttpsURLConnection) githubEndpoint.openConnection();
                } catch (IOException e) {
                    e.printStackTrace();
                }

                myConnection.setRequestProperty("User-Agent", "f1standings-v0.1");

                JSONArray jsonarr;

                try {
                    if (myConnection.getResponseCode() == 200) {
                        Log.d("tag", "hallo");
                        // Success

                        InputStream responseBody = myConnection.getInputStream();
                        BufferedReader responseBodyReader = new BufferedReader(new InputStreamReader(responseBody, "UTF-8"));
                        ArrayList<String> fullJson = new ArrayList<>();
                        String line;
                        while ((line = responseBodyReader.readLine()) != null) {
                            fullJson.add(line);
                        }
                        String fullJsonString = String.join("\n", fullJson);

                        JSONObject root = new JSONObject(fullJsonString);
                        jsonarr = root.getJSONObject("MRData").getJSONObject("StandingsTable").getJSONArray("StandingsLists");
                        JSONObject json = (JSONObject) jsonarr.get(0);
                        jsonarr = json.getJSONArray("DriverStandings");

                        String text = "";

                        for (int i = 0; i < jsonarr.length(); i++) {
                            JSONObject jsondriver = (JSONObject) jsonarr.get(i);
                            JSONObject driver = (JSONObject) jsondriver.get("Driver");

                            text += jsondriver.getInt("position");
                            text += driver.getString("givenName");
                            text += driver.getString("familyName");

                            standings.add(text);
                            text = "";
                        }
                        Log.i("ScrollingActivity", standings.toString());


                        myConnection.disconnect();

                    }
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (JSONException e) {
                    e.printStackTrace();
                }


            } finally {
                return standings;
            }
        }

        @Override
        protected void onPostExecute(ArrayList<String> l) {
            super.onPostExecute(l);
            adapter.addAll(l);

            if (rv != null) {
                p.hide();
                rv.setAdapter(adapter);
            } else {
                p.show();
            }
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_scrolling, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

}
