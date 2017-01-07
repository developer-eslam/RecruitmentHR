package com.erp.recruitmentmanagment.recruitmentsystem.personalapplcation;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;

import com.erp.recruitmentmanagment.recruitmentsystem.R;

import java.util.ArrayList;
import java.util.List;

public class PersoanlApp extends Activity {

    RecyclerView recyclerView;
    detailsthemeonefragment_receclerview detailsthemeonefragment_receclerview;


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
        detailsthemeonefragment_receclerview = new detailsthemeonefragment_receclerview(getApplicationContext(),detailsthemeonefragment_receclerviews(1));

        recyclerView.setAdapter(detailsthemeonefragment_receclerview);



    }


    public List<personalappliactionmodel> detailsthemeonefragment_receclerviews(int size){
        List<personalappliactionmodel>personalappliactionmodellist = new ArrayList<personalappliactionmodel>(

        );

        for(int i=0;i<size;i++){
            personalappliactionmodel personalappliactionmodel = new personalappliactionmodel();

            personalappliactionmodel.fname = personalappliactionmodel.FIRST_NAME;
            personalappliactionmodel.mname = personalappliactionmodel.MIDDLE_NAME;
            personalappliactionmodel.lname = personalappliactionmodel.LAST_NAME;
            personalappliactionmodel.address = personalappliactionmodel.ADDRESS;
            personalappliactionmodel.phone = personalappliactionmodel.PHONE;
            personalappliactionmodel.city = personalappliactionmodel.CITY;
            personalappliactionmodel.date = personalappliactionmodel.DATE;




            personalappliactionmodellist.add(personalappliactionmodel);


        }

        return personalappliactionmodellist;
    }




    }
