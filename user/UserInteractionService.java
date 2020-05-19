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
		// TODO Auto-generated method stub
		String line = "";  
		String splitBy = ",";  
		try   
		{  
		//parsing a CSV file into BufferedReader class constructor  
		BufferedReader br = new BufferedReader(new FileReader("//home//pravallika//Desktop//counsellingProject//student.csv"));  
		StudentDao studentDao = new StudentDao();
		while ((line = br.readLine()) != null)   //returns a Boolean value  
		{  
		String[] studentDetails = line.split(splitBy);    // use comma as separator  
		Student student = new Student(studentDetails[0], Long.parseLong(studentDetails[1]), Long.parseLong(studentDetails[2]));
		studentDao.addStudent(student);
		}
		//s.getAllStudents();
		line = "";
		
		br = new BufferedReader(new FileReader("//home//pravallika//Desktop//counsellingProject//college.csv"));
		while((line = br.readLine()) != null) {
		  String[] collegeDetails = line.split(splitBy);
		  College college = new College(collegeDetails[0], collegeDetails[1], Integer.parseInt(collegeDetails[2]));
		  for(int i = 3; i < collegeDetails.length; i += 3) {
			  Branch branch = new Branch(collegeDetails[i], Integer.parseInt(collegeDetails[i+1]), Integer.parseInt(collegeDetails[i+2]));
			  college.addBranch(branch);
		   }
		  CollegeDao collegeDao = new CollegeDao();
		  collegeDao.addCollege(college);
		}
		//totalCollegeDetails.printAllColleges();
		}
		catch (IOException e)
		{  
		e.printStackTrace();  
		}  
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int choice;
		int x;
		CounsellingService counsellingService = new CounsellingService();
		AllotmentService allotmentService = new AllotmentService();
		CollegeDao collegeDao = new CollegeDao();
		StudentDao studentDao = new StudentDao();
		while(true) {
			System.out.println("Enter your choice:");
			System.out.println("1.Request seat allocation");
			System.out.println("2.Top X desirable colleges");
			System.out.println("3.Top X filled colleges");
			System.out.println("4.Top X unfilled colleges");
			System.out.println("5.Get Alloted College");
			System.out.println("6.Get Threshold of the college");
			System.out.println("7.Get Intake and Filled number of seats  of College");
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
						    counsellingService.topDesirable(x);
						}
						else
							System.out.println("Invalid number");
						break;
				case 3:System.out.println("How many top filled colleges you want?(select a number < 20)");
						x = Integer.parseInt(br.readLine());
						if(checkRange(x)) {
							System.out.println("Top " + x +" filled colleges");
							counsellingService.topFilled(x);
						}
						else
							System.out.println("Invalid number");
						break;
				case 4:System.out.println("How many top unfilled colleges you want?(select a number < 20)");
						x = Integer.parseInt(br.readLine());
						if(checkRange(x)) {
							System.out.println("Top " + x +" unfilled colleges");
							counsellingService.topUnfilled(x);
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
				case 7:System.out.println("Enter College ID : ");
				       String clgId2 = br.readLine();
				       collegeDao.getIntakeAndFilled(clgId2);
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