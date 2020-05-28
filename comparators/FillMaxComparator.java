package com.counselling.comparators;

import java.util.Comparator;

import com.counselling.user.College;

public class FillMaxComparator implements Comparator<College>{
	public int compare(College c1, College c2){
        if(c1.getFilledPercent() < c2.getFilledPercent()){
            return 1;
        }
        if(c1.getFilledPercent() > c2.getFilledPercent()){
            return -1;
        }
        return 0;
    }

}