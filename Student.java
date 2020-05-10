package com.user;

import com.dao.StudentDao;

public class Student {
	private String stuName;
	private long stuId;
	private long rank;
	private String allotedClgId;
	public Student(String stuName, long stuId, long rank) {
		super();
		this.stuName = stuName;
		this.stuId = stuId;
		this.rank = rank;
	}
	public String getStuName() {
		return stuName;
	}
	public void setStuName(String stuName) {
		this.stuName = stuName;
	}
	public long getStuId() {
		return stuId;
	}
	public void setStuId(long stuId) {
		this.stuId = stuId;
	}
	public long getRank() {
		return rank;
	}
	public void setAllotedClgId(String allotedClgId) {
		this.allotedClgId = allotedClgId;
	}
	public Student(String allotedClgId) {
		super();
		this.allotedClgId = allotedClgId;
	}
	public void setRank(long rank) {
		this.rank = rank;
	}
	public String getAllotedCollege(Long stdId) {
		StudentDao student = new StudentDao();
		return student.getClg(stdId);
	}
	@Override
	public String toString() {
		return "Student [stuName=" + stuName + ", stuId=" + stuId + ", rank=" + rank + "]";
	}
	public Student() {
		super();
	}
	
	
}
