package com.erp.recruitmentmanagment.recruitmentsystem.skills;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;

import com.erp.recruitmentmanagment.recruitmentsystem.R;


public class skillsthemetwo  extends Activity {

    RecyclerView recyclerView;
    detailsskillsfragmentthemetwo detailsskillsfragmentthemetwo;


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
        setContentView(R.layout.receclerviewthemetwo);

        recyclerView=(RecyclerView)findViewById(R.id.recycler);

        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);

        detailsskillsfragmentthemetwo = new detailsskillsfragmentthemetwo(getApplicationContext());

        recyclerView.setAdapter(detailsskillsfragmentthemetwo);

    }


}

