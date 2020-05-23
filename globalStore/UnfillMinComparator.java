package com.counselling.globalStore;

import java.util.Comparator;

import com.counselling.user.College;

public class UnfillMinComparator implements Comparator<College>{
	public int compare(College c1, College c2){
		int unfilled1 = c1.getTotalIntake() - c1.getFilled();
		int unfilled2 = c2.getTotalIntake() - c2.getFilled();
        if(unfilled1() < unfilled2()){
            return 1;
        }
        if(unfilled1() > unfilled2()){
            return -1;
        }
        return 0;
    }

}
