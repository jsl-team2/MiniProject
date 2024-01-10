package utility;

public class Criteria {

	private int pageNum; // 페이지번호
	private int amount; // 1페이지에 출력레코드 개수
	
	private String type; // 글, 제목
	private String keyword; // 검색내용
	
	public Criteria() {
		this(1, 10); // 현재 자기자신의 다른생성자 호출
	}
	
	
	public Criteria(int pageNum, int amount) {
		this.pageNum = pageNum;
		this.amount = amount;
	}

	public int getPageNum() {
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	
}
