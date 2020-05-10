package com.user;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

import com.dao.CollegeDao;
import com.user.RequestedAllotment;
class CollegeComparator implements Comparator<College> {
	public int compare(College clg1, College clg2) {
		if(clg1.getTotalPref() < clg2.getTotalPref())
			return 1;
		else if(clg1.getTotalPref() > clg2.getTotalPref())
			return -1;
		return 0;
	}
}
public class CounsellingService {
	RequestedAllotment addPref = new RequestedAllotment();
	CollegeDao college = new CollegeDao();
	College clg = new College();
	public RequestedAllotment addPreferences(long stuId, ArrayList<String[]> pref) {
		
		addPref.setStuId(stuId);
		for(int i = 0; i < 3; i++) {
			addPref.preferences[i] = new Preference(pref.get(i)[0], pref.get(i)[1]);
			if(college.addClg.clgDetails.containsKey(pref.get(i)[0])) {
				clg = college.addClg.clgDetails.get(pref.get(i)[0]);
				clg.setTotalPref( clg.getTotalPref() + 1);
				System.out.println(clg.getTotalPref());
			}
		}
		return addPref;
	}
	
	public void topDesirable(int x) {
		System.out.println("data received");
		String[] topDesirableClgs = new String[x];
		PriorityQueue<College> clgTotalPref = new PriorityQueue<College>(x, new CollegeComparator());
		college.addClg.clgDetails.forEach((k,v) -> clgTotalPref.add(v));
		for(int i = 0; i < x; i++) {
			System.out.println(topDesirableClgs[i] = clgTotalPref.poll().getClgName());
		}
	}
	
	public void topFilled(int x) {
		System.out.println("data received");
		
	}
	
	public void topUnfilled(int x) {
		System.out.println("data received");
		
	}
}
