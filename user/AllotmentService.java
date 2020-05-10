package com.user;

import com.dao.CollegeDao;
import com.dao.StudentDao;

class AllotmentService {
    public void allotClg(RequestedAllotment requestedAllotment){
        StudentDao studentDao = new StudentDao();
        CollegeDao collegeDao = new CollegeDao();
        Student student = studentDao.getStudent(requestedAllotment.getStuId());
        for(int i = requestedAllotment.getAllotedPreference() + 1; i < 3; i++) {
            if(student!=null){
                if(isEligible(student.getRank(), requestedAllotment.preferences[i])) {
                    if(isSeatAvailable(requestedAllotment.preferences[i])){
                        allocateSeat(requestedAllotment, i);
                    }
                    else if(isReplacable(student.getRank(), requestedAllotment.preferences[i])) {
                        allocateSeat(requestedAllotment, i);
                        collegeDao.decrementFilled();
                        Student replacedStudent = getReplacedStudent(requestedAllotment.preferences[i]);
                        RequestedAllotment replacedReq = studentDao.getRequestedAllotment(replacedStudent.getStuId()); 
                        allotClg(replacedReq);
                    }
                }
            }
        }
        
    }
    static boolean isEligible(long rank, Preference pre) {
        CollegeDao collegDao = new CollegeDao();
        College college = collegDao.getCollege(pre);
        Branch branch = college.getBranch(pre);
        if(rank <= branch.getThreshold())
            return true;
        return false;
    }
    static boolean isSeatAvailable(Preference pre) {
        CollegeDao collegDao = new CollegeDao();
        College college = collegDao.getCollege(pre);
        Branch branch = college.getBranch(pre);
        if(branch.getFilled() < branch.getIntake())
            return true;
        return false;
    }
    static boolean isReplacable(long rank, Preference pre){
        CollegeDao collegDao = new CollegeDao();
        College college = collegDao.getCollege(pre);
        Branch branch = college.getBranch(pre);
        Student student = branch.allotedRanks.peek();
        if(rank < student.getRank())
            return true;
        return false;
    }
    static Student getReplacedStudent(Preference pre){
        CollegeDao collegDao = new CollegeDao();
        College college = collegDao.getCollege(pre);
        Branch branch = college.getBranch(pre);
        return branch.allotedRanks.poll();
    }
    static void allocateSeat(RequestedAllotment requestedAllotment, int i){
    	StudentDao studentDao = new StudentDao();
    	studentDao.updateAllotedPreference(i);
        requestedAllotment.setAllotedPreference(i);
        CollegeDao collegeDao = new CollegeDao();
        collegeDao.incrementFilled(requestedAllotment.preferences[i]);
   
    }
}