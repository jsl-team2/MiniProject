package dao.board;

public class CommentVo {

	private String comment_id;
	private int comment_no;
	private int board_no;
	private String comment_content;
	private String comment_createdate;
	private int comment_secret;
	
	public String getComment_id() {
		return comment_id;
	}
	public void setComment_id(String comment_id) {
		this.comment_id = comment_id;
	}
	public int getComment_no() {
		return comment_no;
	}
	public void setComment_no(int comment_no) {
		this.comment_no = comment_no;
	}
	public int getBoard_no() {
		return board_no;
	}
	public void setBoard_no(int board_no) {
		this.board_no = board_no;
	}
	public String getComment_content() {
		return comment_content;
	}
	public void setComment_content(String comment_content) {
		this.comment_content = comment_content;
	}
	public String getComment_createdate() {
		return comment_createdate;
	}
	public void setComment_createdate(String comment_createdate) {
		this.comment_createdate = comment_createdate;
	}
	public int getComment_secret() {
		return comment_secret;
	}
	public void setComment_secret(int comment_secret) {
		this.comment_secret = comment_secret;
	}
	
	
}