package com.example.fintick;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.appcompat.widget.Toolbar;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.RadioGroup;

import java.util.ArrayList;
import java.util.List;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;


public class ListsFragment extends Fragment {

    private RecyclerView recyclerView;
    private ListsAdapter adapter;
    private List<ListItem> listItems;

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


        // Initialize the list and adapter
        listItems = new ArrayList<>();
        adapter = new ListsAdapter(requireContext() ,listItems);
        recyclerView.setAdapter(adapter);

        loadListsFromDatabase();



        // Floating button click
        FloatingActionButton fab = view.findViewById(R.id.fab_add_list);
        fab.setOnClickListener(v -> showAddListDialog());

        return view;
    }
    @SuppressLint("NotifyDataSetChanged")
    private void showAddListDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setTitle("ایجاد لیست جدید");

        // ساختن یک View سفارشی برای دیالوگ
        View dialogView = LayoutInflater.from(getContext()).inflate(R.layout.dialog_add_list, null);
        builder.setView(dialogView);

        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) EditText editTitle = dialogView.findViewById(R.id.edit_list_title);
        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) RadioGroup radioGroup = dialogView.findViewById(R.id.radio_group_type);

        builder.setPositiveButton("ایجاد", (dialog, which) -> {
            String title = editTitle.getText().toString().trim();
            String type = (radioGroup.getCheckedRadioButtonId() == R.id.radio_simple) ? "simple" : "todo";

            if (!title.isEmpty()) {
                ListItem newItem = new ListItem(title, "امروز", type);

                // Save to Room database
                AppDatabase db = AppDatabase.getInstance(requireContext());
                db.listDao().insertList(newItem);

                // Refresh list from DB
                loadListsFromDatabase();
            }

//            if (!title.isEmpty()) {
//                ListItem newItem = new ListItem(title, "امروز", type); // تاریخ را بعداً داینامیک می‌کنیم
//                listItems.add(newItem); // لیستت را فرضاً listItems تعریف کردی
//                adapter.notifyDataSetChanged(); // بروزرسانی لیست
//            }
        });

        builder.setNegativeButton("انصراف", null);
        builder.show();
    }
    @SuppressLint("NotifyDataSetChanged")
    private void loadListsFromDatabase() {
        AppDatabase db = AppDatabase.getInstance(requireContext());
        List<ListItem> itemsFromDb = db.listDao().getAllLists();

        listItems.clear();
        listItems.addAll(itemsFromDb);
        adapter.notifyDataSetChanged();
    }
}
