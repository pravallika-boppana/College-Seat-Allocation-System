package com.counselling.comparators;

import java.util.Comparator;

import com.counselling.user.Student;

public class RankMaxComparator implements Comparator<Student> {

	@Override
	public int compare(Student student1, Student student2) {
		if (student1.getRank() > student2.getRank())
			return -1;
		if (student1.getRank() < student2.getRank())
		    return 1;
		return 0;
	}

}
