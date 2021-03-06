package com.counselling.user;

import java.util.HashMap;

import com.counselling.user.Branch;

public class College {
	private String clgName;
	private String clgId;
	private int totalIntake;
	private int filled = 0;
	private int totalPref = 0;
	HashMap<String, Branch> branches = new HashMap<String, Branch>();
	
	public HashMap<String, Branch> getBranches() {
		return branches;
	}
	public void setBranches(HashMap<String, Branch> branches) {
		this.branches = branches;
	}
	public int getFilled() {
		return filled;
	}
	public void setFilled(int filled) {
		this.filled = filled;
	}
	public int getTotalPref() {
		return totalPref;
	}
	public void setTotalPref(int totalPref) {
		this.totalPref = totalPref;
	}
	public void addBranch(Branch branch) {
		branches.put(branch.getBranchId(), branch);
	}
	public College(String clgName, String clgId, int totalIntake) {
		super();
		this.clgName = clgName;
		this.clgId = clgId;
		this.totalIntake = totalIntake;
	}
	public String getClgName() {
		return clgName;
	}
	public void setClgName(String clgName) {
		this.clgName = clgName;
	}
	public String getClgId() {
		return clgId;
	}
	public void setClgId(String clgId) {
		this.clgId = clgId;
	}
	public int getTotalIntake() {
		return totalIntake;
	}
	public void setTotalIntake(int totalIntake) {
		this.totalIntake = totalIntake;
	}
	
	
	public float getFilledPercent(College college){
		float filledPercent = (float)college.getFilled()/college.getTotalIntake();
		return filledPercent*100;
	}
	public int getPreferredPercent(College college){
		int preferredPercent = college.getTotalPref()/college.getTotalIntake();
		return preferredPercent*100;
	}
	
	public int getUnfilled(College college) {
		return college.getTotalIntake() - college.getFilled();
	}
	public float getUnFilledPercent(College college){
		float unfilledPercent = (float)getUnfilled(college)/college.getTotalIntake();
		return unfilledPercent*100;
	}
	
	@Override
	public String toString() {
		return "College [clgName=" + clgName + ", clgId=" + clgId + ", totalIntake=" + totalIntake + ", branches="
				+ branches + "]";
	}
	
	
	
	
	
}