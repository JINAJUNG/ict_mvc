package com.ict.erp.vo;

public class PageInfo {
	private int sNum;
	private int lNum;
	private int page = 1;
	private int pageSize;
	private int blockSize;
	private int totalBlock;
	private int totalPage;
	private int totalCnt;
	private int sBlock;
	private int lBlock;

	public int getTotalBlock() {
		return totalBlock;
	}

	public void setTotalBlock(int totalBlock) {
		this.totalBlock = totalBlock;
	}

	public int getsNum() {
		return sNum;
	}

	public void setsNum(int sNum) {
		this.sNum = sNum;
	}

	public int getlNum() {
		return lNum;
	}

	public void setlNum(int lNum) {
		this.lNum = lNum;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		if(page<=0) {
			return;
		}//만약 uri에 page값이 0보다 작거나 같을 경우 page값을 default로 셋팅해놓은 1을 가질 수 있게 대입하지 않고 리턴 
		this.page = page;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getBlockSize() {
		return blockSize;
	}

	public void setBlockSize(int blockSize) {
		this.blockSize = blockSize;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public int getTotalCnt() {
		return totalCnt;
	}

	public void setTotalCnt(int totalCnt) {
		this.totalCnt = totalCnt;
	}

	public int getsBlock() {
		return sBlock;
	}

	public void setsBlock(int sBlock) {
		this.sBlock = sBlock;
	}

	public int getlBlock() {
		return lBlock;
	}

	public void setlBlock(int lBlock) {
		this.lBlock = lBlock;
	}

	@Override
	public String toString() {
		return "PageInfo [sNum=" + sNum + ", lNum=" + lNum + ", page=" + page + ", pageSize=" + pageSize
				+ ", blockSize=" + blockSize + ", totalBlock=" + totalBlock + ", totalPage=" + totalPage + ", totalCnt="
				+ totalCnt + ", sBlock=" + sBlock + ", lBlock=" + lBlock + "]";
	}

	public void initPage(int totalCnt) {
		initPage(totalCnt, 10);
	}

	public void initPage(int totalCnt, int pageSize) {
		initPage(totalCnt, pageSize, 10);
	}

	public void initPage(int totalCnt, int pageSize, int blockSize) {
		this.totalCnt = totalCnt;
		if (pageSize != 0) {
			this.pageSize = pageSize;
		}
		if (blockSize != 0) {
			this.blockSize = blockSize;
		}

		this.totalPage = (int) Math.ceil((double) this.totalCnt / this.pageSize);
		this.totalBlock = (int) Math.ceil((double) this.totalPage / this.blockSize);



		
		this.sBlock = ((this.page - 1) / this.blockSize) * this.blockSize + 1;
		this.lBlock = this.sBlock + this.blockSize - 1;
		if (this.lBlock > this.totalPage) {
			this.lBlock = this.totalPage;		
			/*this.sBlock =lBlock-blockSize;*/
			/*
			 * 만약 uri에 page값이 over될 경우 page값을 마지막 블럭 값으로 준 후 
			 * startBlock는 마지막 블럭 값- 블럭사이즈를 해서 구한다.
			 */
		}
		
		//아래는 화면에 출력할 데이터 시작,마지막 계산
		if(this.page>this.totalPage) {
			this.page=lBlock;
		}
		this.sNum = (this.page - 1) * this.pageSize + 1;
		this.lNum = this.page * this.pageSize;
		System.out.println(this);
	}
}
