package com.user;

public class Student {
	private String studentName;
	private int studentId;
	private int studentRank;
	public Student(String studentName, int studentId, int studentRank) {
		super();
		this.studentName = studentName;
		this.studentId = studentId;
		this.studentRank = studentRank;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public int getStudentId() {
		return studentId;
	}
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	public int getStudentRank() {
		return studentRank;
	}
	public void setStudentRank(int studentRank) {
		this.studentRank = studentRank;
	}
	@Override
	public String toString() {
		return "Student [studentName=" + studentName + ", studentId=" + studentId + ", studentRank=" + studentRank
				+ "]";
	}
	
}
