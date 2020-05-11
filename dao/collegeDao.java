package com.dao;

import com.globalStore.Data;
import com.user.Branch;
import com.user.College;
import com.user.Preference;
import com.user.RequestedAllotment;

public class CollegeDao {
	public Data data = new Data();
	public void addCollege(College college) {
		Data.colleges.put(college.getClgId(), college);
	}
	
	public College getCollege(String clgId) {
		return Data.colleges.get(clgId);
	}
	
	public College getThreshold(String clgId) {
		System.out.println(Data.colleges.containsKey(clgId));
		return null; }
	
	

	public void decrementFilled(Preference preference) {
		
		
		
	}

	

	public void incrementFilled(Preference preference) {
		
		
	}

	public College getCollege(Preference preference) {
		// TODO Auto-generated method stub
		return Data.colleges.get(preference.getClgId());
	}

	public void updatePrefenceCount(RequestedAllotment requestedAllotment) {
		// TODO Auto-generated method stub
		
	}

	public Branch getBranch(String clgId, String branchId) {
		// TODO Auto-generated method stub
		return Data.colleges.get(clgId).getBranches().get(branchId);
	}
}
