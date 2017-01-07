package com.erp.recruitmentmanagment.recruitmentsystem.experience;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;

import com.erp.recruitmentmanagment.recruitmentsystem.R;

/**
 * Created by abotaleb on 12/14/2016.
 */

public class experiencethemeone  extends Activity {

    RecyclerView recyclerView;
    detailsexperiencefragmentthemeone detailsexperiencefragmentthemeone;


    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {

        getMenuInflater().inflate(R.menu.mainmenu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.receclerviewthemeone);

        recyclerView=(RecyclerView)findViewById(R.id.recycler);

        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);

        detailsexperiencefragmentthemeone = new detailsexperiencefragmentthemeone(getApplicationContext());

        recyclerView.setAdapter(detailsexperiencefragmentthemeone);



    }







}
