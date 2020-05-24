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
	CollegeDao collegeDao = new CollegeDao();
	StudentDao studentDao = new StudentDao();

	public boolean isFileExists(String studentFile, String collegeFile) {
		if(new File(studentFile).exists() && new File(collegeFile).exists()) 
			return true;
		else { 
			if((!new File(studentFile).exists()) && (!new File(collegeFile).exists()))
				System.out.println("Both the given files not exists");
			else if(!new File(studentFile).exists())
				System.out.println("Given student file not exists");
			else if(!new File(collegeFile).exists())
				System.out.println("Given college file not exists");
			return false;
		}	
	}
	public boolean isFileEmpty(String studentFile, String collegeFile) {
		if(new File(studentFile).length() > 0 && new File(collegeFile).length() > 0)
			return true;
		else {
			if(new File(studentFile).length() == 0 && new File(collegeFile).length() == 0)
				System.out.println("Both the given files are empty");
			else if(new File(studentFile).length() == 0)
				System.out.println("Given student file is empty");
			else if(new File(collegeFile).length() == 0)
				System.out.println("Given college file is empty");
			return false;
		}	
	}
	public void readDataFromFiles(String studentFile, String collegeFile) {
		String line = "";  
		try   
		{  
			//parsing a CSV file into BufferedReader class constructor 
			BufferedReader br = new BufferedReader(new FileReader(studentFile));  
			StringTokenizer studentDetails = null;
			while ((line = br.readLine()) != null)   
			{  
				studentDetails = new StringTokenizer(line, ",");
				try {
					String stuName = studentDetails.nextToken();
					long stuId = Long.parseLong(studentDetails.nextToken());
					long rank = Long.parseLong(studentDetails.nextToken());
					if((stuName.matches("^[ a-zA-Z]*$")) && (stuId == (int)stuId) && (rank == (int)rank)) {
						Student student = new Student(stuName,stuId ,rank );
						studentDao.addStudent(student);
					}
				}
				catch(NumberFormatException e) {
					continue;
				}
			}
			line = "";
			StringTokenizer collegeDetails = null;
			br = new BufferedReader(new FileReader(collegeFile));
			while((line = br.readLine()) != null) {
				collegeDetails = new StringTokenizer(line, ",");
				try {
					String clgName = collegeDetails.nextToken();
					String clgId = collegeDetails.nextToken();
					int totalIntake = Integer.parseInt(collegeDetails.nextToken());
					if(clgName.matches("^[ a-zA-Z]*$") && clgId.matches("^[a-zA-Z]*$") && totalIntake == (int)totalIntake) {
						College college = new College(clgName, clgId, totalIntake);
						while(collegeDetails.hasMoreTokens())
						{
							String branchId = collegeDetails.nextToken();
							int threshold = Integer.parseInt(collegeDetails.nextToken());
							int intake =  Integer.parseInt(collegeDetails.nextToken());
							if(branchId.matches("^[ a-zA-Z]*$") && threshold == (int)threshold && intake == (int)intake) {
								Branch branch = new Branch(branchId, threshold, intake);
								college.addBranch(branch);
							}
						}  
						collegeDao.addCollege(college);
					}
				}
				catch(NumberFormatException e) {
					continue;
				}
			}
		}
		catch (IOException e)
		{  
			e.printStackTrace();
		} 
	}

	
}
