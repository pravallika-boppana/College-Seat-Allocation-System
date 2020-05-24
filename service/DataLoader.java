package com.counselling.service;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import com.counselling.dao.CollegeDao;
import com.counselling.dao.StudentDao;
import com.counselling.user.Branch;
import com.counselling.user.College;
import com.counselling.user.Student;

import java.util.StringTokenizer;

public class DataLoader {
	static CollegeDao collegeDao = CollegeDao.getInstance();
	static StudentDao studentDao = StudentDao.getInstance();
	public void readDataFromFiles(String studentFile, String collegeFile) {
		String line = "";  
		try   
		{  
			//parsing a CSV file into BufferedReader class constructor 
			BufferedReader br = new BufferedReader(new FileReader(studentFile));  
			StringTokenizer studentDetails = null;
			while ((line = br.readLine()) != null)   //returns a Boolean value  
			{  
				studentDetails = new StringTokenizer(line, ",");
				//String studentDetails = line.split(splitBy);    // use comma as separator 
				String stuName = studentDetails.nextToken();
				long stuId = Long.parseLong(studentDetails.nextToken());
				long rank = Long.parseLong(studentDetails.nextToken());
				Student student = new Student(stuName,stuId ,rank );
				studentDao.addStudent(student);
			
			}
			//s.getAllStudents();
			line = "";
			StringTokenizer collegeDetails = null;
			br = new BufferedReader(new FileReader(collegeFile));
			while((line = br.readLine()) != null) {
				collegeDetails = new StringTokenizer(line, ",");
				String clgName = collegeDetails.nextToken();
				String clgId = collegeDetails.nextToken();
				int totalIntake = Integer.parseInt(collegeDetails.nextToken());
				College college = new College(clgName, clgId, totalIntake);
				while(collegeDetails.hasMoreTokens())
                {
					String branchId = collegeDetails.nextToken();
					int threshold = Integer.parseInt(collegeDetails.nextToken());
					int intake =  Integer.parseInt(collegeDetails.nextToken());
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
 