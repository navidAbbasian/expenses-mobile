package com.example.fintick;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.appcompat.widget.Toolbar;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import androidx.appcompat.app.AppCompatActivity;


public class ListsFragment extends Fragment {

    private RecyclerView recyclerView;
    private ListsAdapter adapter;
    private List<String> sampleData;

    public ListsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout
        View view = inflater.inflate(R.layout.fragment_lists, container, false);

        // Initialize Toolbar
        Toolbar toolbar = view.findViewById(R.id.toolbar);

        // Set toolbar as the ActionBar
        AppCompatActivity activity = (AppCompatActivity) getActivity();
        if (activity != null) {
            activity.setSupportActionBar(toolbar);
        }

        // Initialize RecyclerView
        recyclerView = view.findViewById(R.id.lists_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        // Sample data to display
        sampleData = new ArrayList<>();
        sampleData.add("Grocery List");
        sampleData.add("Workout Plan");
        sampleData.add("Reading List");

        // Set adapter
        adapter = new ListsAdapter(sampleData);
        recyclerView.setAdapter(adapter);

        return view;
    }
}
