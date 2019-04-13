/*
 * *
 *  * Created by Shubham(adminvns) on 13/4/19 10:36 AM
 *  * Copyright (c) 2019 . All rights reserved.
 *  * Last modified 13/4/19 10:36 AM
 *  * Email: shubham.editor@gmail.com
 *  * github.com/adminvns
 *
 */

package in.patelelectric.jsonfetcher;

import android.os.AsyncTask;
import android.view.View;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class fetchingclass extends AsyncTask<Void, Void, Void> {
    String data = "";
    String singleData = "";
    String wholeData = "";

    @Override
    protected Void doInBackground(Void... voids) {

        try {
            URL url = new URL("https://api.myjson.com/bins/u7ubo");

            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            InputStream inputStream = httpURLConnection.getInputStream();

            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

            String line = "";
            while (line != null) {

                line = bufferedReader.readLine();
                data = data + line;
            }

            JSONArray jsonArray = new JSONArray(data);

            for (int i = 0; i < jsonArray.length(); i++) {

                JSONObject jsonObject = (JSONObject) jsonArray.get(i);

                singleData = "Name: " + jsonObject.get("name") + "\n" +
                        "Semester: " + jsonObject.get("sem") + "\n" +
                        "Roll Number: " + jsonObject.get("roll") + "\n" +
                        "College: " + jsonObject.get("college") + "\n" + "\n";

                wholeData = wholeData + singleData;
                MainActivity.progressBar.setVisibility(View.INVISIBLE);


            }


        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }


        return null;
    }


    @Override
    protected void onPostExecute(Void aVoid) {

        MainActivity.fetchedText.setText(this.wholeData);

        super.onPostExecute(aVoid);
    }


}
