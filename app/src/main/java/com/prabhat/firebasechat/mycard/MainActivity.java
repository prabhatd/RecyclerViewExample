package com.prabhat.firebasechat.mycard;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;
import android.widget.Toolbar;

import java.util.List;

public class MainActivity extends AppCompatActivity {
  private RecyclerView recyclerView;
  private AlbumsAdapter adapter;
  private List<Album> albumList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        /*setContentView(R.layout.activity_main);*/
       /* Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);*/
    }

  /*  @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if(id==R.id.action_add_favourite){
            Toast.makeText(this,"you clicked Add Favourite",Toast.LENGTH_LONG).show();
        }else if(id==R.id.action_play_next){
            Toast.makeText(this,"You clicked Play Next Button",Toast.LENGTH_LONG).show();
        }

        return super.onOptionsItemSelected(item);
    }*/
}
