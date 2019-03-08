package com.priorityproperties.avantaricalendar;

import java.util.ArrayList;
import java.util.List;

public class Util {

    static ArrayList<Alarams> arrayList;
    static List<Integer> isSetList1,isSetList2,isSetList3;
   public static ArrayList<Alarams>  setList(){
       arrayList= new ArrayList<>();
       isSetList1=new ArrayList<>();
       isSetList2=new ArrayList<>();
       isSetList3=new ArrayList<>();
       setAlarm();
       return arrayList;
   }

    public static void setAlarm(){
        Alarams alarams=new Alarams();
        alarams.setAlarmTime("5:30");
        for (int i=0;i<4;i++){

            isSetList1.add(1);
            isSetList1.add(0);
            isSetList1.add(1);
            isSetList1.add(0);
            isSetList1.add(1);
            isSetList1.add(0);
            isSetList1.add(1);
            alarams.setIsSet(isSetList1);

        }
        arrayList.add(alarams);
        Alarams alarams2=new Alarams();
        alarams2.setAlarmTime("6:30");
        for (int i=0;i<4;i++){

            isSetList2.add(0);
            isSetList2.add(0);
            isSetList2.add(0);
            isSetList2.add(0);
            isSetList2.add(0);
            isSetList2.add(0);
            isSetList2.add(0);
            alarams2.setIsSet(isSetList2);

        }
        arrayList.add(alarams2);
        Alarams alarams3=new Alarams();
        alarams3.setAlarmTime("4:30");
        for (int i=0;i<4;i++){

            isSetList3.add(1);
            isSetList3.add(0);
            isSetList3.add(0);
            isSetList3.add(0);
            isSetList3.add(1);
            isSetList3.add(1);
            isSetList3.add(1);
            alarams3.setIsSet(isSetList3);

        }
        arrayList.add(alarams3);



    }
}
