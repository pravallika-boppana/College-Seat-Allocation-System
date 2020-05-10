package com.globalStore;
import com.user.*;

import java.util.HashMap;
import com.user.College;
import com.user.Branch;

public class Data {
	public static HashMap<String, College> clgDetails = new HashMap<String, College>();
	public Trie root = new Trie();
	public void print() {
		System.out.println(clgDetails.size());
	}
	
	public static void storeClgDetails(College college) {
		clgDetails.put(college.getClgId(), college);
	}
	
	public void storeStudent(Student student, Long id) {
		root.insertStudent(root, id, student);
	}
}