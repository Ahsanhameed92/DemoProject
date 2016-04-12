package com.ahsan.demoapplication;

import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ProgressBar;

import com.ahsan.demoapplication.data.DataObject;
import com.ahsan.demoapplication.data.JsonData;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements NameDialogFragment.AddNameFragmentActionButtonClickListener {


    private RecyclerView.Adapter mAdapter;
    private List<DataObject> mDataObjectList;
    private CoordinatorLayout mCoordinatorLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        init();

    }

    /////////    initialize function
    private void init() {
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.name_list);
        ProgressBar progressBar = (ProgressBar) findViewById(R.id.progress_bar);
        if (recyclerView != null) {
            recyclerView.setHasFixedSize(true);
        }
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        assert recyclerView != null;
        recyclerView.setLayoutManager(layoutManager);
        mCoordinatorLayout = (CoordinatorLayout) findViewById(R.id.coordinatorLayout);
        mDataObjectList = new ArrayList<>();
        mDataObjectList = getData();
        mAdapter = new NamesListAdapter(mDataObjectList);
        assert progressBar != null;
        progressBar.setVisibility(View.VISIBLE);
        recyclerView.setAdapter(mAdapter);
        progressBar.setVisibility(View.GONE);

        assert fab != null;
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDialog();

            }
        });
    }

    ////////////////////////// Function to get dummy data from  json

    private List<DataObject> getData() {
        Gson gson = new Gson();
        return gson.fromJson(JsonData.JSON_DATA, new TypeToken<List<DataObject>>() {
        }.getType());
    }


    //////////    Function to show dialog to enter name in list
    private void showDialog() {
        NameDialogFragment newFragment = NameDialogFragment.newInstance();
        newFragment.show(this.getSupportFragmentManager(), "connection_error");
    }

    @Override
    public void onPositiveClicked(String firstName, String lastName) {
        DataObject dataObject = new DataObject(capitalizeFirstWord(firstName), capitalizeFirstWord(lastName));
        mDataObjectList.add(dataObject);
        mAdapter.notifyDataSetChanged();
        Snackbar.make(mCoordinatorLayout, "Name successfully added to list!", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show();
    }

    @Override
    public void onNegativeClicked() {

    }

    ///////// Function to capitalize first latter of word
    private String capitalizeFirstWord(String string){
        return String.valueOf(string.charAt(0)).toUpperCase() + string.substring(1, string.length());
    }
}
