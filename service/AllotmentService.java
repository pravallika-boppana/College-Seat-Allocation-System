package com.counselling.service;

import com.counselling.dao.CollegeDao;
import com.counselling.dao.RequestedAllotmentDao;
import com.counselling.dao.StudentDao;
import com.counselling.user.Branch;
import com.counselling.user.College;
import com.counselling.user.Preference;
import com.counselling.user.RequestedAllotment;
import com.counselling.user.Student;

public class AllotmentService {
	
	static AllotmentService allotmentService = new AllotmentService();
	
	private AllotmentService() {
		
	}
	
	public static AllotmentService getInstance() {
		if (allotmentService == null) {
			allotmentService = new AllotmentService();
		}
		return allotmentService;
	}
	
    static CollegeDao collegeDao = CollegeDao.getInstance();
    static StudentDao studentDao = StudentDao.getInstance();
    static RequestedAllotmentDao requestedAllotmentDao = RequestedAllotmentDao.getInstance();
	
    public void allotClg(RequestedAllotment requestedAllotment){
        StudentDao studentDao = StudentDao.getInstance();
        Student student = studentDao.getStudent(requestedAllotment.getStuId());
        for(int i = requestedAllotment.getAllotedPreference() + 1; i < 3; i++) {
            if(student!=null){
                if(isEligible(student.getRank(), requestedAllotment.getPreferences()[i])) {
                    if(isSeatAvailable(requestedAllotment.getPreferences()[i])){
                        allocateSeat(requestedAllotment, i);
                        break;
                    }
                    else if(isReplacable(student.getRank(), requestedAllotment.getPreferences()[i])) {
                    	Student replacedStudent = getReplacedStudent(requestedAllotment.getPreferences()[i]);
                    	allocateSeat(requestedAllotment, i);
                        //collegeDao.updateFilled(requestedAllotment.getStuId() ,requestedAllotment.getPreferences()[i]);
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
        System.out.println("In is elible threshold : " + branch.getThreshold() + " rank : " + rank);
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
        System.out.println("ASking for replacement");
        System.out.println("Current rank : " + rank);
        System.out.println("replacable student rank : " + student.getRank());
        if(rank < student.getRank())
            return true;
        return false;
    }
    static Student getReplacedStudent(Preference preference){
    	College college = collegeDao.getCollege(preference.getClgId());
    	college.setFilled(college.getFilled() - 1);
    	Branch branch = college.getBranches().get(preference.getBranchId());
    	Student student = branch.getAllotedRanks().poll();
    	branch.setFilled(branch.getFilled() - 1);
    	college.getBranches().put(preference.getBranchId(), branch);
    	collegeDao.addCollege(college);
    	return student;
    }
    static void allocateSeat(RequestedAllotment requestedAllotment, int i){
    	requestedAllotmentDao.updateAllotedPreference(requestedAllotment, i);
        requestedAllotment.setAllotedPreference(i);
        //System.out.println("Before calling uodateflled");
        collegeDao.updateFilled(requestedAllotment.getStuId(), requestedAllotment.getPreferences()[i]);
        
        //System.out.println("Seat Allocated Successfully");

   
    }
}