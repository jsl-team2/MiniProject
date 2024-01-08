package dao.product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import db.DBmanager;

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

}
