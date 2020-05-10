package com.dao;
import java.util.HashMap;
import com.user.College;
import com.user.Preference;
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

	

	public void decrementFilled() {
		// TODO Auto-generated method stub
		
	}

	public College getCollege(Preference pre) {
		// TODO Auto-generated method stub
		return null;
	}

	public void incrementFilled(Preference preference) {
		// TODO Auto-generated method stub
		
	}
}
