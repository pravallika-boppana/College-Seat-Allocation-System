package com.user;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

import com.dao.CollegeDao;
import com.dao.StudentDao;
import com.user.RequestedAllotment;

public class CounsellingService {
	CollegeDao collegeDao = new CollegeDao();
	public RequestedAllotment addPreferences(long stuId, Preference pref[]) {
		RequestedAllotment requestedAllotment = new RequestedAllotment(stuId, pref);
		CollegeDao collegeDao = new CollegeDao();
		collegeDao.updatePrefenceCount(requestedAllotment);
		return requestedAllotment;
	}
	
	public void topDesirable(int x) {
	}
	
	public void topFilled(int x) {
		System.out.println("data received");
		
	}
	
	public void topUnfilled(int x) {
		System.out.println("data received");
		
	}

	public String getAllotedCollege(long stdId) {
		StudentDao studentDao = new StudentDao();
		return studentDao.getAllotedCollege(stdId);
		
	}
}
