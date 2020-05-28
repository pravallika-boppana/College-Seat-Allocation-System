package com.counselling.dao;

import com.counselling.globalStore.TrieObject;
import com.counselling.user.RequestedAllotment;

public class RequestedAllotmentDao {
	static RequestedAllotmentDao requestedAllotmentDao = null;
	
	private RequestedAllotmentDao() {
	
	}
	
	public static RequestedAllotmentDao getInstance() {
		if (requestedAllotmentDao == null) {
			requestedAllotmentDao = new RequestedAllotmentDao(); }
		return requestedAllotmentDao;
	}
	
	
	
	public RequestedAllotment getRequestedAllotment(long stuId) {
		return TrieDao.getObject(stuId).getRequestedAllotment(); }
	
	public void addRequestedAllotment(RequestedAllotment requestedAllotment) {		
		TrieObject trieObject = TrieDao.getObject(requestedAllotment.getStuId());
		trieObject.setRequestedAllotment(requestedAllotment);
		TrieDao.insertObject(requestedAllotment.getStuId(), trieObject);  }
	
	
	public void updateAllotedPreference(RequestedAllotment requestedAllotment, int i) {
		requestedAllotment.setAllotedPreference(i);
		TrieObject trieObject = TrieDao.getObject(requestedAllotment.getStuId());
		requestedAllotment.setAllotedPreference(i);
		trieObject.setRequestedAllotment(requestedAllotment);
		TrieDao.insertObject(requestedAllotment.getStuId(), trieObject);   }

	
	

	
	
	

}
