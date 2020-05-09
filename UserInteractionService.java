package com.user;
import java.io.BufferedReader;  
import java.io.FileReader;  
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import com.dao.StudentDao;
import com.globalStore.Data;
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
		try   
		{  
		//parsing a CSV file into BufferedReader class constructor  
		BufferedReader br = new BufferedReader(new FileReader("C:\\\\Users\\\\user\\\\Desktop\\\\acms project\\\\Counselling\\\\src\\\\student.csv"));  
		StudentDao s = new StudentDao();
		while ((line = br.readLine()) != null)   //returns a Boolean value  
		{  
		String[] studentDetails = line.split(splitBy);    // use comma as separator  
		
		Student student = new Student(studentDetails[0], Long.parseLong(studentDetails[1]), Long.parseLong(studentDetails[2]));
		s.addStudent(student);
		}
		s.getAllStudents();
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
		totalCollegeDetails.printAllColleges();
		//Data dp = new Data();
		//dp.print();
		//dp.printAllColleges();
		}
		catch (IOException e)
		{  
		e.printStackTrace();  
		}  
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter your choice:");
		System.out.println("1.Request seat allocation");
		System.out.println("2.Top X desirable colleges");
		System.out.println("3.Top X filled colleges");
		System.out.println("4.Top X unfilled colleges");
		System.out.println("5.Get Alloted College");
		System.out.println("6.Get Threshold of the college");
		int choice = Integer.parseInt(br.readLine());
		int x;
		switch(choice) {
		case 1: System.out.println("Enter Student Id");
				long stuId = Long.parseLong(br.readLine());
				System.out.println("Enter Student preferences as college Id and Branch Id");
				ArrayList<String[]> pref = new ArrayList<String[]>();
				for(int i = 0; i < 3; i++) {
					String[] preferences = br.readLine().split(" ");
					pref.add(preferences);
				}
				CounsellingService c = new CounsellingService();
				RequestedAllotment ra = c.addPreferences(stuId, pref);
				//c.print();
				break;
		case 2:System.out.println("How many top desirable colleges you want");
				x = Integer.parseInt(br.readLine());
				CounsellingService ch = new CounsellingService();
		case 3:System.out.println("How many top filled colleges you want");
				x = Integer.parseInt(br.readLine());
		case 4:System.out.println("How many top unfilled colleges you want");
				x = Integer.parseInt(br.readLine());
		case 5:System.out.println("Enter student Id");
				long stdId = Long.parseLong(br.readLine());
		case 6:System.out.println("Enter college id");
				String clgId = br.readLine();
				//clg.getThreshold(clgId);
				//CollegeDao p = new CollegeDao();
				college.getThreshold(clgId);
				
		}
		
		
	}

}
