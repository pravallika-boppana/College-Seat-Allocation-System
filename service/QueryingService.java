package com.counselling.service;

import java.util.ArrayList;
import com.counselling.dao.CollegeDao;
import com.counselling.user.College;

public class QueryingService {
	static CollegeDao collegeDao = CollegeDao.getInstance();
	static public void topDesirable(int x){
		ArrayList<College> topDesirableColleges = collegeDao.getTopXDesirable(x);
		for(int i = 0; i < topDesirableColleges.size(); i++) {
			System.out.println((i + 1) + " " + topDesirableColleges.get(i).getClgId() + " " + topDesirableColleges.get(i).getTotalPref()); } }
	
	static public void topFilled(int x){
		ArrayList<College> topFilledColleges = CollegeDao.getTopXFilled(x);
		for(int i = 0; i < topFilledColleges.size(); i++) {
			System.out.println((i + 1) + " " + topFilledColleges.get(i).getClgId() + " " + topFilledColleges.get(i).getFilled()); } }
	static public void topUnfilled(int x){
		ArrayList<College> topUnFilledColleges = CollegeDao.getTopXUnFilled(x);;
		for(int i = 0; i < topUnFilledColleges.size(); i++) {
			System.out.println((i + 1) + " " + topUnFilledColleges.get(i).getClgId() + " " + topUnFilledColleges.get(i).getFilled()); } }
	}
