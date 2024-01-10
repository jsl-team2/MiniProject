package dao.product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import db.DBmanager;

public class ProductDao {

	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;

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
				vo.setProduct_rdate(rs.getString("product_rdate"));
				vo.setProduct_price(rs.getInt("product_price"));

				list.add(vo);

			}

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
				vo.setProduct_rdate(rs.getString("product_rdate"));
				vo.setProduct_price(rs.getInt("product_price"));

			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBmanager.getInstance().close(conn, pstmt, rs);
		}

		return vo;

	}

	public void cartDelete(int cart_no) {

		String sql = "delete from tbl_cart where cart_user = 'user' and cart_productno=?"; // user

		try {
			conn = DBmanager.getInstance().getConnection();
			pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, cart_no);

			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBmanager.getInstance().close(conn, pstmt, rs);
		}

	}

	public int getCartCheck(int product_no) {

		String sql = "select * from tbl_cart where cart_user='user' and cart_productno=?";

		int quantity = 0;

		try {

			conn = DBmanager.getInstance().getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, product_no);
			rs = pstmt.executeQuery();

			if (rs.next()) {

				quantity = rs.getInt("cart_quantity");
				return quantity;

			} else {
				quantity = 0;
				return quantity;
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBmanager.getInstance().close(conn, pstmt, rs);
		}

		quantity = 0;
		return quantity;

	}

	public void cartInsert(ProductVo vo, int quantity) {

		String sql = "insert into tbl_cart \r\n" + "values (basket_seq.nextval, 'user', ?, ?, ?, ?, ?)"; // user

		try {
			conn = DBmanager.getInstance().getConnection();
			pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, vo.getProduct_no());
			pstmt.setString(2, vo.getProduct_name());
			pstmt.setString(3, vo.getProduct_picture());
			pstmt.setInt(4, quantity);
			int price = vo.getProduct_price();
			int totprice = quantity * price;
			pstmt.setInt(5, totprice);

			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBmanager.getInstance().close(conn, pstmt, rs);
		}

	}

	public List<ProductVo> getCartAll(String user) {

		String sql = "select * from tbl_cart where cart_user = ?"; // user

		List<ProductVo> list = new ArrayList<ProductVo>();

		try {
			conn = DBmanager.getInstance().getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, user);

			rs = pstmt.executeQuery();

			while (rs.next()) {

				ProductVo vo = new ProductVo();

				vo.setCart_no(rs.getInt("cart_no"));
				vo.setCart_user(rs.getString("cart_user"));
				vo.setCart_productno(rs.getInt("cart_productno"));
				vo.setCart_product(rs.getString("cart_product"));
				vo.setCart_picture(rs.getString("cart_picture"));
				vo.setCart_quantity(rs.getInt("cart_quantity"));
				vo.setCart_price(rs.getInt("cart_price"));

				list.add(vo);

			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBmanager.getInstance().close(conn, pstmt, rs);
		}

		return list;

	}

	public ProductVo getUserInfo() {

		String sql = "select * from tbl_user where user_id = ?"; // user

		String user = "user";
		ProductVo vo = new ProductVo();

		try {
			conn = DBmanager.getInstance().getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, user);

			rs = pstmt.executeQuery();

			if (rs.next()) {
				vo.setOrder_name(rs.getString("user_name"));
				vo.setOrder_tel(rs.getString("user_phone"));
				vo.setOrder_address(rs.getString("user_address"));
				return vo;
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBmanager.getInstance().close(conn, pstmt, rs);
		}

		return vo;

	}

	public void orderInsert(ProductVo vo) {

		String sql = "insert into tbl_order \r\n" + " values (order_seq.nextval, 'user', ?, ?, ?, '주문완료', sysdate)"; // user

		try {
			conn = DBmanager.getInstance().getConnection();
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, vo.getOrder_name());
			pstmt.setString(2, vo.getOrder_tel());
			pstmt.setString(3, vo.getOrder_address());

			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBmanager.getInstance().close(conn, pstmt, rs);
		}

	}

	public int getOrderNo() {

		String sql = "SELECT * \r\n" + "FROM ( \r\n" + "    SELECT * \r\n" + "    FROM tbl_order \r\n"
				+ "    WHERE order_user = 'user' AND order_status = '주문완료' \r\n" + "    ORDER BY order_no DESC \r\n"
				+ ") \r\n" + "WHERE ROWNUM <= 1"; // user

		int order_no = 1;

		try {
			conn = DBmanager.getInstance().getConnection();
			pstmt = conn.prepareStatement(sql);

			rs = pstmt.executeQuery();

			if (rs.next()) {
				order_no = rs.getInt("order_no");
				return order_no;
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBmanager.getInstance().close(conn, pstmt, rs);
		}

		return order_no;

	}

	public void orderdetailInsert(List<ProductVo> list) {

		String sql = "insert into tbl_orderdetail \r\n" + " values (orderdetail_seq.nextval, ?, ?, ?, ?, ?)"; // user

		try {
			for (ProductVo vo : list) {
				conn = DBmanager.getInstance().getConnection();
				pstmt = conn.prepareStatement(sql);

				pstmt.setInt(1, vo.getOrderdetail_orderno());
				pstmt.setString(2, vo.getProduct_picture());
				pstmt.setString(3, vo.getProduct_name());
				pstmt.setInt(4, vo.getCart_quantity());
				pstmt.setInt(5, vo.getCart_price());

				pstmt.executeUpdate();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBmanager.getInstance().close(conn, pstmt, rs);
		}

	}

	public void orderdetailAllInsert(List<ProductVo> list) {

		String sql = "insert into tbl_orderdetail \r\n" + " values (orderdetail_seq.nextval, ?, ?, ?, ?, ?)"; // user

		try {
			for (ProductVo vo : list) {
				conn = DBmanager.getInstance().getConnection();
				pstmt = conn.prepareStatement(sql);

				pstmt.setInt(1, vo.getOrderdetail_orderno());
				pstmt.setString(2, vo.getCart_picture());
				pstmt.setString(3, vo.getCart_product());
				pstmt.setInt(4, vo.getCart_quantity());
				pstmt.setInt(5, vo.getCart_price());

				pstmt.executeUpdate();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBmanager.getInstance().close(conn, pstmt, rs);
		}

	}

	public void cartDelete(String user) {

		String sql = "delete from tbl_cart where cart_user = 'user'"; // user

		try {
			conn = DBmanager.getInstance().getConnection();
			pstmt = conn.prepareStatement(sql);

//			pstmt.setString(1, user);

			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBmanager.getInstance().close(conn, pstmt, rs);
		}

	}

	public List<ProductVo> getProductMenu(String keyword) {
		
		String sql = "SELECT * FROM tbl_product WHERE product_name LIKE '%"+keyword+"%'";
		
		List<ProductVo> list = new ArrayList<ProductVo>();
		
		try {
			conn = DBmanager.getInstance().getConnection();
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				ProductVo vo = new ProductVo();
				vo.setProduct_no(rs.getInt("product_no"));
				vo.setProduct_name(rs.getNString("product_name"));
				vo.setProduct_picture(rs.getString("product_picture"));
				vo.setProduct_capacity(rs.getString("product_capacity"));
				vo.setProduct_price(rs.getInt("product_price"));
				
				list.add(vo);
				
			}
			
			return list;
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBmanager.getInstance().close(conn, pstmt, rs);
		}
		
		return list;
		
	}
	
	public List<ProductVo> getMyOrder(String user) {

		String sql = "select * from tbl_order where order_user = ?"; // user

		List<ProductVo> list = new ArrayList<ProductVo>();
		
		try {
			conn = DBmanager.getInstance().getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, user);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				ProductVo vo = new ProductVo();
				
				vo.setOrder_no(rs.getInt("order_no"));
				vo.setOrder_user(rs.getString("order_user"));
				vo.setOrder_name(rs.getString("order_name"));
				vo.setOrder_tel(rs.getString("order_tel"));
				vo.setOrder_address(rs.getString("order_address"));
				vo.setOrder_status(rs.getString("order_status"));
				String date = rs.getString("order_date");
				vo.setOrder_date(date.substring(0, 10));
				
				list.add(vo);
			}
			
			return list;

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBmanager.getInstance().close(conn, pstmt, rs);
		}

		return list;

	}
	
	public List<ProductVo> getMyOrderDetail(String user) {

		String sql = "select * from tbl_orderdetail where user_id = ?"; // user

		List<ProductVo> list = new ArrayList<ProductVo>();
		
		try {
			conn = DBmanager.getInstance().getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, user);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				ProductVo vo = new ProductVo();
				
				vo.setOrderdetail_no(rs.getInt("orderdetail_no"));
				vo.setOrderdetail_orderno(rs.getInt("orderdetail_orderno"));
				vo.setOrderdetail_picture(rs.getString("orderdetail_picture"));
				vo.setOrderdetail_product(rs.getString("orderdetail_product"));
				vo.setOrderdetail_quantity(rs.getInt("orderdetail_quantity"));
				vo.setOrderdetail_price(rs.getInt("orderdetail_price"));
				
				list.add(vo);
			}
			
			return list;

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBmanager.getInstance().close(conn, pstmt, rs);
		}

		return list;

	}

}
