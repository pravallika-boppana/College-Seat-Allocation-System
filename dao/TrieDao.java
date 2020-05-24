package com.counselling.dao;

import com.counselling.globalStore.Data;
import com.counselling.globalStore.Trie;
import com.counselling.globalStore.TrieObject;

public class TrieDao {
	
	public static String convertToString(Long id) {
        String idS = Long.toString(id);
        String temp = "";
        for(int i = 1; i <= 10 -idS.length(); i++) {
            temp += "0"; }
        return temp + idS; }
    
    public static void insertObject(Long stuId, TrieObject trieObject) {
    	String idS = convertToString(stuId);
    	Data data = Data.getInstance();
    	Trie root = data.students;
        for(int i = 0; i < 10; i++) {
            if (root.getChild()[idS.charAt(i) - 48] == null) {
            	root.getChild()[idS.charAt(i) - 48] = new Trie(); }
            root = root.getChild()[idS.charAt(i) - 48]; }
        root.setLeaf(true);
        root.setTrieObject(trieObject);
    	
        
    }
    
    
    public static TrieObject getObject(Long id) {
    	Data data = Data.getInstance();
    	Trie root = data.students;
    	String idS = convertToString(id);
    	for(int i = 0; i < 10; i++) {
            if (root.getChild()[idS.charAt(i) - 48] == null) {
            	return null; }           
            root = root.getChild()[idS.charAt(i) - 48]; }    	
            return root.getTrieObject(); }

	  }





