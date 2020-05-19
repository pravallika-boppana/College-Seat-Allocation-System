package com.counselling.globalStore;
import java.util.HashMap;
import java.util.PriorityQueue;

import com.counselling.user.*;

public class Data {
	public static HashMap<String, College> colleges = new HashMap<String, College>();
	public static Trie students = new Trie();
	public static PriorityQueue<College> topXDesirable = new PriorityQueue<>(new PrefMaxComparator());	
	public static PriorityQueue<College> topXFilled = new PriorityQueue<>(new FillMaxComparator());	
	public static PriorityQueue<College> topXunFilled = new PriorityQueue<>(new UnfillMinComparator());	 }