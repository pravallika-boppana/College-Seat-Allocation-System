package com.counselling.service;

import com.counselling.dao.CollegeDao;
import com.counselling.user.RequestedAllotment;

public class CounsellingThread extends Thread {
    private RequestedAllotment requestedAllotment;
    private AllotmentService allotmentService;
    private CollegeDao collegeDao;
    public CounsellingThread(RequestedAllotment requestedAllotment, AllotmentService allotmentService, CollegeDao collegeDao) {
        this.requestedAllotment = requestedAllotment;
        this.allotmentService = allotmentService;
        this.collegeDao = collegeDao;
    }
    public void run() {
        collegeDao.updatePrefenceCount(requestedAllotment);
        allotmentService.allotClg(requestedAllotment); 
    }
}