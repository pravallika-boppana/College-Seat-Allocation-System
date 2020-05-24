package com.counselling.testing;

import static org.junit.Assert.*;

import org.junit.Test;

import com.counselling.dao.TrieDao;
import com.counselling.globalStore.TrieObject;
import com.counselling.user.Student;

public class TrieTest {

	

	@Test
	public void testConvertToString() {
		assertTrue(TrieDao.convertToString((long)101).equals("0000000101"));
		assertFalse(TrieDao.convertToString((long)111).equals("1000000101")); }

	@Test
	public void testInsertAndGetObjectt() {
		Student student1 = new Student("Bhavya", 111, 208);
		Student student2 = new Student("Pravallika", 112, 218);
		TrieDao.insertObject(student1.getStuId(), new TrieObject(student1));
		assertSame(student1, TrieDao.getObject(student1.getStuId()).getStudent());
		assertNotSame(student2, TrieDao.getObject(student1.getStuId()).getStudent()); }
		

	
}
