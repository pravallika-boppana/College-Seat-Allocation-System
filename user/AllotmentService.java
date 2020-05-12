package com.user;

import com.dao.CollegeDao;
import com.dao.StudentDao;

class AllotmentService {
    public void allotClg(RequestedAllotment requestedAllotment){
        StudentDao studentDao = new StudentDao();
        CollegeDao collegeDao = new CollegeDao();
        System.out.println("Entered AllotClg");
        Student student = studentDao.getStudent(requestedAllotment.getStuId());
        System.out.println("got student rank " + student.getStuId() + " " + student.getRank());
        for(int i = requestedAllotment.getAllotedPreference() + 1; i < 3; i++) {
            if(student!=null){
                if(isEligible(student.getRank(), requestedAllotment.preferences[i])) {
                	System.out.println("Eligible");
                    if(isSeatAvailable(requestedAllotment.preferences[i])){
                        allocateSeat(requestedAllotment, i);
                        break;
                    }
                    else if(isReplacable(student.getRank(), requestedAllotment.preferences[i])) {
                        allocateSeat(requestedAllotment, i);
                        collegeDao.decrementFilled(requestedAllotment.preferences[i]);
                        Student replacedStudent = getReplacedStudent(requestedAllotment.preferences[i]);
                        RequestedAllotment replacedReq = studentDao.getRequestedAllotment(replacedStudent.getStuId()); 
                        allotClg(replacedReq);
                        break;
                    }
                }
            }
        }
        
    }
    static boolean isEligible(long rank, Preference preference) {
    	System.out.println("Entered is eligible");
        CollegeDao collegeDao = new CollegeDao();
        Branch branch = collegeDao.getBranch(preference.getClgId(), preference.getBranchId());
        System.out.println("branch null " + branch == null);
        System.out.println("rank " + rank + " branch " + branch.getBranchId() + " threshold "  + branch.getThreshold());
        if(rank <= branch.getThreshold()) {
        	System.out.println("yes eligible");
            return true; }
        System.out.println("no eligible");
        return false;
    }
    static boolean isSeatAvailable(Preference preference) {
        CollegeDao collegeDao = new CollegeDao();
        College college = collegeDao.getCollege(preference.getClgId());
        Branch branch = collegeDao.getBranch(preference.getClgId(), preference.getBranchId());
        if(branch.getFilled() < branch.getIntake())
            return true;
        return false;
    }
    static boolean isReplacable(long rank, Preference preference){
        CollegeDao collegeDao = new CollegeDao();
        College college = collegeDao.getCollege(preference.getClgId());
        Branch branch = collegeDao.getBranch(preference.getClgId(), preference.getBranchId());
        Student student = branch.allotedRanks.peek();
        if(rank < student.getRank())
            return true;
        return false;
    }
    static Student getReplacedStudent(Preference preference){
        CollegeDao collegeDao = new CollegeDao();
        College college = collegeDao.getCollege(preference.getClgId());
        Branch branch = collegeDao.getBranch(preference.getClgId(), preference.getBranchId());
        return branch.allotedRanks.poll();
    }
    static void allocateSeat(RequestedAllotment requestedAllotment, int i){
    	StudentDao studentDao = new StudentDao();
    	studentDao.updateAllotedPreference(requestedAllotment, i);
        requestedAllotment.setAllotedPreference(i);
        CollegeDao collegeDao = new CollegeDao();
        collegeDao.incrementFilled(requestedAllotment.preferences[i]);
        System.out.println("Seat Allocated Successfully");

   
    }
}
