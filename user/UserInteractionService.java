package com.counselling.user;
import java.io.BufferedReader;  
import java.io.FileReader;  
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import com.counselling.dao.CollegeDao;
import com.counselling.dao.StudentDao;
import com.counselling.service.CounsellingService;
import com.counselling.service.AllotmentService;
import com.counselling.user.Student;;
public class UserInteractionService {
	public static boolean checkRange(int x) {
		if (x > 0 && x < 20) 
			return true;
		return false;
	}
	public static void main(String[] args) throws IOException {
		CollegeDao collegeDao = new CollegeDao();
		CounsellingService counsellingService = new CounsellingService();
		AllotmentService allotmentService = new AllotmentService();
		DataLoader dataLoader = new DataLoader();
		String studentFile = args[0];
		String collegeFile = args[1];
		dataLoader.readDataFromFiles(studentFile, collegeFile);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int choice;
		int x;
		while(true) {
			System.out.println("Enter your choice:");
			System.out.println("1.Request seat allocation");
			System.out.println("2.Top X desirable colleges");
			System.out.println("3.Top X filled colleges");
			System.out.println("4.Top X unfilled colleges");
			System.out.println("5.Get Alloted College");
			System.out.println("6.Get Threshold of the college");
			choice = Integer.parseInt(br.readLine());
			switch(choice) {
				case 1: System.out.println("Enter Student Id");
						long stuId = Long.parseLong(br.readLine());
						System.out.println("Enter Student preferences as college Id and Branch Id");
						Preference[] preferences = new Preference[3];
						for(int i = 0; i < 3; i++) {
							String[] preference = br.readLine().split(" ");
							preferences[i] = new Preference(preference[0], preference[1]);
						}
						RequestedAllotment requestAllotment = counsellingService.addPreferences(stuId, preferences);
						allotmentService.allotClg(requestAllotment);
						break;
				case 2:System.out.println("How many top desirable colleges you want?(select a number < 20)");
						x = Integer.parseInt(br.readLine());
						if(checkRange(x)) {						
     					    System.out.println("Top " + x +" Desirable colleges");
						    QueryingService.topDesirable(x);
						}
						else
							System.out.println("Invalid number");
						break;
				case 3:System.out.println("How many top filled colleges you want?(select a number < 20)");
						x = Integer.parseInt(br.readLine());
						if(checkRange(x)) {
							System.out.println("Top " + x +" filled colleges");
							QueryingService.topFilled(x);
						}
						else
							System.out.println("Invalid number");
						break;
				case 4:System.out.println("How many top unfilled colleges you want?(select a number < 20)");
						x = Integer.parseInt(br.readLine());
						if(checkRange(x)) {
							System.out.println("Top " + x +" unfilled colleges");
							QueryingService.topUnfilled(x);
						}
						else
							System.out.println("Invalid number");
						break;
				case 5:System.out.println("Enter student Id");
						long stdId = Long.parseLong(br.readLine());
						System.out.println(counsellingService.getAllotedCollege(stdId));
						break;
				case 6:System.out.println("Enter college id");
						String clgId = br.readLine();
						collegeDao.getThreshold(clgId);
						break;	
				default:System.out.println("Invalid choice");
				        break;
			}
			System.out.println("Do you want to continue(YES / NO)");
			if(br.readLine().equals("NO"))
				break;
		}
	}
}
