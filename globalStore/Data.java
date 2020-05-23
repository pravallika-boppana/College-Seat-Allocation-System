package com.counselling.globalStore;
import java.util.HashMap;
import java.util.PriorityQueue;

import com.counselling.user.*;

public class Data {
	public static HashMap<String, College> colleges = new HashMap<String, College>();
	public static Trie students = new Trie();
	public static  MaxHeap topDesirable = new MaxHeap();
	public static  MaxHeap topFilled = new MaxHeap();
	public static  MinHeap topUnfilled = new MinHeap();	 }
