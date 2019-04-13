/*
 * *
 *  * Created by Shubham(adminvns) on 13/4/19 10:37 AM
 *  * Copyright (c) 2019 . All rights reserved.
 *  * Last modified 13/4/19 10:14 AM
 *  * Email: shubham.editor@gmail.com
 *  * github.com/adminvns
 *
 */

package in.patelelectric.jsonfetcher;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
 //initializing
    Button fetcher;
  public static ProgressBar progressBar;

  public static   TextView fetchedText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //binding
        fetcher = findViewById(R.id.buttonFetch);
        fetchedText = findViewById(R.id.fetchedData);
        progressBar = findViewById(R.id.prog);


        fetcher.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progressBar.setVisibility(View.VISIBLE);
                fetchedText.setText("fetching data.....");
                fetcher.setText("RE-FETCH Data");

                fetchingclass fetchingclass = new fetchingclass();
                fetchingclass.execute();
            }
        });


    }
}
