package com.counselling.user;

import java.util.HashMap;

import com.counselling.user.Branch;

public class College {
	private String clgName;
	private String clgId;
	private int totalIntake;
	private int filled;
	private int totalPref;
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
	
	@Override
	public String toString() {
		return "College [clgName=" + clgName + ", clgId=" + clgId + ", totalIntake=" + totalIntake + ", branches="
				+ branches + "]";
	}
	
	
	
	
	
}