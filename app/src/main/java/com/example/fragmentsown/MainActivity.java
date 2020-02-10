package com.example.fragmentsown;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements ListFragment.ItemSelected {

    ArrayList<String> descriptions;
    TextView tvDescription;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvDescription = findViewById(R.id.tvDescription);

        descriptions = new ArrayList<String>();
        descriptions.add("Description for item 1");
        descriptions.add("Description for item 2");
        descriptions.add("Description for item 3");
        descriptions.add("Description for item 4");
        descriptions.add("Description for item 5");
    }

    @Override
    public void onItemClick(int index) {

        tvDescription.setText(descriptions.get(index));
    }
}
