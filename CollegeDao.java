package com.dao;
import java.util.HashMap;
import com.user.College;
import com.user.Branch;

public class CollegeDao {
	HashMap<String, College> clgDetails = new HashMap<String, College>();
	public void addCollege(College college) {
		clgDetails.put(college.getCollegeCode(), college);
	}
	public void printAllColleges() {
		clgDetails.forEach((k,v) -> System.out.println(v.toString()));
	}
}
