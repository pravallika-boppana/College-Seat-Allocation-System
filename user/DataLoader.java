package com.user;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import com.dao.CollegeDao;
import com.dao.StudentDao;

public class DataLoader {
	 CollegeDao collegeDao = new CollegeDao();
	 StudentDao studentDao = new StudentDao();
	public void readDataFromFiles(String studentFile, String collegeFile) {
		String line = "";  
		String splitBy = ","; 
		try   
		{  
		//parsing a CSV file into BufferedReader class constructor 
		BufferedReader br = new BufferedReader(new FileReader(studentFile));  
		while ((line = br.readLine()) != null)   //returns a Boolean value  
		{  
			String[] studentDetails = line.split(splitBy);    // use comma as separator 
			String stuName = studentDetails[0];
			long stuId = Long.parseLong(studentDetails[1]);
			long rank = Long.parseLong(studentDetails[2]);
			Student student = new Student(stuName,stuId ,rank );
			studentDao.addStudent(student);
		}
		//s.getAllStudents();
		line = "";
		br = new BufferedReader(new FileReader(collegeFile));
		while((line = br.readLine()) != null) {
			  String[] collegeDetails = line.split(splitBy);
			  String clgName = collegeDetails[0];
			  String clgId = collegeDetails[1];
			  int totalIntake = Integer.parseInt(collegeDetails[2]);
			  College college = new College(clgName, clgId, totalIntake);
			  for(int i = 3; i < collegeDetails.length; i += 3) {
				  String branchId = collegeDetails[i];
				  int threshold = Integer.parseInt(collegeDetails[i+1]);
				  int intake =  Integer.parseInt(collegeDetails[i+2]);
				  Branch branch = new Branch(branchId, threshold, intake);
				  college.addBranch(branch);
			   }  
			  collegeDao.addCollege(college);
		}
		//totalCollegeDetails.printAllColleges();
		}
		catch (IOException e)
		{  
		e.printStackTrace();  
		} 
	}
}
 