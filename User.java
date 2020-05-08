package com.user;
import java.io.BufferedReader;  
import java.io.FileReader;  
import java.io.IOException;
import java.io.InputStreamReader;

import com.dao.StudentDao;
import com.user.Student;
import com.dao.CollegeDao;;
public class User {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		String line = "";  
		String splitBy = ",";  
		try   
		{  
		//parsing a CSV file into BufferedReader class constructor  
		BufferedReader br = new BufferedReader(new FileReader("C:\\\\Users\\\\user\\\\Desktop\\\\acms project\\\\Counselling\\\\src\\\\student.csv"));  
		StudentDao s = new StudentDao();
		while ((line = br.readLine()) != null)   //returns a Boolean value  
		{  
		String[] studentDetails = line.split(splitBy);    // use comma as separator  
		
		Student student = new Student(studentDetails[0], Integer.parseInt(studentDetails[1]), Integer.parseInt(studentDetails[2]));
		s.addStudent(student);
		}
		s.getAllStudents();
		line = "";
		CollegeDao totalCollegeDetails = new CollegeDao();
		br = new BufferedReader(new FileReader("C:\\Users\\user\\Desktop\\acms project\\Counselling\\src\\college.csv"));
		while((line = br.readLine()) != null) {
		  String[] collegeDetails = line.split(splitBy);
		  College college = new College(collegeDetails[0], collegeDetails[1], Integer.parseInt(collegeDetails[2]));
		  for(int i = 3; i < collegeDetails.length; i += 3) {
			  Branch branch = new Branch(collegeDetails[i], Integer.parseInt(collegeDetails[i+1]), Integer.parseInt(collegeDetails[i+2]));
			  college.addBranch(branch);
		   }
		  totalCollegeDetails.addCollege(college);
		}
		totalCollegeDetails.printAllColleges();
		}
		catch (IOException e)
		{  
		e.printStackTrace();  
		}  
		/*BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter your choice:");
		System.out.println("1.Request seat allocation");
		System.out.println("2.Top X desirable colleges");
		System.out.println("3.Top X filled colleges");
		System.out.println("4.Top X unfilled colleges");
		int choice = Integer.parseInt(br.readLine());
		switch(choice) {
		case 1: System.out.println("Enter Student Id");
		}*/
		
		
	}

}
