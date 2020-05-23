package com.counselling.globalStore;

import java.util.*;

import com.counselling.user.College;
public class MaxHeapPref {
	PriorityQueue<College> pq = new PriorityQueue<College>(500, new PrefMaxComparator());
	void enterCollege(College clg){
        this.pq.add(clg);
    }
    public ArrayList<College> getTopX(int x){
    	ArrayList<College> ar = new ArrayList<>();
        for(int i = 0;i < x;i++){
            ar.add(this.pq.poll());
        }
        for(College i :ar){
            this.pq.add(i);
        }
        return ar;
    } 
    void updateCollegePreference(College college){
    	if(this.pq.contains(college)){
    		this.pq.remove(college);
    	}
    	this.pq.add(college);
    }
}
