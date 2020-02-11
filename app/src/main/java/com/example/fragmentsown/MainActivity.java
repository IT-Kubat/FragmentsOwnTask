package com.example.fragmentsown;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements ListFragment.ItemSelected {

    String [] descriptions;
    TextView tvDescription;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvDescription = findViewById(R.id.tvDescription);

        descriptions = getResources().getStringArray(R.array.descriptions);

        // Phone is in portrait mode
        if (findViewById(R.id.layout_portrait) != null)
        {
            FragmentManager manager = this.getSupportFragmentManager();
            manager.beginTransaction()
                    .hide(manager.findFragmentById(R.id.DetailFrag))
                    .show(manager.findFragmentById(R.id.ListFrag))
                    .commit();



        }
        // Phone is landscape mode
        if (findViewById(R.id.layout_land) != null)
         {

             FragmentManager manager = this.getSupportFragmentManager();
             manager.beginTransaction()
                     .show(manager.findFragmentById(R.id.DetailFrag))
                     .show(manager.findFragmentById(R.id.ListFrag))
                     .commit();

        }

    }

    @Override
    public void onItemClick(int index) {

        tvDescription.setText(descriptions[index]);

        // Phone is in portrait mode

        if (findViewById(R.id.layout_portrait) != null)
        {
            FragmentManager manager = this.getSupportFragmentManager();
            manager.beginTransaction()
                    .show(manager.findFragmentById(R.id.DetailFrag))
                    .hide(manager.findFragmentById(R.id.ListFrag))
                    .addToBackStack(null)
                    .commit();


        }
    }
}
