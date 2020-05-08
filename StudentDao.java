package com.dao;
import java.util.ArrayList;
import com.user.Student;

public class StudentDao {
    ArrayList<Student> students = new ArrayList<Student>();
    public void addStudent(Student student) {
    	students.add(student);
    }
    public void getAllStudents() {
    	for(int i = 0; i < students.size();i++) {
    		//System.out.println(students.get(i).getStdName() + " " +students.get(i).getStdId() + " " + students.get(i).getRank() );
    	     System.out.println(students.get(i).toString());
    	}
    }
}
