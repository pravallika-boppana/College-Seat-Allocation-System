package com.user;

import java.util.ArrayList;
import com.user.RequestedAllotment;

public class CounsellingService {
	RequestedAllotment addPref = new RequestedAllotment();
	public RequestedAllotment addPreferences(long stuId, ArrayList<String[]> pref) {
		
		addPref.setStuId(stuId);
		for(int i = 0; i < 3; i++) {
			addPref.preferences[i] = new Preference(pref.get(i)[0], pref.get(i)[1]);
		}
		return addPref;
	}
	public void print() {
		System.out.println(addPref);
	}
}
