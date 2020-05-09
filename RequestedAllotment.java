package com.user;
import java.util.Arrays;

import com.user.Preference;

public class RequestedAllotment {
	private long stuId;
	private int allotedPreference;
	private int counsellingId;
	Preference preferences[] = new Preference[3];

	public long getStuId() {
		return stuId;
	}
	public void setStuId(long stuId) {
		this.stuId = stuId;
	}
	public int getAllotedPreference() {
		return allotedPreference;
	}
	public void setAllotedPreference(int allotedPreference) {
		this.allotedPreference = allotedPreference;
	}
	public int getCounsellingId() {
		return counsellingId;
	}
	
	public void setCounsellingId(int counsellingId) {
		this.counsellingId = counsellingId;
	}
	@Override
	public String toString() {
		return "RequestedAllotment [stuId=" + stuId + ", preferences=" + Arrays.toString(preferences) + "]";
	}
	
}
