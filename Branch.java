package com.user;

public class Branch {
	private String branchId;
	private int threshold;
	private int intake;
	public Branch(String branchId, int threshold, int intake) {
		super();
		this.branchId = branchId;
		this.threshold = threshold;
		this.intake = intake;
	}
	public String getBranchId() {
		return branchId;
	}
	public void setBranchId(String branchId) {
		this.branchId = branchId;
	}
	public int getThreshold() {
		return threshold;
	}
	@Override
	public String toString() {
		return "Branch [branchId=" + branchId + ", threshold=" + threshold + ", intake=" + intake + "]";
	}
	public void setThreshold(int threshold) {
		this.threshold = threshold;
	}
	public int getIntake() {
		return intake;
	}
	public void setIntake(int intake) {
		this.intake = intake;
	}
}
