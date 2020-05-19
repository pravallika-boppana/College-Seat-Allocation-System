package com.counselling.globalStore;

import java.util.ArrayList;
import java.util.PriorityQueue;

import com.counselling.user.College;

public class MinHeap {
	PriorityQueue<College> pq = new PriorityQueue<College>(500, new CollegeMinComparator());
	void enterCollege(College clg){
        this.pq.add(clg);
    }
    ArrayList<College> getTopX(int x){
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