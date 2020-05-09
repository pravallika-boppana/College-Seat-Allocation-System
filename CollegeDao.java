package com.dao;
import java.util.HashMap;
import com.user.College;
import com.globalStore.Data;
import com.user.Branch;

public class CollegeDao {
	public Data addClg = new Data();
	public void addCollege(College college) {
		addClg.storeClgDetails(college);
		System.out.println(addClg.clgDetails.size());
	}
	
	public College getThreshold(String clgId) {
		return addClg.clgDetails.get(clgId);
		//System.out.println(addClg.clgDetails.get(clgId).branches.toString());
		//System.out.println(addClg.clgDetails.size());
	}
	public void printAllColleges() {
		addClg.clgDetails.forEach((k,v) -> System.out.println(v.toString()));
		System.out.println(addClg.clgDetails.size());
	}
}
