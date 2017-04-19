package com.example.joshuansu.homecash.detail;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.joshuansu.homecash.R;
import com.example.joshuansu.homecash.content.ToDoContent;

/**
 * Created by joshuansu on 18/04/17.
 */

public class DetailActivity extends AppCompatActivity {

    public static final String EXTRA_TODO_KEY = "TODO";

    private TextView titleTextView;
    private TextView notesTextView;
    private TextView status;
    private ImageView fot;

    private ToDoContent todo;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        todo = getTodo();
        setContentView(R.layout.activity_detail);
        titleTextView = (TextView) findViewById(R.id.nombre_detalle);
        notesTextView = (TextView) findViewById(R.id.descripcion);
        status = (TextView) findViewById(R.id.status_detalle);
        fot = (ImageView) findViewById(R.id.foto);
        titleTextView.setText(todo.getNombre());
        notesTextView.setText(todo.getDetalle());
        status.setText(todo.getStauts());
        if(todo.getStauts().equals("Pagado")) {
            status.setTextColor(Color.parseColor("#558B2F"));

        }else{
            status.setTextColor(Color.parseColor("#DD2C00"));
        }
        fot.setImageResource(todo.getIdFoto());
    }

    private ToDoContent getTodo() {
        Bundle extras = getIntent().getExtras();
        if (extras != null && extras.containsKey(EXTRA_TODO_KEY)) {
            return (ToDoContent) extras.getSerializable(EXTRA_TODO_KEY);
        }
        throw new AssertionError(getClass().getSimpleName() + " intent extras should contain an item");
    }
}
