package com.priorityproperties.avantaricalendar;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Switch;
import android.widget.TextView;

import java.util.ArrayList;

public class AdapterAlarm extends RecyclerView.Adapter<AdapterAlarm.ViewHolder> {


    ArrayList<Alarams> alarmsArrayList;
    Context context;


    public AdapterAlarm(ArrayList<Alarams> alarmsArrayList, Context context) {
        this.alarmsArrayList = alarmsArrayList;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_item,parent,false));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {


      ArrayList<Integer> integerArrayList= (ArrayList<Integer>) alarmsArrayList.get(position).getIsSet();

      for (int k=0;k<integerArrayList.size();k++){

          if (integerArrayList.contains(1))
          holder.vSW_set_larm.setChecked(true);
          else
          holder.vSW_set_larm.setChecked(false);
          if (integerArrayList.get(k).equals(1)){

              setActiveTextColor(holder,k);
          }else if (integerArrayList.get(k).equals(0)) {
              setDeActiveTextColor(holder,k);

          }
      }
      holder.alarmTime.setText(alarmsArrayList.get(position).getAlarmTime());

    }

    private void setDeActiveTextColor(ViewHolder holder, int position) {
        if (position==0){
            holder.sunday.setTextColor(context.getResources().getColor(R.color.deactive_grey));
        }
        if (position==1){
            holder.monday.setTextColor(context.getResources().getColor(R.color.deactive_grey));
        }
        if (position==2){
            holder.tuesday.setTextColor(context.getResources().getColor(R.color.deactive_grey));
        }
        if (position==3){
            holder.wednesday.setTextColor(context.getResources().getColor(R.color.deactive_grey));
        }
        if (position==4){
            holder.thursday.setTextColor(context.getResources().getColor(R.color.deactive_grey));
        }
        if (position==5){
            holder.friday.setTextColor(context.getResources().getColor(R.color.deactive_grey));
        }
        if (position==6){
            holder.saturday.setTextColor(context.getResources().getColor(R.color.deactive_grey));
        }
    }

    private void setActiveTextColor(ViewHolder holder, int position) {
        if (position==0){
            holder.sunday.setTextColor(context.getResources().getColor(R.color.blue));
        }
        if (position==1){
            holder.monday.setTextColor(context.getResources().getColor(R.color.blue));
        }
        if (position==2){
            holder.tuesday.setTextColor(context.getResources().getColor(R.color.blue));
        }
        if (position==3){
            holder.wednesday.setTextColor(context.getResources().getColor(R.color.blue));
        }
        if (position==4){
            holder.thursday.setTextColor(context.getResources().getColor(R.color.blue));
        }
        if (position==5){
            holder.friday.setTextColor(context.getResources().getColor(R.color.blue));
        }
        if (position==6){
            holder.saturday.setTextColor(context.getResources().getColor(R.color.blue));
        }
    }

    @Override
    public int getItemCount() {
        return alarmsArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        Switch vSW_set_larm;
        TextView alarmTime;
        TextView sunday,monday,tuesday,wednesday,thursday,friday,saturday;
        public ViewHolder(View itemView) {
            super(itemView);
            alarmTime=itemView.findViewById(R.id.vT_alarm_time);
            vSW_set_larm=itemView.findViewById(R.id.vSW_set_larm);
            sunday=itemView.findViewById(R.id.vT_sunday);
            monday=itemView.findViewById(R.id.vT_monday);
            tuesday=itemView.findViewById(R.id.vT_tuesday);
            wednesday=itemView.findViewById(R.id.vT_wednesday);
            thursday=itemView.findViewById(R.id.vT_thursday);
            friday=itemView.findViewById(R.id.vT_friday);
            saturday=itemView.findViewById(R.id.vT_saturday);
        }
    }
}
