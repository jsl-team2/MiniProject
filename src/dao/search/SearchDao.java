package dao.search;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import db.DBmanager;

public class SearchDao {
	public List<SearchVo> getSearchProduct(String keyword) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "select * from tbl_product where product_name like '%"+keyword+"%'";
		List<SearchVo> productList = new ArrayList<SearchVo>();
		try {
			conn = DBmanager.getInstance().getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				SearchVo vo = new SearchVo();
				vo.setProduct_no(rs.getInt("product_no"));
				vo.setProduct_name(rs.getNString("product_name"));
				vo.setProduct_price(rs.getInt("product_price"));
				vo.setProduct_picture(rs.getString("product_picture"));
				productList.add(vo);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBmanager.getInstance().close(conn, pstmt, rs);
		}
		return productList;
	}
	
	public List<SearchVo> getSearchBoard(String keyword) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "select * from tbl_board where board_title like '%"+keyword+"%'"
				+ " or board_content like '%"+keyword+"%'";
		List<SearchVo> boardList = new ArrayList<SearchVo>();
		try {
			conn = DBmanager.getInstance().getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				SearchVo vo = new SearchVo();
				vo.setBoard_no(rs.getInt("board_no"));
				vo.setBoard_title(rs.getNString("board_title"));
				vo.setBoard_content(rs.getString("board_content"));
				vo.setBoard_writer(rs.getString("board_writer"));
				vo.setBoard_date(rs.getString("board_date"));
				boardList.add(vo);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBmanager.getInstance().close(conn, pstmt, rs);
		}
		return boardList;
	}
}
