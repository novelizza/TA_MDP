package com.example.user.inilo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    RecyclerView rcview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rcview = findViewById(R.id.rcList);

        MyAdapterListHome myAdapterListHome = new MyAdapterListHome(this, DataUser.userArray, DataUser.idArray, DataUser.logoArray, DataUser.followerArray, DataUser.followingArray, DataUser.projectArray, DataUser.companyArray, DataUser.locationArray);
        rcview.setAdapter(myAdapterListHome);
        rcview.setLayoutManager(new LinearLayoutManager(this));
    }

    //Membuat menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu,menu);
        return true;
    }

    //Membuat pilihan menu
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (item.getItemId()==R.id.aboutme)
        {
            startActivity(new Intent(MainActivity.this, AboutMeActivity.class));
        }
        return true;
    }
}