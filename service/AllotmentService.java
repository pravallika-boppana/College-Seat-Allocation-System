package com.counselling.service;

import com.counselling.dao.CollegeDao;
import com.counselling.dao.StudentDao;
import com.counselling.user.Branch;
import com.counselling.user.College;
import com.counselling.user.Preference;
import com.counselling.user.RequestedAllotment;
import com.counselling.user.Student;

public class AllotmentService {
    public void allotClg(RequestedAllotment requestedAllotment){
        StudentDao studentDao = new StudentDao();
        CollegeDao collegeDao = new CollegeDao();
//        System.out.println("Entered AllotClg");
        Student student = studentDao.getStudent(requestedAllotment.getStuId());
//        System.out.println("got student rank " + student.getStuId() + " " + student.getRank());
        for(int i = requestedAllotment.getAllotedPreference() + 1; i < 3; i++) {
            if(student!=null){
                if(isEligible(student.getRank(), requestedAllotment.getPreferences()[i])) {
//                	System.out.println("Eligible");
                    if(isSeatAvailable(requestedAllotment.getPreferences()[i])){
                        allocateSeat(requestedAllotment, i);
                        break;
                    }
                    else if(isReplacable(student.getRank(), requestedAllotment.getPreferences()[i])) {
                        allocateSeat(requestedAllotment, i);
                        collegeDao.decrementFilled(requestedAllotment.getPreferences()[i]);
                        Student replacedStudent = getReplacedStudent(requestedAllotment.getPreferences()[i]);
                        RequestedAllotment replacedReq = studentDao.getRequestedAllotment(replacedStudent.getStuId()); 
                        allotClg(replacedReq);
                        break;
                    }
                }
            }
        }
        
    }
    static boolean isEligible(long rank, Preference preference) {
        CollegeDao collegeDao = new CollegeDao();
        Branch branch = collegeDao.getBranchInCollege(preference.getClgId(), preference.getBranchId());
//        System.out.println("branch null " + branch == null);
//        System.out.println("rank " + rank + " branch " + branch.getBranchId() + " threshold "  + branch.getThreshold());
        if(rank <= branch.getThreshold()) {
//        	System.out.println("yes eligible");
            return true; }
//        System.out.println("no eligible");
        return false;
    }
    static boolean isSeatAvailable(Preference preference) {
        CollegeDao collegeDao = new CollegeDao();
        College college = collegeDao.getCollege(preference.getClgId());
        Branch branch = collegeDao.getBranchInCollege(preference.getClgId(), preference.getBranchId());
        if(branch.getFilled() < branch.getIntake())
            return true;
        return false;
    }
    static boolean isReplacable(long rank, Preference preference){
        CollegeDao collegeDao = new CollegeDao();
        College college = collegeDao.getCollege(preference.getClgId());
        Branch branch = collegeDao.getBranchInCollege(preference.getClgId(), preference.getBranchId());
        Student student = branch.getAllotedRanks().peek();
        if(rank < student.getRank())
            return true;
        return false;
    }
    static Student getReplacedStudent(Preference preference){
        CollegeDao collegeDao = new CollegeDao();
        College college = collegeDao.getCollege(preference.getClgId());
        Branch branch = collegeDao.getBranchInCollege(preference.getClgId(), preference.getBranchId());
        return branch.getAllotedRanks().poll();
    }
    static void allocateSeat(RequestedAllotment requestedAllotment, int i){
    	StudentDao studentDao = new StudentDao();
    	studentDao.updateAllotedPreference(requestedAllotment, i);
        requestedAllotment.setAllotedPreference(i);
        CollegeDao collegeDao = new CollegeDao();
        collegeDao.incrementFilled(requestedAllotment.getPreferences()[i]);
        System.out.println("Seat Allocated Successfully");

   
    }
}