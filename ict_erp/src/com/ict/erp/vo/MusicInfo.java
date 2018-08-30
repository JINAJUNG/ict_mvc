package com.ict.erp.vo;

public class MusicInfo {
	private int mcNum;
	private String mcName;
	private String mcSinger;
	private String mcVendor;
	private int mcLike;
	private int mcDisLike;
	private String mcCredate;
	private String mcDesc;

	public MusicInfo() {

	}

	public MusicInfo(int mcNum, String mcName, String mcSinger, String mcVendor, int mcLike, int mcDisLike,
			String mcCredate, String mcDesc) {
		this.mcNum = mcNum;
		this.mcName = mcName;
		this.mcSinger = mcSinger;
		this.mcVendor = mcVendor;
		this.mcLike = mcLike;
		this.mcDisLike = mcDisLike;
		this.mcCredate = mcCredate;
		this.mcDesc = mcDesc;
	}

	public int getMcNum() {
		return mcNum;
	}

	public void setMcNum(int mcNum) {
		this.mcNum = mcNum;
	}

	public String getMcName() {
		return mcName;
	}

	public void setMcName(String mcName) {
		this.mcName = mcName;
	}

	public String getMcSinger() {
		return mcSinger;
	}

	public void setMcSinger(String mcSinger) {
		this.mcSinger = mcSinger;
	}

	public String getMcVendor() {
		return mcVendor;
	}

	public void setMcVendor(String mcVendor) {
		this.mcVendor = mcVendor;
	}

	public int getMcLike() {
		return mcLike;
	}

	public void setMcLike(int mcLike) {
		this.mcLike = mcLike;
	}

	public int getMcDisLike() {
		return mcDisLike;
	}

	public void setMcDisLike(int mcDisLike) {
		this.mcDisLike = mcDisLike;
	}

	public String getMcCredate() {
		mcCredate = mcCredate.substring(0, 4)+"."+mcCredate.substring(4, 6)+"."+mcCredate.substring(6); 
		return mcCredate;
	}

	public void setMcCredate(String mcCredate) {
		this.mcCredate = mcCredate;
	}

	public String getMcDesc() {
		return mcDesc;
	}

	public void setMcDesc(String mcDesc) {
		this.mcDesc = mcDesc;
	}

	@Override
	public String toString() {
		return "MusicInfo [mcNum=" + mcNum + ", mcName=" + mcName + ", mcSinger=" + mcSinger + ", mcVendor=" + mcVendor
				+ ", mcLike=" + mcLike + ", mcDisLike=" + mcDisLike + ", mcCredate=" + mcCredate + ", mcDesc=" + mcDesc
				+ "]";
	}

}
