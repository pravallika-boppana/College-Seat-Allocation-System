package com.counselling.comparators;

import java.util.Comparator;

import com.counselling.user.Student;

public class RankMaxComparator implements Comparator<Student> {

	@Override
	public int compare(Student s1, Student s2) {
		if(s1.getRank() < s2.getRank()){
            return 1;
        }
        if(s1.getRank() > s2.getRank()){
            return -1;
        }
        return 0;
	}

}
