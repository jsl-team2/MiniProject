package dao.search;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import db.DBmanager;

public class SearchDao {
	public List<SearchVo> getSearchAll(String keyword) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "select * from tbl_product where product_name like '%"+keyword+"%'";
		List<SearchVo> list = new ArrayList<SearchVo>();
		try {
			conn = DBmanager.getInstance().getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				SearchVo vo = new SearchVo();
				vo.setProduct_no(rs.getInt("product_no"));
				vo.setProduct_name(rs.getNString("product_name"));
				vo.setProduct_price(rs.getInt("product_price"));
				list.add(vo);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBmanager.getInstance().close(conn, pstmt, rs);
		}
		return list;
	}
	
}
