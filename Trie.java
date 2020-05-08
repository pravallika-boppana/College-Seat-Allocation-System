class Trie  {
    Trie child[] = new Trie[10];
    boolean isLeaf;
    Student student;
    RequestedAllotment requestedAllotment;
    Trie() {
        student = null;
        requestedAllotment = null;
        isLeaf = false;
        for(int i = 0; i < 10; i++) {
            child[i] = null;} } 
	 
    
    static String convertToString(Long id) {
        String idS = id.toString(id);
        String temp = "";
        for(int i = 1; i <= 10 -idS.length(); i++) {
            temp += "0"; }
        return temp + idS; }
    
    static void insertStudent(Trie root, Long id, Student student) {
        String idS = convertToString(id);
        for(int i = 0; i < 10; i++) {
            if (root.child[idS.charAt(i) - 48] == null) {
                root.child[idS.charAt(i) - 48] = new Trie(); }
            root = root.child[idS.charAt(i) - 48]; }
        root.isLeaf = true;
        root.student = student; }
    
    static void insertRequestedAllotment(Trie root, Long id, RequestedAllotment requestedAllotment) {
        String idS = convertToString(id);
        for(int i = 0; i < 10; i++) {
            if (root.child[idS.charAt(i) - 48] == null) {
                root.child[idS.charAt(i) - 48] = new Trie(); }
            root = root.child[idS.charAt(i) - 48]; }
        root.isLeaf = true;
        root.requestedAllotment = requestedAllotment; }
    
    static Student getStudent(Trie root, Long id) {
        String idS = convertToString(id);
        for(int i = 0; i < 10; i++) {
            if (root.child[idS.charAt(i) - 48] == null) {
                return null; }
            root = root.child[idS.charAt(i) - 48]; }
            return root.student; }
    
    static RequestedAllotment getRequestedAllotment(Trie root, Long id) {
        String idS = convertToString(id);
        for(int i = 0; i < 10; i++) {
            if (root.child[idS.charAt(i) - 48] == null) {
                return null; }
            root = root.child[idS.charAt(i) - 48]; }
            return root.requestedAllotment; }
    
    static boolean isStudentPresent(Trie root, Long id) {
        String idS = convertToString(id);
        for(int i = 0; i < 10; i++) {
            if (root.child[idS.charAt(i) - 48] == null) {
                return false; }
            root = root.child[idS.charAt(i) - 48]; }
        return true; }
    
    static boolean isRequestedAllotmentPresent(Trie root, Long id) {
        String idS = convertToString(id);
        for(int i = 0; i < 10; i++) {
            if (root.child[idS.charAt(i) - 48] == null) {
                return false; }
            root = root.child[idS.charAt(i) - 48]; }
        return root.requestedAllotment != null; }
    
    }
