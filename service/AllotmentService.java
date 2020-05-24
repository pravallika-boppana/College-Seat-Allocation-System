package com.counselling.service;

import com.counselling.dao.CollegeDao;
import com.counselling.dao.RequestedAllotmentDao;
import com.counselling.dao.StudentDao;
import com.counselling.user.Branch;
import com.counselling.user.Preference;
import com.counselling.user.RequestedAllotment;
import com.counselling.user.Student;

public class AllotmentService {
    static CollegeDao collegeDao = CollegeDao.getInstance();
    static StudentDao studentDao = StudentDao.getInstance();
    public void allotClg(RequestedAllotment requestedAllotment){
        StudentDao studentDao = StudentDao.getInstance();
        RequestedAllotmentDao requestedAllotmentDao = new RequestedAllotmentDao();
        Student student = studentDao.getStudent(requestedAllotment.getStuId());
        for(int i = requestedAllotment.getAllotedPreference() + 1; i < 3; i++) {
            if(student!=null){
                if(isEligible(student.getRank(), requestedAllotment.getPreferences()[i])) {
                    if(isSeatAvailable(requestedAllotment.getPreferences()[i])){
                        allocateSeat(requestedAllotment, i);
                        break;
                    }
                    else if(isReplacable(student.getRank(), requestedAllotment.getPreferences()[i])) {
                        allocateSeat(requestedAllotment, i);
                        collegeDao.updateFilled(requestedAllotment.getPreferences()[i], -1);
                        Student replacedStudent = getReplacedStudent(requestedAllotment.getPreferences()[i]);
                        RequestedAllotment replacedReq = requestedAllotmentDao.getRequestedAllotment(replacedStudent.getStuId()); 
                        allotClg(replacedReq);
                        break;
                    }
                }
            }
        }
        
    }
    static boolean isEligible(long rank, Preference preference) {
        Branch branch = collegeDao.getBranchInCollege(preference.getClgId(), preference.getBranchId());
        if(rank <= branch.getThreshold()) {
            return true; }
        return false;
    }
    static boolean isSeatAvailable(Preference preference) {
        Branch branch = collegeDao.getBranchInCollege(preference.getClgId(), preference.getBranchId());
        if(branch.getFilled() < branch.getIntake())
            return true;
        return false;
    }
    static boolean isReplacable(long rank, Preference preference){
        Branch branch = collegeDao.getBranchInCollege(preference.getClgId(), preference.getBranchId());
        Student student = branch.getAllotedRanks().peek();
        if(rank < student.getRank())
            return true;
        return false;
    }
    static Student getReplacedStudent(Preference preference){
        Branch branch = collegeDao.getBranchInCollege(preference.getClgId(), preference.getBranchId());
        return branch.getAllotedRanks().poll();
    }
    static void allocateSeat(RequestedAllotment requestedAllotment, int i){
    	RequestedAllotmentDao requestedAllotmentDao = new RequestedAllotmentDao();
    	requestedAllotmentDao.updateAllotedPreference(requestedAllotment, i);
        requestedAllotment.setAllotedPreference(i);
        collegeDao.updateFilled(requestedAllotment.getStuId(), requestedAllotment.getPreferences()[i], 1);
        
        System.out.println("Seat Allocated Successfully");

   
    }
}