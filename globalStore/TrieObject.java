package com.counselling.globalStore;

import com.counselling.user.RequestedAllotment;
import com.counselling.user.Student;

public class TrieObject {
	Student student;
	RequestedAllotment requestedAllotment;
	TrieObject(Student student, RequestedAllotment requestedAllotment) {
		this.student = student;
		this.requestedAllotment = requestedAllotment;
	}
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
	public RequestedAllotment getRequestedAllotment() {
		return requestedAllotment;
	}
	public void setRequestedAllotment(RequestedAllotment requestedAllotment) {
		this.requestedAllotment = requestedAllotment;
	}

}
