package com.counselling.globalStore;

public class Trie  {
    private Trie child[] = new Trie[10];
    private boolean isLeaf;
    private TrieObject trieObject;
    
    public Trie() {
        for(int i = 0; i < 10; i++) {
            getChild()[i] = null;} }
	
    public boolean isLeaf() {
		return isLeaf;
	}
	
    public void setLeaf(boolean isLeaf) {
		this.isLeaf = isLeaf;
	}
	
    public TrieObject getTrieObject() {
		return trieObject;
	}
	
    public void setTrieObject(TrieObject trieObject) {
		this.trieObject = trieObject;
	}
	
    public Trie[] getChild() {
		return child;
	}
	public void setChild(Trie child[]) {
		this.child = child;
	} 
	 
 		
}
