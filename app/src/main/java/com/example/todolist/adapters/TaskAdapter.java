package com.example.todolist.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.todolist.Arraystatic;
import com.example.todolist.R;
import com.example.todolist.singleItem;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class TaskAdapter extends RecyclerView.Adapter<TaskAdapter.ViewHolder> {
    public ArrayList<ListTask> mytasks;
    Context taskindex;

    public TaskAdapter(ArrayList<ListTask> mytasks, Context taskindex) {
        this.mytasks = mytasks;
        this.taskindex = taskindex;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView tvTaskname,tvTask1id,tvTask2id,tvtask3id,tvtask_time;
        ImageView ivpriority_icon,ivDeletetask;
        RadioButton done_rbtn;
        public ViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);
            tvTaskname=(TextView) itemView.findViewById(R.id.tvTaskname);
            tvTask1id=(TextView) itemView.findViewById(R.id.tvTask1id);
            tvTask2id=(TextView) itemView.findViewById(R.id.tvTask2id);
            tvtask3id=(TextView) itemView.findViewById(R.id.tvtask3id);
            tvtask_time=(TextView) itemView.findViewById(R.id.tvtask_time);
            ivpriority_icon= (ImageView) itemView.findViewById(R.id.ivpriority_icon);
            ivDeletetask= (ImageView) itemView.findViewById(R.id.ivDeletetask);
            done_rbtn= (RadioButton) itemView.findViewById(R.id.done_rbtn);
        }
    }
    @NonNull
    @NotNull
    @Override
    public TaskAdapter.ViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.task_items,parent,false);

        return new ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull TaskAdapter.ViewHolder holder, int position) {
           holder.tvTaskname.setText(mytasks.get(position).getName());
           holder.tvTask1id.setText(mytasks.get(position).getItem1());
           holder.tvTask2id.setText(mytasks.get(position).getItem2());
           holder.tvtask3id.setText(mytasks.get(position).getItem3());
           if(mytasks.get(position).getPriority().equals("H")){
                holder.ivpriority_icon.setImageResource(R.drawable.red);
           }
        else if(mytasks.get(position).getPriority().equals("M")){
            holder.ivpriority_icon.setImageResource(R.drawable.green);
        }
        else{
               holder.ivpriority_icon.setImageResource(R.drawable.yellow);
           }
        holder.tvtask_time.setText(mytasks.get(position).getTime());
        holder.ivDeletetask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Arraystatic.mytask.remove(position);
                notifyItemRemoved(position);
            }

        });
//        holder.done_rbtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Arraystatic.mytask.remove(position);
//                notifyItemRemoved(position);
//            }
//        });
    }

    @Override
    public int getItemCount() {
        return mytasks.size();
    }
}
