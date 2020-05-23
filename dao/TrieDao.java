package com.counselling.dao;

import com.counselling.globalStore.Data;
import com.counselling.globalStore.Trie;
import com.counselling.globalStore.TrieObject;

public class TrieDao {
	
	static String convertToString(Long id) {
        String idS = Long.toString(id);
        String temp = "";
        for(int i = 1; i <= 10 -idS.length(); i++) {
            temp += "0"; }
        return temp + idS; }
    
    public static void insertObject(Long stuId, TrieObject trieObject) {
    	String idS = convertToString(stuId);
    	Data data = Data.getInstance();
        for(int i = 0; i < 10; i++) {
            if (data.students.getChild()[idS.charAt(i) - 48] == null) {
            	data.students.getChild()[idS.charAt(i) - 48] = new Trie(); }
            data.students = data.students.getChild()[idS.charAt(i) - 48]; }
        data.students.setLeaf(true);
        data.students.trieObject = trieObject;
        System.out.println("inserted student id : " + trieObject.getStudent().getStuId());
        
        Trie[] ar = data.students.getChild();
    	System.out.println("printing trie in insert method ");
    	for (int i = 0; i < 10; i++) {
    		if (ar[i] == null) {
    			System.out.println(i + " : null"); }
    		else 
    			System.out.println(i + "not null");
    	}
        
    }
    
    
    public static TrieObject getObject(Long id) {
    	Data data = Data.getInstance();
    	String idS = convertToString(id);
    	System.out.println("in TrieDao stuId : " + id);
    	Trie[] ar = data.students.getChild();
    	System.out.println("printing trie ");
    	for (int i = 0; i < 10; i++) {
    		if (ar[i] == null) {
    			System.out.println(i + " : null"); }
    		else 
    			System.out.println(i + "not null");
    	}
    	
    	
        for(int i = 0; i < 10; i++) {
            if (data.students.getChild()[idS.charAt(i) - 48] == null) {
                System.out.println("returned null at index " + i);
            	return null; }           
            data.students = data.students.getChild()[idS.charAt(i) - 48]; }
            System.out.println("in trie dao last return : " + data.students.getTrieObject().getStudent().getStuId());
            return data.students.getTrieObject(); }  }





