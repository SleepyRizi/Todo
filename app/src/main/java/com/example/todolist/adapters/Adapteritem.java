package com.example.todolist.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.todolist.Arraystatic;
import com.example.todolist.R;
import com.example.todolist.singleItem;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class Adapteritem extends RecyclerView.Adapter<Adapteritem.ViewHolder> {

    public ArrayList<singleItem> myitems;
    // itemSelected myindex;
    Context myindex;
//    public interface itemSelected{
//        public void onContentClick(int index);
//    }

    public Adapteritem(ArrayList<singleItem> myitems, Context context) {
        this.myitems = myitems;
        //this.myindex = (itemSelected) context;
        this.myindex =  context;
    }

    @NonNull
    @NotNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.single_item,parent,false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull ViewHolder holder, int position) {
            holder.tvDescription.setText(myitems.get(position).getDescription());
            holder.itemView.setTag(myitems.get(position));

            holder.ivRemove.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Arraystatic.myitems.remove(position);
                    notifyItemRemoved(position);

                    Toast.makeText(myindex, "Onclick"+position, Toast.LENGTH_SHORT).show();
                }
            });
    }

    @Override
    public int getItemCount() {
        return myitems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvDescription;
       ImageView ivRemove;
        public ViewHolder(@NotNull View itemView) {
            super(itemView);
            tvDescription= itemView.findViewById(R.id.tvsignleItem);
            ivRemove=(ImageView) itemView.findViewById(R.id.ivremoveitem);

           /* itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    myindex.onContentClick(myitems.indexOf((singleItem)itemView.getTag()));
                   // myitems.get(myitems.indexOf(itemView.getTag()));
                    //String msg;
                    //Toast.makeText(context, "msg", Toast.LENGTH_SHORT).show();
                }
            });*/
        }
    }
}
