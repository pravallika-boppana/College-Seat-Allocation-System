class AllotmentService {
    void allotclg(RequestedAllotment requestedAllotment){
        StudentDao studentDao = new StudentDao();
        Student student = studentDao.getStudent(requestedAllotment.id);
        for(int i = requestedAllotment.allotedPreference + 1; i < 3; i++) {
            if(student!=null){
                if(isEligible(student.rank, requestedAllotment.pre[i])) {
                    if(isSeatAvailable(requestedAllotment.pre[i])){
                        allocateSeat(requestedAllotment, i);
                    }
                    else if(isReplacable(student.rank, pre[i])) {
                        allocateSeat(requestedAllotment, i);
                        collegeDao.decrementClgFilled();
                        collegeDao.decrementBranchFilled();
                        Student student = getReplacedStudent(pre);
                        RequestedAllotment replacedReq = studentDao.getRequestedAllotment(student.id); 
                        allotclg(replacedReq);
                    }
                }
            }
        }
        
    }
    static boolean isEligible(long rank, Preference pre) {
        CollegeDao collegDao = new CollegeDao();
        College college = collegDao.clgDetails.get(pre.clgId);
        Branch branch = college.branches.get(pre.branchId);
        if(rank <= branch.threshold)
            return true;
        return false;
    }
    static boolean isSeatAvailable(Preference pre) {
        CollegeDao collegDao = new CollegeDao();
        College college = collegDao.clgDetails.get(pre.clgId);
        Branch branch = college.branches.get(pre.branchId);
        if(br.filled < branch.intake)
            return true;
        return false;
    }
    static boolean isReplacable(long rank, Preference pre){
        CollegeDao collegDao = new CollegeDao();
        College college = collegDao.clgDetails.get(pre.clgId);
        Branch branch = college.branches.get(pre.branchId);
        Student student = branch.allotedRanks.peek();
        if(rank < student.rank)
            return true;
        return false;
    }
    static Student getReplacedStudent(Preference pre){
        CollegeDao collegDao = new CollegeDao();
        College college = collegDao.clgDetails.get(pre.clgId);
        Branch branch = college.branches.get(pre.branchId);
        return branch.allotedRanks.poll();
    }
    static void allocateSeat(RequestedAllotment requestedAllotment, int i){
        requestedAllotment.setAllotedPreference(i);
        CollegeDao collegDao = new CollegeDao();
        College college = collegDao.clgDetails.get(pre.clgId);
        Branch branch = college.branches.get(pre.branchId);
        collegeDao.UpdateClgFilled();
        collegeDao.UpdateBranchFilled();
    }
}
