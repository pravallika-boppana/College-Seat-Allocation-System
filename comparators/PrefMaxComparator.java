package com.counselling.comparators;

import java.util.Comparator;

import com.counselling.user.College;

public class PrefMaxComparator implements Comparator<College>{
    public int compare(College c1, College c2){
        if(c1.getTotalPref() < c2.getTotalPref()){
            return 1;
        }
        if(c1.getTotalPref() > c2.getTotalPref()){
            return -1;
        }
        return 0;
    }
}