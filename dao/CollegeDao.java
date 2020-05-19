package com.counselling.dao;

import com.counselling.globalStore.Data;
import com.counselling.user.Branch;
import com.counselling.user.College;
import com.counselling.user.Preference;
import com.counselling.user.RequestedAllotment;

public class CollegeDao {
	public Data data = new Data();
	public void addCollege(College college) {
		Data.colleges.put(college.getClgId(), college);
	}
	
	public College getCollege(String clgId) {
		return Data.colleges.get(clgId);
	}
	
	public void getThreshold(String clgId) {
		Data.colleges.get(clgId).getBranches().forEach((k,v) -> System.out.println(v.getBranchId() + " " + v.getThreshold()));
	}
	public College getIntakeAndFilled(String clgId) {
		Data.colleges.get(clgId).getBranches().forEach((k,v) -> System.out.println(v.getBranchId() + " Intake : " + v.getIntake() + " Filled : " + v.getFilled()));
		return null; 
	}
	
	

	public void decrementFilled(Preference preference) {
		
		
	}

	

	public void incrementFilled(Preference preference) {
		College college = Data.colleges.get(preference.getClgId());
		Branch branch = Data.colleges.get(preference.getClgId()).getBranches().get(preference.getBranchId());
		branch.setFilled(branch.getFilled() + 1);
		college.setFilled(college.getFilled() + 1);
		college.getBranches().put(preference.getBranchId(), branch);
		Data.colleges.put(preference.getClgId(), college);
		
		
	}


	public void updatePrefenceCount(RequestedAllotment requestedAllotment) {
		for(Preference preference : requestedAllotment.getPreferences()) {
			College college = Data.colleges.get(preference.getClgId());
			college.setTotalPref(college.getTotalPref() + 1);
			Data.colleges.put(preference.getClgId(), college);
			System.out.println(preference.getClgId() + " " + Data.colleges.get(preference.getClgId()).getTotalPref());
		}
		
	}

	public Branch getBranchInCollege(String clgId, String branchId) {
		// TODO Auto-generated method stub
		return Data.colleges.get(clgId).getBranches().get(branchId);
	}
}