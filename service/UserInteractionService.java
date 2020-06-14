package com.counselling.service;
import java.io.BufferedReader;  
import java.io.IOException;
import java.io.InputStreamReader;
import com.counselling.dao.CollegeDao;
import com.counselling.dao.StudentDao;
import com.counselling.user.Preference;
import com.counselling.user.RequestedAllotment;
import com.counselling.service.AllotmentService;;
public class UserInteractionService {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static CollegeDao collegeDao = CollegeDao.getInstance();
	static AllotmentService allotmentService = AllotmentService.getInstance();
	static QueryingService queryingService = QueryingService.getInstance();
	static StudentDao studentDao = StudentDao.getInstance();
	public static boolean checkRange(int x) {
		if (x > 0 && x < 20) 
			return true;
		return false;
	}
	
	public static void processRequest(int choice) throws  IOException {
		int x;
		switch(choice) {
			case 1: System.out.println("Enter Student Id");
			try {
				long stuId = Long.parseLong(br.readLine()); 
		        if (!studentDao.isValidStudent(stuId)) {
					System.out.println("invalid student id");
					break; } 			        
				System.out.println("Enter Student preferences as college Id and Branch Id");
				Preference[] preferences = new Preference[3];
				boolean inValid = false;
				for(int i = 0; i < 3; i++) {
					String[] preference = br.readLine().split(" ");
					if(collegeDao.isValidClgId(preference[0]) && collegeDao.isValidBranchId(preference[1]) && collegeDao.doesBranchPresentInCollege(preference[0], preference[1]))
						preferences[i] = new Preference(preference[0], preference[1]);
					else {
						inValid = true;
						break; }
				}
				if (inValid) break;
				RequestedAllotment requestedAllotment = new RequestedAllotment(stuId, preferences);
                CounsellingThread counsellingThread = new CounsellingThread(requestedAllotment, allotmentService, collegeDao);
                counsellingThread.start();
				}
				catch(NumberFormatException e) {
					System.out.println("Invald student Id format");
				}
					
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
					System.out.println(queryingService.getAllotedCollege(stdId));
					break;
			case 6:System.out.println("Enter college id");
					String clgId = br.readLine();
					collegeDao.getThreshold(clgId);
					break;
			case 7:System.out.println("Enter college id");
			    String clgId2 = br.readLine();
			    collegeDao.getIntakeAndFilled(clgId2);
			    break;
			default:System.out.println("Invalid choice");
			        break;
		}
	}

	public static void main(String[] args) throws IOException {
		DataLoader dataLoader = new DataLoader();
		String studentFile = args[0];
		String collegeFile = args[1];
		if(dataLoader.isFileExists(studentFile, collegeFile) && dataLoader.isFileEmpty(studentFile, collegeFile)) {
			dataLoader.readDataFromFiles(studentFile, collegeFile);
			int choice;
			while(true) {
				System.out.println("Enter your choice:");
				System.out.println("1.Request seat allocation");
				System.out.println("2.Top X desirable colleges");
				System.out.println("3.Top X filled colleges");
				System.out.println("4.Top X unfilled colleges");
				System.out.println("5.Get Alloted College");
				System.out.println("6.Get Threshold of the college");
				System.out.println("7.Get Intake and Filled of the college");
				choice = Integer.parseInt(br.readLine());
				processRequest(choice);
				System.out.println("Hit 'Y' to countinue or hit any key to exit");
				if(br.readLine().equalsIgnoreCase("Y"))
					continue;
				else
					System.out.println("Exited");
					break;
			}
		}
	}
}