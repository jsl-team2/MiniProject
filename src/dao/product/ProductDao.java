package dao.product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import dao.user.UserVo;
import db.DBmanager;
import utility.Criteria;

public class ProductDao {

	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	public List<ProductVo> getRecentProducts() {
		String sql = "select * from tbl_product order by product_rdate desc";
		List<ProductVo> list = new ArrayList<ProductVo>();
		try {
			conn = DBmanager.getInstance().getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				ProductVo vo = new ProductVo();
				vo.setProduct_no(rs.getInt("product_no"));
				vo.setProduct_name(rs.getString("product_name"));
				vo.setProduct_picture(rs.getString("product_picture"));
				vo.setProduct_display(rs.getString("product_display"));
				vo.setProduct_capacity(rs.getString("product_capacity"));
				vo.setProduct_camera(rs.getString("product_camera"));
				vo.setProduct_color(rs.getString("product_color"));
				vo.setProduct_ram(rs.getString("product_ram"));
				vo.setProduct_weight(rs.getString("product_weight"));
				vo.setProduct_battery(rs.getString("product_battery"));
				vo.setProduct_price(rs.getInt("product_price"));
				vo.setProduct_rdate(rs.getString("product_rdate"));
				list.add(vo);
			}
		}catch (Exception e) {
				e.printStackTrace();
		} finally {
				DBmanager.getInstance().close(conn, pstmt, rs);
		}

			return list;
		
	}
	public List<ProductVo> getProductSelectAll() {

		String sql = "select * from tbl_product";

		List<ProductVo> list = new ArrayList<ProductVo>();

		try {
			conn = DBmanager.getInstance().getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {

				ProductVo vo = new ProductVo();

				vo.setProduct_no(rs.getInt("product_no"));
				vo.setProduct_name(rs.getString("product_name"));
				vo.setProduct_picture(rs.getString("product_picture"));
				vo.setProduct_display(rs.getString("product_display"));
				vo.setProduct_capacity(rs.getString("product_capacity"));
				vo.setProduct_camera(rs.getString("product_camera"));
				vo.setProduct_color(rs.getString("product_color"));
				vo.setProduct_ram(rs.getString("product_ram"));
				vo.setProduct_weight(rs.getString("product_weight"));
				vo.setProduct_battery(rs.getString("product_battery"));
				vo.setProduct_price(rs.getInt("product_price"));

				list.add(vo);

			}

			System.out.println(list.get(0).getProduct_name());

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBmanager.getInstance().close(conn, pstmt, rs);
		}

		return list;

	}

	public ProductVo getProductSelectOne(int product_no) {

		String sql = "select * from tbl_product where product_no = ?";

		ProductVo vo = new ProductVo();

		try {

			conn = DBmanager.getInstance().getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, product_no);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				
				vo.setProduct_no(rs.getInt("product_no"));
				vo.setProduct_name(rs.getString("product_name"));
				vo.setProduct_picture(rs.getString("product_picture"));
				vo.setProduct_display(rs.getString("product_display"));
				vo.setProduct_capacity(rs.getString("product_capacity"));
				vo.setProduct_camera(rs.getString("product_camera"));
				vo.setProduct_color(rs.getString("product_color"));
				vo.setProduct_ram(rs.getString("product_ram"));
				vo.setProduct_weight(rs.getString("product_weight"));
				vo.setProduct_battery(rs.getString("product_battery"));
				vo.setProduct_price(rs.getInt("product_price"));
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBmanager.getInstance().close(conn, pstmt, rs);
		}

		return vo;

	}
	
	public void setBasket(ProductVo vo) {

		String sql = "insert into tbl_basket \r\n" + 
				"values (basket_seq.nextval, 'user', ?, ?, ?)";

		try {
			conn = DBmanager.getInstance().getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getProduct_name());
			pstmt.setString(2, vo.getProduct_name());
			pstmt.setInt(3, vo.getProduct_price());
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBmanager.getInstance().close(conn, pstmt, rs);
		}

	}
	
