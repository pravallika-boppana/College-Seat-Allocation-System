package com.counselling.service;

import com.counselling.dao.CollegeDao;
import com.counselling.dao.StudentDao;
import com.counselling.user.Preference;
import com.counselling.user.RequestedAllotment;

public class CounsellingService {
	static CollegeDao collegeDao = CollegeDao.getInstance();
	static StudentDao studentDao = StudentDao.getInstance();
	
	public RequestedAllotment addPreferences(long stuId, Preference pref[]) {
		RequestedAllotment requestedAllotment = new RequestedAllotment(stuId, pref);
		collegeDao.updatePrefenceCount(requestedAllotment);
		return requestedAllotment;
	}

	public String getAllotedCollege(long stdId) {

		return studentDao.getAllotedCollege(stdId);
		
	}
}
