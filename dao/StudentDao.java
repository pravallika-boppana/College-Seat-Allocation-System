package com.counselling.dao;

import com.counselling.globalStore.Data;
import com.counselling.globalStore.Trie;
import com.counselling.user.Preference;
import com.counselling.user.RequestedAllotment;
import com.counselling.user.Student;

public class StudentDao {
	
    public void addStudent(Student student) {
    	Trie.insertStudent(Data.students, student.getStuId(), student);
    	Student s1 = Trie.getStudent(Data.students, student.getStuId());
    	}
    
    
    public Student getStudent(Long id) {
    	return Trie.getStudent(Data.students, id); }
    
    public RequestedAllotment getRequestedAllotment(long stuId) {
		return Trie.getRequestedAllotment(Data.students, stuId); }

	public void updateAllotedPreference(RequestedAllotment requestedAllotment, int i) {
		requestedAllotment.setAllotedPreference(i);
		Trie.updateRequestedAllotment(Data.students, requestedAllotment); }


	public String getAllotedCollege(long stdId) {
		RequestedAllotment requestedAllotment = Trie.getRequestedAllotment(Data.students, stdId);
		Preference preferences[] = requestedAllotment.getPreferences(); 
		int allotedPreference = requestedAllotment.getAllotedPreference();
		if (allotedPreference == -1) return "not alloted";
		String college =  preferences[allotedPreference].getClgId();
		String branch = preferences[allotedPreference].getBranchId();
		return college + " " + branch;
	}
    
}
