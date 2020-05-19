package com.counselling.user;

public class Preference {
	private String clgId;
	private String branchId;
	public Preference(String clgId, String branchId) {
		this.clgId = clgId;
		this.branchId = branchId;
	}
	public String getClgId() {
		return clgId;
	}
	public void setClgId(String clgId) {
		this.clgId = clgId;
	}
	public String getBranchId() {
		return branchId;
	}
	public void setBranchId(String branchId) {
		this.branchId = branchId;
	}
	@Override
	public String toString() {
		return "Preference [clgId=" + clgId + ", branchId=" + branchId + "]";
	}
	

}