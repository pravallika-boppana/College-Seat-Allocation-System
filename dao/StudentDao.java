package com.counselling.dao;

import com.counselling.globalStore.TrieObject;
import com.counselling.user.Preference;
import com.counselling.user.RequestedAllotment;
import com.counselling.user.Student;

public class StudentDao {
	
	static StudentDao studentDao = null;
	
	public StudentDao() {};
	
	public static  StudentDao getInstance() {
		if (studentDao == null) {
			studentDao = new StudentDao(); }
	    return studentDao;
	}
	
    public void addStudent(Student student) {
    	TrieObject trieObject = new TrieObject(student);
    	TrieDao.insertObject(student.getStuId(), trieObject); }
    
    
    public Student getStudent(Long id) {
    	return TrieDao.getObject(id).getStudent(); }
    

	public String getAllotedCollege(long stdId) {
		RequestedAllotment requestedAllotment = TrieDao.getObject(stdId).getRequestedAllotment();
		Preference preferences[] = requestedAllotment.getPreferences(); 
		int allotedPreference = requestedAllotment.getAllotedPreference();
		if (allotedPreference == -1) return "not alloted";
		String college =  preferences[allotedPreference].getClgId();
		String branch = preferences[allotedPreference].getBranchId();
		return college + " " + branch;
	}
    
}
