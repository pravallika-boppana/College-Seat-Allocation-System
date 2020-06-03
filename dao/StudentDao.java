package com.counselling.dao;

import com.counselling.globalStore.TrieObject;
import com.counselling.user.Preference;
import com.counselling.user.RequestedAllotment;
import com.counselling.user.Student;

public class StudentDao {
	
	static StudentDao studentDao = null;
	
	private StudentDao() {};
	
	public static  StudentDao getInstance() {
		if (studentDao == null) {
			studentDao = new StudentDao(); }
	    return studentDao;
	}
	
    public void addStudent(Student student) {
    	TrieObject trieObject = new TrieObject(student);
    	TrieDao.insertObject(student.getStuId(), trieObject); }
    
    
    public Student getStudent(Long id) throws NullPointerException
    {
    	try {
    	    return TrieDao.getObject(id).getStudent(); 
    	}
    	catch(NullPointerException n) {
    	
    	}
		return null;
		}
    

	public String getAllotedCollege(long stdId) {
		RequestedAllotment requestedAllotment = TrieDao.getObject(stdId).getRequestedAllotment();
		if (requestedAllotment == null) return "not appeared for counselling";
		Preference preferences[] = requestedAllotment.getPreferences(); 
		int allotedPreference = requestedAllotment.getAllotedPreference();
		if (allotedPreference == -1) return "Student is eligible for none of his preferences";
		String college =  preferences[allotedPreference].getClgId();
		String branch = preferences[allotedPreference].getBranchId();
		return college + " " + branch;
	}

	public boolean isValidStudent(long stuId) {
		if (getStudent(stuId) != null) return true;		
		return false;
	}
    
}
