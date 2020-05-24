package com.counselling.globalStore;

import com.counselling.comparators.*;
import java.util.HashMap;
import java.util.PriorityQueue;

import com.counselling.user.*;

public class Data {
	private static Data data = null;
	public  HashMap<String, College> colleges = new HashMap<String, College>();
	public HashSet<String> branches = new HashSet<String>();
	public Trie students = new Trie(); 
	public PriorityQueue<College> topXDesirable = new PriorityQueue<>(new PrefMaxComparator());	
	public PriorityQueue<College> topXFilled = new PriorityQueue<>(new FillMaxComparator());	
	public PriorityQueue<College> topXUnFilled = new PriorityQueue<>(new UnfillMinComparator());
	
	
	private Data() { }
	
	public static Data getInstance() {
		if (data == null)
			data = new Data();
		return data; } }
	
