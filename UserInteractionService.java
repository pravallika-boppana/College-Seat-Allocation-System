package com.user;
import java.io.BufferedReader;  
import java.io.FileReader;  
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import com.dao.StudentDao;
import com.user.Student;
import com.dao.CollegeDao;;
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
		CollegeDao totalCollegeDetails = new CollegeDao();
		College college = new College();
		Student student = new Student();
		CounsellingService counselling = new CounsellingService();
		AllotmentService allotment = new AllotmentService();
		try   
		{  
		//parsing a CSV file into BufferedReader class constructor  
		BufferedReader br = new BufferedReader(new FileReader("C:\\\\Users\\\\user\\\\Desktop\\\\acms project\\\\Counselling\\\\src\\\\student.csv"));  
		StudentDao s = new StudentDao();
		while ((line = br.readLine()) != null)   //returns a Boolean value  
		{  
		String[] studentDetails = line.split(splitBy);    // use comma as separator  
		
		student = new Student(studentDetails[0], Long.parseLong(studentDetails[1]), Long.parseLong(studentDetails[2]));
		s.addStudent(student);
		}
		//s.getAllStudents();
		line = "";
		
		br = new BufferedReader(new FileReader("C:\\Users\\user\\Desktop\\acms project\\Counselling\\src\\college.csv"));
		while((line = br.readLine()) != null) {
		  String[] collegeDetails = line.split(splitBy);
		  college = new College(collegeDetails[0], collegeDetails[1], Integer.parseInt(collegeDetails[2]));
		  for(int i = 3; i < collegeDetails.length; i += 3) {
			  Branch branch = new Branch(collegeDetails[i], Integer.parseInt(collegeDetails[i+1]), Integer.parseInt(collegeDetails[i+2]));
			  college.addBranch(branch);
		   }
		  totalCollegeDetails.addCollege(college);
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
						ArrayList<String[]> pref = new ArrayList<String[]>();
						for(int i = 0; i < 3; i++) {
							String[] preferences = br.readLine().split(" ");
							pref.add(preferences);
						}
						RequestedAllotment ra = counselling.addPreferences(stuId, pref);
						allotment.allotClg(ra);
						break;
				case 2:System.out.println("How many top desirable colleges you want");
						x = Integer.parseInt(br.readLine());
						if(checkRange(x)) {
						
						System.out.println("Top " + x +" Desirable colleges");
						counselling.topDesirable(x);
						}
						else
							System.out.println("Data not available");
						break;
				case 3:System.out.println("How many top filled colleges you want");
						x = Integer.parseInt(br.readLine());
						if(checkRange(x)) {
							System.out.println("Top " + x +" filled colleges");
							counselling.topFilled(x);
						}
						else
							System.out.println("Data not available");
						break;
				case 4:System.out.println("How many top unfilled colleges you want");
						x = Integer.parseInt(br.readLine());
						if(checkRange(x)) {
							System.out.println("Top " + x +" unfilled colleges");
							counselling.topUnfilled(x);
						}
						else
							System.out.println("Data not available");
						break;
				case 5:System.out.println("Enter student Id");
						long stdId = Long.parseLong(br.readLine());
						System.out.println(student.getAllotedCollege(stdId));
						break;
				case 6:System.out.println("Enter college id");
						String clgId = br.readLine();
						college.getThreshold(clgId);
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
