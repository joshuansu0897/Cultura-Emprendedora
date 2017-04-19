package com.example.joshuansu.homecash.Adapter;

import android.content.Intent;
import android.graphics.Color;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.joshuansu.homecash.R;
import com.example.joshuansu.homecash.content.ToDoContent;
import com.example.joshuansu.homecash.detail.DetailActivity;

import java.util.List;

/**
 * Created by joshuansu on 17/04/17.
 */

public class ToDoAdapter extends RecyclerView.Adapter<ToDoAdapter.ViewHolder> {
    private List<ToDoContent> items;

    public ToDoAdapter(List<ToDoContent> toDoList) {
        items = toDoList;
    }

    @Override
    public ToDoAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View itemView = inflater.inflate(R.layout.card, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.bindData(items.get(position));
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        private CardView containter;
        private TextView ServiceName;
        private TextView ServiceStatus;
        private ImageView Foto;
        private CheckBox box;
        ToDoContent itemP;


        public ViewHolder(View itemView) {
            super(itemView);
            containter = (CardView) itemView.findViewById(R.id.cv);
            ServiceName = (TextView) itemView.findViewById(R.id.service_name);
            ServiceStatus = (TextView) itemView.findViewById(R.id.service_status);
            Foto = (ImageView) itemView.findViewById(R.id.foto);
            box = (CheckBox) itemView.findViewById(R.id.box);
        }

        public void bindData(ToDoContent item){
            itemP = item;
            ServiceName.setText(item.getNombre());
            ServiceStatus.setText(item.getStauts());
            if(item.getStauts().equals("Pagado")) {
                ServiceStatus.setTextColor(Color.parseColor("#558B2F"));

            }else{
                ServiceStatus.setTextColor(Color.parseColor("#DD2C00"));
                box.setOnClickListener(this);
            }
            Foto.setImageResource(item.getIdFoto());
            containter.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if(view.getId() == R.id.box){
                Snackbar.make(view, "Tienes que pagar "+ ServiceName.getText(), Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
            if (view.getId() == R.id.cv){
                Intent intent = new Intent(view.getContext(), DetailActivity.class);
                intent.putExtra(DetailActivity.EXTRA_TODO_KEY, itemP);
                view.getContext().startActivity(intent);
            }
        }
    }
}
