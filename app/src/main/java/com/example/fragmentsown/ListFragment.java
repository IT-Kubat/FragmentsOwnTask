package com.example.fragmentsown;


import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class ListFragment extends androidx.fragment.app.ListFragment {

    ItemSelected activity;

    public interface  ItemSelected{

        void onItemClick(int index);
    }


    public ListFragment() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

        activity = (ItemSelected) context;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        ArrayList<String> data = new ArrayList<>();
        data.add("1. This is item 1");
        data.add("2. This is item 2");
        data.add("3. This is item 3");
        data.add("4. This is item 4");
        data.add("5. This is item 5");

        setListAdapter(new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, data));
        activity.onItemClick(0);

    }

    @Override
    public void onListItemClick(@NonNull ListView l, @NonNull View v, int position, long id) {

        activity.onItemClick(position);
    }
}