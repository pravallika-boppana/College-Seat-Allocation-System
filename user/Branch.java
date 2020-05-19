package com.counselling.user;

import java.util.PriorityQueue;

public class Branch {
	private String branchId;
	private int intake;
	private int threshold;
	private int filled;
	private PriorityQueue<Student> allotedRanks = new PriorityQueue<Student>(new RankMaxComparator());
	public Branch(int filled) {
		super();
		this.filled = filled;
	}
	public int getFilled() {
		return filled;
	}
	public void setFilled(int filled) {
		this.filled = filled;
	}
	public Branch(String branchId, int intake, int threshold) {
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
	public PriorityQueue<Student> getAllotedRanks() {
		return allotedRanks;
	}
	public void setAllotedRanks(PriorityQueue<Student> allotedRanks) {
		this.allotedRanks = allotedRanks;
	}
}