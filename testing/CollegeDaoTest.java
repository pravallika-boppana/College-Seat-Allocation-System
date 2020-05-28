package com.counselling.testing;

import static org.junit.Assert.*;

import java.util.HashMap;

import org.junit.Test;
import com.counselling.dao.CollegeDao;
import com.counselling.user.Branch;
import com.counselling.user.College;

public class CollegeDaoTest {
	
	static CollegeDao collegeDao = CollegeDao.getInstance();
	@Test
	public final void testAddandGetCollege() {
		College college1 = new College("VIT", "Vishnu Institute of Technology", 720);
		College college2 = new College("VISW", "Shri Vishnu Engineering College for Women", 720);
		Branch branch1 = new Branch("IT", 120, 12000);
		Branch branch2 = new Branch("ECE", 180, 8000);
		HashMap<String, Branch> branches = new HashMap<>();
		branches.put(branch1.getBranchId(), branch1);
		branches.put(branch2.getBranchId(), branch2);
		college1.setBranches(branches);
		
		collegeDao.addCollege(college1);
		collegeDao.addCollege(college2);
		System.out.println(college1);
		System.out.println(collegeDao.getCollege(college1.getClgId()));
		
		assertTrue(college1 == (collegeDao.getCollege(college1.getClgId())));
		assertFalse(college2.equals(collegeDao.getCollege(college1.getClgId())));
	}


	@Test
	public final void testUpdateFilledPreferenceInt() {
		
		fail("Not yet implemented"); // TODO
	}

	@Test
	public final void testUpdatePrefenceCount() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public final void testGetBranchInCollege() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public final void testUpdateFilledLongPreferenceInt() {
		fail("Not yet implemented"); // TODO
	}

}
