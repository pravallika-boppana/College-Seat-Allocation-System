package com.counselling.dao;

import java.util.ArrayList;
import com.counselling.globalStore.Data;
import com.counselling.user.Branch;
import com.counselling.user.College;
import com.counselling.user.Preference;
import com.counselling.user.RequestedAllotment;

public class CollegeDao {
	static Data data = Data.getInstance();
	static CollegeDao collegeDao = null;
	
	private CollegeDao() { }
	public static CollegeDao getInstance() {
	if (collegeDao == null) {
		collegeDao = new CollegeDao(); }
	return collegeDao; }
	
	public void addCollege(College college) {
		data.colleges.put(college.getClgId(), college);
	}
	
	public College getCollege(String clgId) {
		return data.colleges.get(clgId);
	}
	
	public void getThreshold(String clgId) {
		data.colleges.get(clgId).getBranches().forEach((k,v) -> System.out.println(v.getBranchId() + " " + v.getThreshold()));
	}
	
	public void getIntakeAndFilled(String clgId) {
		data.colleges.get(clgId).getBranches().forEach((k,v) -> System.out.println(v.getBranchId() + " Intake : " + v.getIntake() + " Filled : " + v.getFilled()));
		
	}
	
	public void updateFilled(Preference preference, int count) {
		College college = data.colleges.get(preference.getClgId());
		if (data.topXFilled.contains(college)) {
			data.topXFilled.remove(college); }
		if (data.topXUnFilled.contains(college)) {
			data.topXUnFilled.remove(college); }	
		Branch branch = data.colleges.get(preference.getClgId()).getBranches().get(preference.getBranchId());
		branch.setFilled(branch.getFilled() + count);
		
		college.setFilled(college.getFilled() + count);
		college.getBranches().put(preference.getBranchId(), branch);
		data.topXUnFilled.add(college);
		data.topXFilled.add(college);
		data.colleges.put(preference.getClgId(), college);
	}

	public void updatePrefenceCount(RequestedAllotment requestedAllotment) {
		for(Preference preference : requestedAllotment.getPreferences()) {
			College college = data.colleges.get(preference.getClgId());
			if (data.topXDesirable.contains(college)) {
				data.topXDesirable.remove(college); }
			college.setTotalPref(college.getTotalPref() + 1);
			data.colleges.put(preference.getClgId(), college);
			data.topXDesirable.add(college);
		}
	}

	public Branch getBranchInCollege(String clgId, String branchId) {
		Data data = Data.getInstance();
		return data.colleges.get(clgId).getBranches().get(branchId);
	}

	
	public static ArrayList<College> getTopXFilled(int x) {
		ArrayList<College> top = new ArrayList<>();
		while(data.topXFilled.size() > 0 && (x--) > 0) {
			top.add(data.topXFilled.poll()); }
		for (College college : top) {
			data.topXFilled.add(college); }
		return top;
	}
	
	public ArrayList<College> getTopXDesirable(int x) {
		ArrayList<College> top = new ArrayList<>();
		while(data.topXDesirable.size() > 0 && (x--) > 0) {
			top.add(data.topXDesirable.poll()); }
		for (College college : top) {
			data.topXDesirable.add(college); }
		return top; }
	
	public static ArrayList<College> getTopXUnFilled(int x) {
		ArrayList<College> top = new ArrayList<>();
		while(data.topXUnFilled.size() > 0 && (x--) > 0) {
			top.add(data.topXUnFilled.poll()); }
		for (College college : top) {
			data.topXUnFilled.add(college); }
		return top;
		
	}
	
	public void updateFilled(long stuId, Preference preference, int count) {
		College college = data.colleges.get(preference.getClgId());
		if (data.topXFilled.contains(college)) {
			data.topXFilled.remove(college); }
		if (data.topXUnFilled.contains(college)) {
			data.topXUnFilled.remove(college); }
		StudentDao studentDao = StudentDao.getInstance();
		Branch branch = data.colleges.get(preference.getClgId()).getBranches().get(preference.getBranchId());
		branch.setFilled(branch.getFilled() + count);
		if (count == 1) {
			branch.getAllotedRanks().add(studentDao.getStudent(stuId));}
		college.setFilled(college.getFilled() + count);
		college.getBranches().put(preference.getBranchId(), branch);
		data.topXUnFilled.add(college);
		data.topXFilled.add(college);
		data.colleges.put(preference.getClgId(), college);
		
		
	}
	
	public boolean isValidClgId(String clgId) {
        if(data.colleges.containsKey(clgId))
            return true;
        return false;
    }
    
    public boolean isValidBranchId(String branchId) {
        if(data.branches.contains(branchId))
            return true;
        return false;
    }
    public boolean is_Valid_Branch_In_Clg(String clgId, String branchId) {
        College college = data.colleges.get(clgId);
        if(college.branches.containsKey(branchId))
            return true;
        return false;
    }
}