//	public List<ProductVo> getBasketAll() {
//
//		String sql = "select * from tbl_product";
//
//		List<ProductVo> list = new ArrayList<ProductVo>();
//
//		try {
//			conn = DBmanager.getInstance().getConnection();
//			pstmt = conn.prepareStatement(sql);
//			rs = pstmt.executeQuery();
//
//			while (rs.next()) {
//
//				ProductVo vo = new ProductVo();
//
//				vo.setProduct_no(rs.getInt("product_no"));
//				vo.setProduct_name(rs.getString("product_name"));
//				vo.setProduct_picture(rs.getString("product_picture"));
//				vo.setProduct_display(rs.getString("product_display"));
//				vo.setProduct_capacity(rs.getString("product_capacity"));
//				vo.setProduct_camera(rs.getString("product_camera"));
//				vo.setProduct_color(rs.getString("product_color"));
//				vo.setProduct_ram(rs.getString("product_ram"));
//				vo.setProduct_weight(rs.getString("product_weight"));
//				vo.setProduct_battery(rs.getString("product_battery"));
//				vo.setProduct_price(rs.getInt("product_price"));
//
//				list.add(vo);
//
//			}
//
//			System.out.println(list.get(0).getProduct_name());
//
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			DBmanager.getInstance().close(conn, pstmt, rs);
//		}
//
//		return list;
//
//	}
	
	public List<ProductVo> getListWithPaging(Criteria cri){
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
//		String sql = "select * from (\r\n" + 
//				"    select /*+ index_desc(notice notice_pk) */ rownum rn,idx,title,content,writer,wdate,viewcount from notice\r\n" + 
//				"    where rownum <= ?*?\r\n" + 
//				") where rn > (?-1)*?";
		
		String sql = "select * from (\r\n" + 
				"    select /*+ index_desc(tbl_product product_pk) */ rownum rn,product_no,product_name,product_picture"
				+ ",product_display,product_capacity,product_camera,product_color,product_ram,product_weight,product_battery,product_price,product_rdate from tbl_product\r\n" + 
				"    where "+cri.getType()+" like '%" + cri.getKeyword()+"%' and rownum <= ?*?\r\n" + 
				") where rn > (?-1)*?";
		
		List<ProductVo> list = new ArrayList<ProductVo>();
 		try {
			conn = DBmanager.getInstance().getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, cri.getPageNum());
			pstmt.setInt(2, cri.getAmount());
			pstmt.setInt(3, cri.getPageNum());
			pstmt.setInt(4, cri.getAmount());
			rs = pstmt.executeQuery();
			while(rs.next()) {
				ProductVo vo = new ProductVo();
				vo.setProduct_no(rs.getInt("product_no"));
				vo.setProduct_name(rs.getString("product_name"));
				vo.setProduct_picture(rs.getString("product_picture"));
				vo.setProduct_display(rs.getString("product_display"));
				vo.setProduct_capacity(rs.getString("product_capacity"));
				vo.setProduct_camera(rs.getString("product_camera"));
				vo.setProduct_color(rs.getString("product_color"));
				vo.setProduct_ram(rs.getString("product_ram"));
				vo.setProduct_weight(rs.getString("product_weight"));
				vo.setProduct_battery(rs.getString("product_battery"));
				vo.setProduct_price(rs.getInt("product_price"));
				vo.setProduct_rdate(rs.getString("product_rdate"));
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
		String sql = "select count(*) as total from tbl_product where "+cri.getType()+" like '%"+cri.getKeyword()+"%'";
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
	
	public void insertProduct(ProductVo vo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		String sql ="insert into tbl_product (product_no,product_name,product_picture,"
				+ "product_display,product_capacity,product_camera,product_color,product_ram,"
				+ "product_weight,product_battery,product_price,product_rdate) values(product_seq.nextval,"
				+ "?,?,?,?,?,?,?,?,?,?,?)";
		try {
			conn = DBmanager.getInstance().getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getProduct_name());
			pstmt.setString(2,vo.getProduct_picture());
			pstmt.setString(3,vo.getProduct_display());
			pstmt.setString(4, vo.getProduct_capacity());
			pstmt.setString(5, vo.getProduct_camera());
			pstmt.setString(6, vo.getProduct_color());
			pstmt.setString(7, vo.getProduct_ram());
			pstmt.setString(8, vo.getProduct_weight());
			pstmt.setString(9, vo.getProduct_battery());
			pstmt.setInt(10, vo.getProduct_price());
			pstmt.setString(11, vo.getProduct_rdate());
			
			pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBmanager.getInstance().close(conn, pstmt);
		}
	}
}
