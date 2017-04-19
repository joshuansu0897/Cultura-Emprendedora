package com.example.joshuansu.homecash;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import com.example.joshuansu.homecash.Adapter.ToDoAdapter;
import com.example.joshuansu.homecash.content.ToDoContent;
import com.example.joshuansu.homecash.login.LoginActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView todoRecyclerView;
    private ToDoAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(view.getContext(), LoginActivity.class );
                startActivityForResult(i, 0);
                /*Snackbar.make(view, "No se que poner aqui :D", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show(); */
            }
        });

        //Recyclerview
        adapter = new ToDoAdapter(getItems());

        todoRecyclerView = (RecyclerView) findViewById(R.id.todo_list);
        todoRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        todoRecyclerView.setAdapter(adapter);
    }


    private List<ToDoContent> getItems() {
        List<ToDoContent> items = new ArrayList<>();
        ToDoContent item1 = new ToDoContent("Netflix", "Pagado", R.drawable.netflix2, true, "");
        item1.setDetalle("Es una aplicacion para ver series y peliculas online.");
        ToDoContent item4 = new ToDoContent("Elektra", "No Pagado", R.drawable.elektra, false, "");
        item4.setDetalle("Es una empresa donde puede comprar al contado o por pagos");
        ToDoContent item2 = new ToDoContent("CFE", "Pagado", R.drawable.cfe, true, "");
        item2.setDetalle("Empresa de linfrestructura de luz mexicana");
        ToDoContent item3 = new ToDoContent("Telcel", "No Pagado", R.drawable.telcel, false, "");
        item3.setDetalle("Empresa de telefonia movil");
        items.add(item1);
        items.add(item2);
        items.add(item3);
        items.add(item4);
        return items;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
