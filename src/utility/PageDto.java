package utility;

public class PageDto {
	
	private int startPage; //시작페이지
	private int endPage; //끝페이지 
	private boolean prev, next; //이전,다음페이지
	private int total; //총레코드 개수 
	private Criteria cri;//멤버변수로 다른 클래스지정
	
	
	
	public PageDto(Criteria cri, int total) {
		
		this.cri = cri;
		this.total = total;
		this.endPage = (int)(Math.ceil(cri.getPageNum() / 10.0)) * 10;
		this.startPage = this.endPage -9;
		int realEnd = (int)(Math.ceil((total * 1.0)/cri.getAmount())); 
		if(realEnd < this.endPage) this.endPage = realEnd;
		this.prev = this.startPage > 1;
		this.next = this.endPage < realEnd;
		
	}

	public int getStartPage() {
		return startPage;
	}

	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}

	public int getEndPage() {
		return endPage;
	}

	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}

	public boolean isPrev() {
		return prev;
	}

	public void setPrev(boolean prev) {
		this.prev = prev;
	}

	public boolean isNext() {
		return next;
	}

	public void setNext(boolean next) {
		this.next = next;
	}


	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public Criteria getCri() {
		return cri;
	}

	public void setCri(Criteria cri) {
		this.cri = cri;
	}
	
	
}
