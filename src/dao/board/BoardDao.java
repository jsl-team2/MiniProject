package dao.board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import db.DBmanager;
import utility.Criteria;

public class BoardDao {
	
	//Insert기능
	public void BoardInsert(BoardVo vo) {
		Connection conn = null;
		PreparedStatement pstmt = null;

		String sql = "insert into tbl_board (board_no, board_title, board_writer, board_content, "
				+ " board_date, board_hits ) "
				+ " values (tbl_board_seq.nextval,?,?,?,sysdate,0)";

		
		try {
			conn = DBmanager.getInstance().getConnection();
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, vo.getBoard_title());
			pstmt.setString(2, vo.getBoard_writer());
			pstmt.setString(3, vo.getBoard_content());

			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBmanager.getInstance().close(conn, pstmt);
		}
	}
	
	//글 총 개수 구하는 기능 
	public int getBoardCount() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "select count(*) as total from tbl_board";
		int total = 0;
		try {
			conn = DBmanager.getInstance().getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				total = rs.getInt("total");
				return total;
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBmanager.getInstance().close(conn, pstmt, rs);
		}
		return total;
	}
	
	
	
	//해당 페이지 글 가져오는 기능 
	public BoardVo getAll(int board_no) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		BoardVo vo = null;

		setBoardClickCount(board_no);

		String sql = "select * from tbl_board where board_no = ? ";

		try {
			conn = DBmanager.getInstance().getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, board_no);
			rs = pstmt.executeQuery();

			if (rs.next()) {

				vo = new BoardVo();
				vo.setBoard_no(rs.getInt("board_no"));
				vo.setBoard_title(rs.getString("board_title"));
				vo.setBoard_writer(rs.getString("board_writer"));
				vo.setBoard_content(rs.getString("board_content"));
				vo.setBoard_date(rs.getString("board_date"));
				vo.setBoard_hits(rs.getInt("board_hits"));

			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBmanager.getInstance().close(conn, pstmt, rs);
		}
		return vo;
	}
	
	//해당 글 페이지에서의 삭제 기능
	public void getBoardDelet(int board_no) {
		Connection conn = null;
		PreparedStatement pstmt = null;

		String sql = "delete tbl_board where board_no = ?";

		try {
			conn = DBmanager.getInstance().getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, board_no);
			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBmanager.getInstance().close(conn, pstmt);
		}

	}

	//해당 글 페이지에서의 수정 기능
	public void setBoardUpdate(BoardVo vo) {
		Connection conn = null;
		PreparedStatement pstmt = null;

		String sql = "update tbl_board set board_title = ?, board_content = ?, "
					+" board_date = sysdate where board_no =? ";

		try {
			conn = DBmanager.getInstance().getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getBoard_title());
			pstmt.setString(2, vo.getBoard_content());
			pstmt.setInt(3, vo.getBoard_no());
			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBmanager.getInstance().close(conn, pstmt);
		}

	}
	
	//게시글 조회수 기능
	public void setBoardClickCount(int board_no) {
		Connection conn = null;
		PreparedStatement pstmt = null;

		String sql = "update tbl_board set board_hits = board_hits +1 where board_no =?";

		try {
			conn = DBmanager.getInstance().getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, board_no);
			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBmanager.getInstance().close(conn, pstmt);
		}

	}
	
	//검색 기능
	public List<BoardVo> getBoardSearch(String type, String keyword) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from tbl_board where " + type + " like ? order by board_no desc";

		List<BoardVo> list = new ArrayList<BoardVo>();

		try {
			conn = DBmanager.getInstance().getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%" + keyword + "%");
			rs = pstmt.executeQuery();

			while (rs.next()) {

				BoardVo vo = new BoardVo();

				vo.setBoard_no(rs.getInt("board_no"));
				vo.setBoard_title(rs.getString("board_title"));
				vo.setBoard_content(rs.getString("board_content"));
				vo.setBoard_hits(rs.getInt("board_hits"));
				vo.setBoard_writer(rs.getString("board_writer"));
				vo.setBoard_date(rs.getString("board_date").toString().substring(0, 10));

				list.add(vo);

			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBmanager.getInstance().close(conn, pstmt, rs);
		}

		return list;

	}
	
	//검색 후 총 게시글 수
	public int getBoardSerchCount(Criteria cri) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		if(cri.getKeyword()!=null) {
			sql = " select count(*) as total from tbl_board where "+cri.getType()+" like '%"+ cri.getKeyword()+"%'";
		}else {
		   sql = " select count(*) as total from tbl_board ";
		   	}
		int total = 0;
		try {
			conn = DBmanager.getInstance().getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				total = rs.getInt("total");
				return total;
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBmanager.getInstance().close(conn, pstmt, rs);
		}
		return total;
	}

	//게시글 list출력 (지정 갯수만큼)
	public List<BoardVo> getListSetWithPaging(Criteria cri) {

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "SELECT * FROM ( SELECT /*+ index_desc(tbl_board board_pk) */ rownum rn, "
				+ "board_no, board_title, board_content, board_writer, board_date, board_hits FROM tbl_board "
		        + "WHERE " + cri.getType() + " LIKE '%" + cri.getKeyword() + "%' AND rownum <= ?*? "
		        + "order by board_no desc ) "
		        + "WHERE rn > (?-1)*? ";
		
		
		
		List<BoardVo> list = new ArrayList<BoardVo>();

		try {
			conn = DBmanager.getInstance().getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, cri.getPageNum());
			pstmt.setInt(2, cri.getAmount());
			pstmt.setInt(3, cri.getPageNum());
			pstmt.setInt(4, cri.getAmount());
			rs = pstmt.executeQuery();

			while (rs.next()) {

				BoardVo vo = new BoardVo();

				vo.setBoard_no(rs.getInt("board_no"));
				vo.setBoard_title(rs.getString("board_title"));
				vo.setBoard_content(rs.getString("board_content"));
				vo.setBoard_hits(rs.getInt("board_hits"));
				vo.setBoard_writer(rs.getString("board_writer"));
				vo.setBoard_date(rs.getString("board_date").toString().substring(0, 10));

				list.add(vo);

			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBmanager.getInstance().close(conn, pstmt, rs);
		}
		return list;
	}
	
	//이전 페이지 이동
	public BoardVo getPrevNoticeNo(int board_no) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		BoardVo vo = new BoardVo();
		String sql = "select * from tbl_board where board_no = (select max(board_no) from tbl_board where board_no < ?) ";


		try {
			conn = DBmanager.getInstance().getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, board_no);
			rs = pstmt.executeQuery();
			while (rs.next()) {

				vo.setBoard_no(rs.getInt("board_no"));
				vo.setBoard_title(rs.getString("board_title"));
				vo.setBoard_content(rs.getString("board_content"));
				vo.setBoard_hits(rs.getInt("board_hits"));
				vo.setBoard_writer(rs.getString("board_writer"));
				vo.setBoard_date(rs.getString("board_date").toString().substring(0, 10));
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBmanager.getInstance().close(conn, pstmt, rs);
		}
		return vo;
	}
		
	//다음 페이지 이동
	public BoardVo getNextNoticeNo(int board_no) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		BoardVo vo = new BoardVo();
		String sql = "select * from tbl_board where board_no = (select min(board_no) from tbl_board where board_no > ?)";


		try {
			conn = DBmanager.getInstance().getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, board_no);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {

				vo.setBoard_no(rs.getInt("board_no"));
				vo.setBoard_title(rs.getString("board_title"));
				vo.setBoard_content(rs.getString("board_content"));
				vo.setBoard_hits(rs.getInt("board_hits"));
				vo.setBoard_writer(rs.getString("board_writer"));
				vo.setBoard_date(rs.getString("board_date").toString().substring(0, 10));
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBmanager.getInstance().close(conn, pstmt, rs);
		}
		return vo;
	}

	//댓글 글 쓰기
	public void CommentInsert(CommentVo vo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		String sql = "insert into tbl_comment (comment_no, board_no, comment_id, comment_content, "
				+ " comment_createdate) "
				+ " values (tbl_comment_seq.nextval,?,?,?,sysdate)";

		
		try {
			conn = DBmanager.getInstance().getConnection();
			pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, vo.getBoard_no());
			pstmt.setString(2, vo.getComment_id());
			pstmt.setString(3, vo.getComment_content());

			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBmanager.getInstance().close(conn, pstmt);
		}
	}
	
	//해당 댓글 가져오기
	public List<CommentVo> getCommentSelect(int Board_no) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		CommentVo vo = null;
		List<CommentVo> list = new ArrayList<CommentVo>();
		String sql = "select * from tbl_comment where board_no = ? order by comment_createdate desc";

		try {
			conn = DBmanager.getInstance().getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, Board_no);
			rs = pstmt.executeQuery();

			while (rs.next()) {

				vo = new CommentVo();
				
				vo.setBoard_no(rs.getInt("board_no"));
				vo.setComment_no(rs.getInt("comment_no"));
				vo.setComment_id(rs.getString("comment_id"));
				vo.setComment_content(rs.getString("comment_content"));
				vo.setComment_createdate(rs.getString("comment_createdate"));
				
				
				list.add(vo);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBmanager.getInstance().close(conn, pstmt, rs);
		}
		return list;
	}
	
	//댓글 삭제 
	public void getCommentDelet(int comment_no) {
		Connection conn = null;
		PreparedStatement pstmt = null;

		String sql = "delete tbl_comment where comment_no = ?";

		try {
			conn = DBmanager.getInstance().getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, comment_no);
			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBmanager.getInstance().close(conn, pstmt);
		}
	}
	
	//댓글 수정
	public void setCommentUpdate(CommentVo vo) {
		Connection conn = null;
		PreparedStatement pstmt = null;

		String sql = "update tbl_comment set comment_content = ?, "
					+" comment_createdate = sysdate where comment_no =? ";

		try {
			conn = DBmanager.getInstance().getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getComment_content());
			pstmt.setInt(2, vo.getComment_no());
			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBmanager.getInstance().close(conn, pstmt);
		}
	}
	
	//
	
}
