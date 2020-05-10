package com.dao;
import java.util.ArrayList;

import com.globalStore.Data;
import com.globalStore.Trie;
import com.user.RequestedAllotment;
import com.user.Student;

public class StudentDao {
	Data data = new Data();
    public void addStudent(Student student) {
    	data.storeStudent(student, student.getStuId());
    }
    
    public Student getStudent(Long id) {
    	return Trie.getStudent(data.root, id);
    	    	
    }
    
    public void updateAllotedPreference(int i) {
    	
    }

	public String getClg(Long stdId) {
		// TODO Auto-generated method stub
		return null;
	}

	public RequestedAllotment getRequestedAllotment(long stuId) {
		// TODO Auto-generated method stub
		return null;
	}
    
}