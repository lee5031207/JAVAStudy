package com.kh.toy.common.util.paging;

public class Paging {
	
	//입력받을 값
	private String type; //페이징 처리할 항목
	private int currentPage; //현재 페이지
	private int total; //전체 페이지 수
	private int cntPerPage; //페이지당 게시물 수
	private int blockCnt; //하단에 표시될 페이지 블록 개수
	private String sort; //정렬 기준 컬럼
	private String direction; //정렬 방향
	
	//계산할 값
	private int blockStart; //시작 블록
	private int blockEnd; //마지막 블록
	private int lastPage; //마지막 페이지
	private int prev; //이전 버튼
	private int next; //이후 버튼
	
	//쿼리 between문에서 사용할 rownum범위
	private int queryStart; 
	private int queryEnd;
	
	
	private Paging(PagingBuilder builder) {
		super();
		this.type = builder.type;
		this.currentPage = builder.currentPage;
		this.total = builder.total;
		this.cntPerPage = builder.cntPerPage;
		this.blockCnt = builder.blockCnt;
		this.sort = builder.sort;
		this.direction = builder.direction;
		
		calBlockStartAndEnd();
		calQueryStartAndEnd();
		calPrevAndNext();
	}
	
	public static PagingBuilder builder() {
		return new PagingBuilder();
	}
	
	private void calLastPage() {
		lastPage = (total-1) / cntPerPage + 1;
	}
	
	private void calBlockStartAndEnd() {
		calLastPage();
		//currentPage보다 같거나 큰 blockCnt의 배수 중에서 가장 작은수
		blockStart = ((currentPage-1)/blockCnt) * blockCnt + 1;
		blockEnd = blockStart + blockCnt - 1;
		blockEnd = blockEnd > lastPage? lastPage : blockEnd;
	}
	
	private void calQueryStartAndEnd() {
		queryEnd = currentPage * cntPerPage;
		queryStart = queryEnd - cntPerPage + 1; 
	}
	
	private void calPrevAndNext() {
		prev = currentPage == 1 ? 1 : currentPage-1;
		next = currentPage == lastPage ? lastPage : lastPage+1;
	}
	
	public static class PagingBuilder{
		//입력받을 값
		private String type; //페이징 처리할 항목
		private int currentPage; //현재 페이지
		private int total; //전체 페이지 수
		private int cntPerPage; //페이지당 게시물 수
		private int blockCnt; //하단에 표시될 페이지 블록 개수
		private String sort;
		private String direction;
		
		public PagingBuilder type(String val) {
			this.type = val;
			return this;
		}
		public PagingBuilder currentPage(int val) {
			this.currentPage = val;
			return this;
		}
		public PagingBuilder total(int val) {
			this.total = val;
			return this;
		}
		public PagingBuilder cntPerPage(int val) {
			this.cntPerPage = val;
			return this;
		}
		public PagingBuilder blockCnt(int val) {
			this.blockCnt = val;
			return this;
		}
		public PagingBuilder sort(String val) {
			this.sort = val;
			return this;
		}
		public PagingBuilder direction(String val) {
			this.direction = val;
			return this;
		}
		
		
		
		public Paging build() {
			return new Paging(this);
		}
		
	}
	
	public void setType(String type) {
		this.type = type;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public void setCntPerPage(int cntPerPage) {
		this.cntPerPage = cntPerPage;
	}

	public void setBlockCnt(int blockCnt) {
		this.blockCnt = blockCnt;
	}

	public String getType() {
		return type;
	}


	public int getCurrentPage() {
		return currentPage;
	}


	public int getTotal() {
		return total;
	}


	public int getCntPerPage() {
		return cntPerPage;
	}


	public int getBlockCnt() {
		return blockCnt;
	}


	public int getBlockStart() {
		return blockStart;
	}


	public int getBlockEnd() {
		return blockEnd;
	}


	public int getLastPage() {
		return lastPage;
	}


	public int getPrev() {
		return prev;
	}


	public int getNext() {
		return next;
	}


	public int getQueryStart() {
		return queryStart;
	}


	public int getQueryEnd() {
		return queryEnd;
	}
	

	public String getSort() {
		return sort;
	}

	public void setSort(String sort) {
		this.sort = sort;
	}

	public String getDirection() {
		return direction;
	}

	public void setDirection(String direction) {
		this.direction = direction;
	}

	@Override
	public String toString() {
		return "Paging [type=" + type + ", currentPage=" + currentPage + ", total=" + total + ", cntPerPage="
				+ cntPerPage + ", blockCnt=" + blockCnt + ", sort=" + sort + ", direction=" + direction
				+ ", blockStart=" + blockStart + ", blockEnd=" + blockEnd + ", lastPage=" + lastPage + ", prev=" + prev
				+ ", next=" + next + ", queryStart=" + queryStart + ", queryEnd=" + queryEnd + "]";
	}

	
	
}
