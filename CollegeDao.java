package com.dao;
import java.util.HashMap;
import com.user.College;
import com.globalStore.Data;
import com.user.Branch;

public class CollegeDao {
	public Data addClg;
	public void addCollege(College college) {
		addClg.clgDetails.put(college.getClgId(), college);
		System.out.println(addClg.clgDetails.size());
	}

	public void printAllColleges() {
		addClg.clgDetails.forEach((k,v) -> System.out.println(v.toString()));
		System.out.println(addClg.clgDetails.size());
	}
}

