package dao.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


import db.DBmanager;
import utility.Criteria;

public class UserDao {
	public List<UserVo> userSelectAll() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "select * from tbl_user";
		List<UserVo> list = new ArrayList<UserVo>();
		try {
			conn = DBmanager.getInstance().getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
		while(rs.next()) {
			UserVo vo = new UserVo();
			vo.setUser_address(rs.getString("user_address"));
			vo.setUser_email(rs.getString("user_email"));
			vo.setUser_id(rs.getString("user_id"));
			vo.setUser_name(rs.getString("user_name"));
			vo.setUser_no(rs.getInt("user_no"));
			vo.setUser_phone(rs.getString("user_phone"));
			list.add(vo);
		}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBmanager.getInstance().close(conn, pstmt, rs);
		}
		return list;
	}
	
	public List<UserVo> userSearch(String type, String keyword) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "select * from tbl_user where "+type+" like '%"+keyword+"%'";
		List<UserVo> list = new ArrayList<UserVo>();
		try {
			conn = DBmanager.getInstance().getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
		while(rs.next()) {
			UserVo vo = new UserVo();
			vo.setUser_address(rs.getString("user_address"));
			vo.setUser_email(rs.getString("user_email"));
			vo.setUser_id(rs.getString("user_id"));
			vo.setUser_name(rs.getString("user_name"));
			vo.setUser_no(rs.getInt("user_no"));
			vo.setUser_phone(rs.getString("user_phone"));
			list.add(vo);
		}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBmanager.getInstance().close(conn, pstmt, rs);
		}
		return list;
	}
	
	public List<UserVo> getListWithPaging(Criteria cri){
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
//		String sql = "select * from (\r\n" + 
//				"    select /*+ index_desc(notice notice_pk) */ rownum rn,idx,title,content,writer,wdate,viewcount from notice\r\n" + 
//				"    where rownum <= ?*?\r\n" + 
//				") where rn > (?-1)*?";
		
		String sql = "select * from (\r\n" + 
				"    select /*+ index_desc(tbl_user user_pk) */ rownum rn,user_no,user_id,user_name,user_phone,user_email,user_address from tbl_user\r\n" + 
				"    where "+cri.getType()+" like '%" + cri.getKeyword()+"%' and rownum <= ?*?\r\n" + 
				") where rn > (?-1)*?";
		
		List<UserVo> list = new ArrayList<UserVo>();
 		try {
			conn = DBmanager.getInstance().getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, cri.getPageNum());
			pstmt.setInt(2, cri.getAmount());
			pstmt.setInt(3, cri.getPageNum());
			pstmt.setInt(4, cri.getAmount());
			rs = pstmt.executeQuery();
			while(rs.next()) {
				
				UserVo vo = new UserVo();
				vo.setUser_address(rs.getString("user_address"));
				vo.setUser_email(rs.getString("user_email"));
				vo.setUser_id(rs.getString("user_id"));
				vo.setUser_name(rs.getString("user_name"));
				vo.setUser_no(rs.getInt("user_no"));
				vo.setUser_phone(rs.getString("user_phone"));
				list.add(vo);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBmanager.getInstance().close(conn, pstmt, rs);
		}
		return list;
	}
	public int getUserCount(Criteria cri) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int total = 0;
		String sql = "select count(*) as total from tbl_user where "+cri.getType()+" like '%"+cri.getKeyword()+"%'";
		try {
			conn = DBmanager.getInstance().getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				total = rs.getInt("total");
				return total;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBmanager.getInstance().close(conn, pstmt, rs);
		}
		return total;
	}
}
