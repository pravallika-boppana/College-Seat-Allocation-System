package com.user;

import java.util.HashMap;
import com.user.Branch;

public class College {
	private String collegeName;
	private String collegeCode;
	int totalIntake;
	HashMap<String, Branch> branches = new HashMap<String, Branch>();
	public void addBranch(Branch branch) {
		branches.put(branch.getBranchId(), branch);
	}
	public String getCollegeName() {
		return collegeName;
	}
	public void setCollegeName(String collegeName) {
		this.collegeName = collegeName;
	}
	public String getCollegeCode() {
		return collegeCode;
	}
	public void setCollegeCode(String collegeCode) {
		this.collegeCode = collegeCode;
	}
	public int getTotalIntake() {
		return totalIntake;
	}
	public void setTotalIntake(int totalIntake) {
		this.totalIntake = totalIntake;
	}
	public College(String collegeName, String collegeCode, int totalIntake) {
		super();
		this.collegeName = collegeName;
		this.collegeCode = collegeCode;
		this.totalIntake = totalIntake;
	}
	@Override
	public String toString() {
		return "College [collegeName=" + collegeName + ", collegeCode=" + collegeCode + ", totalIntake=" + totalIntake
				+ ", branches=" + branches + "]";
	}
}
