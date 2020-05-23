package com.counselling.service;

import java.util.ArrayList;

import com.counselling.globalStore.Data;
import com.counselling.user.College;

public class QueryingService {
	static public void topDesirable(int x){
		ArrayList<College> topDesirableColleges = Data.topDesirable.getTopX(x);
		System.out.println(topDesirableColleges);
		
	}
	static public void topFilled(int x){
		ArrayList<College> topFilledColleges = Data.topFilled.getTopX(x);
		System.out.println(topFilledColleges);
	}
	static public void topUnfilled(int x){
		ArrayList<College> topUnfilledColleges = Data.topUnfilled.getTopX(x);
		System.out.println(topUnfilledColleges);
	}
}
