package dao.product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

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
				vo.setProduct_rdate(rs.getString("product_rdate"));

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
				vo.setProduct_price(rs.getInt("product_price"));
				vo.setProduct_rdate(rs.getString("product_rdate"));

			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBmanager.getInstance().close(conn, pstmt, rs);
		}

		return vo;

	}

	public void cartDelete(int cart_no, String user_id) { 

		String sql = "delete from tbl_cart where cart_user=? and cart_productno=?"; 

		try {
			conn = DBmanager.getInstance().getConnection();
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, user_id);
			pstmt.setInt(2, cart_no);

			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBmanager.getInstance().close(conn, pstmt, rs);
		}

	}

	public int getCartCheck(int product_no, String user_id) {

		String sql = "select * from tbl_cart where cart_user=? and cart_productno=?"; 

		int quantity = 0;

		try {

			conn = DBmanager.getInstance().getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, user_id);
			pstmt.setInt(2, product_no);
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

	public void cartInsert(ProductVo vo, int quantity, String user_id) {

		String sql = "insert into tbl_cart \r\n" + "values (tbl_cart_seq.nextval, ?, ?, ?, ?, ?, ?)";
		
		try {
			conn = DBmanager.getInstance().getConnection();
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, user_id);
			pstmt.setInt(2, vo.getProduct_no());
			pstmt.setString(3, vo.getProduct_name());
			pstmt.setString(4, vo.getProduct_picture());
			pstmt.setInt(5, quantity);
			int price = vo.getProduct_price();
			int totprice = quantity * price;
			pstmt.setInt(6, totprice);

			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBmanager.getInstance().close(conn, pstmt, rs);
		}

	}

	public List<ProductVo> getCartAll(String user) { 

		String sql = "select * from tbl_cart where cart_user = ?"; 

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

	public ProductVo getUserInfo(String user_id) {

		String sql = "select * from tbl_user where user_id = ?"; 

		ProductVo vo = new ProductVo();

		try {
			conn = DBmanager.getInstance().getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, user_id);

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

	public void orderInsert(ProductVo vo, String user_id) {

		String sql = "insert into tbl_order \r\n" + 
				" values (tbl_order_seq.nextval, ?, ?, ?, ?, '注文完了', sysdate)";

		try {
			conn = DBmanager.getInstance().getConnection();
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, user_id);
			pstmt.setString(2, vo.getOrder_name());
			pstmt.setString(3, vo.getOrder_tel());
			pstmt.setString(4, vo.getOrder_address());

			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBmanager.getInstance().close(conn, pstmt, rs);
		}

	}

	public int getOrderNo(String user_id) { 

		String sql = "SELECT * \r\n" + "FROM ( \r\n" + "    SELECT * \r\n" + "    FROM tbl_order \r\n"
				+ "    WHERE order_user = ? AND order_status = '注文完了' \r\n" + "    ORDER BY order_no DESC \r\n"
				+ ") \r\n" + "WHERE ROWNUM <= 1"; 

		int order_no = 1;

		try {
			conn = DBmanager.getInstance().getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, user_id);
			
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

		String sql = "insert into tbl_orderdetail \r\n" + " values (tbl_orderdetail_seq.nextval, ?, ?, ?, ?, ?)";

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

		String sql = "insert into tbl_orderdetail \r\n" + " values (tbl_orderdetail_seq.nextval, ?, ?, ?, ?, ?)";

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

		String sql = "delete from tbl_cart where cart_user = ?";

		try {
			conn = DBmanager.getInstance().getConnection();
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, user);

			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBmanager.getInstance().close(conn, pstmt, rs);
		}

	}

	public List<ProductVo> getProductMenuWithPaging(Criteria cri) {

		String sql = "SELECT * FROM (SELECT rownum rn, product_no, product_name, product_picture, \r\n" + 
				"    product_display, product_capacity, product_camera, product_color, product_ram, \r\n" + 
				"    product_weight, product_battery, product_price, product_rdate \r\n" + 
				"    FROM tbl_product WHERE product_name LIKE '%" + cri.getKeyword() + "%' and rownum <= ? * ?) \r\n" + 
				"    WHERE rn > (? - 1) * ?";
		
		List<ProductVo> list = new ArrayList<ProductVo>();

		try {
			conn = DBmanager.getInstance().getConnection();
			pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, cri.getPageNum());
			pstmt.setInt(2, cri.getAmount());
			pstmt.setInt(3, cri.getPageNum());
			pstmt.setInt(4, cri.getAmount());
			
			rs = pstmt.executeQuery();

			while (rs.next()) {
				ProductVo vo = new ProductVo();
				vo.setProduct_no(rs.getInt("product_no"));
				vo.setProduct_name(rs.getNString("product_name"));
				vo.setProduct_picture(rs.getString("product_picture"));
				vo.setProduct_capacity(rs.getString("product_capacity"));
				vo.setProduct_price(rs.getInt("product_price"));

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

	public List<ProductVo> getMyOrder(String user_id) {

		String sql = "select * from tbl_order where order_user = ?"; 

		List<ProductVo> list = new ArrayList<ProductVo>();

		try {
			conn = DBmanager.getInstance().getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, user_id);

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

	public ProductVo getMyOrderOne(int order_no) {

		String sql = "select * from tbl_order where order_no = ?";

		ProductVo vo = new ProductVo();

		try {
			conn = DBmanager.getInstance().getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, order_no);

			rs = pstmt.executeQuery();

			if (rs.next()) {
				vo.setOrder_no(rs.getInt("order_no"));
				vo.setOrder_user(rs.getString("order_user"));
				vo.setOrder_name(rs.getString("order_name"));
				vo.setOrder_tel(rs.getString("order_tel"));
				vo.setOrder_address(rs.getString("order_address"));
				vo.setOrder_status(rs.getString("order_status"));
				String date = rs.getString("order_date");
				vo.setOrder_date(date.substring(0, 10));

				return vo;
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBmanager.getInstance().close(conn, pstmt, rs);
		}

		return vo;

	}

	public List<ProductVo> getMyOrderDetail(int order_no) {

		String sql = "select * from tbl_orderdetail where orderdetail_orderno = ?";

		List<ProductVo> list = new ArrayList<ProductVo>();

		try {
			conn = DBmanager.getInstance().getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, order_no);

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


	public List<ProductVo> getListWithPaging(Criteria cri) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

//		String sql = "select * from (\r\n" + 
//				"    select /*+ index_desc(notice notice_pk) */ rownum rn,idx,title,content,writer,wdate,viewcount from notice\r\n" + 
//				"    where rownum <= ?*?\r\n" + 
//				") where rn > (?-1)*?";

		String sql = "select * from (\r\n"
				+ "    select /*+ index_desc(tbl_product product_pk) */ rownum rn,product_no,product_name,product_picture"
				+ ",product_display,product_capacity,product_camera,product_color,product_ram,product_weight,product_battery,product_price,product_rdate from tbl_product\r\n"
				+ "    where " + cri.getType() + " like '%" + cri.getKeyword() + "%' and rownum <= ?*?\r\n"
				+ ") where rn > (?-1)*?";

		List<ProductVo> list = new ArrayList<ProductVo>();
		try {
			conn = DBmanager.getInstance().getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, cri.getPageNum());
			pstmt.setInt(2, cri.getAmount());
			pstmt.setInt(3, cri.getPageNum());
			pstmt.setInt(4, cri.getAmount());
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
				vo.setProduct_rdate(rs.getString("product_rdate"));
				list.add(vo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBmanager.getInstance().close(conn, pstmt, rs);
		}
		return list;
	}

	public int getUserCount(Criteria cri) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int total = 0;
		String sql = "select count(*) as total from tbl_product where " + cri.getType() + " like '%" + cri.getKeyword()
				+ "%'";
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

	public List<ProductVo> getAdminOrderView() {

		String sql = "select * from tbl_order";

		List<ProductVo> list = new ArrayList<ProductVo>();

		try {
			conn = DBmanager.getInstance().getConnection();
			pstmt = conn.prepareStatement(sql);
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

	public void setAdminOrderStatus(int order_no, String order_status) {

		String sql = "update tbl_order set order_status = ? where order_no = ?";

		try {
			conn = DBmanager.getInstance().getConnection();
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, order_status);
			pstmt.setInt(2, order_no);

			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBmanager.getInstance().close(conn, pstmt, rs);
		}

	}
	
	public List<ProductVo> getProductSelectAllWithPaging(Criteria cri) {

		String sql = "SELECT * FROM (SELECT rownum rn, product_no, product_name, product_picture, " +
	             "product_display, product_capacity, product_camera, product_color, product_ram, " +
	             "product_weight, product_battery, product_price, product_rdate FROM tbl_product " +
	             "WHERE rownum <= ? * ?) WHERE rn > (? - 1) * ?";

		List<ProductVo> list = new ArrayList<ProductVo>();

		try {
			conn = DBmanager.getInstance().getConnection();
			pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, cri.getPageNum());
			pstmt.setInt(2, cri.getAmount());
			pstmt.setInt(3, cri.getPageNum());
			pstmt.setInt(4, cri.getAmount());

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
	
	public int getProductCount(Criteria cri) {

		String sql = "select count(*) as total from tbl_product";

		int tot = 0;

		try {
			conn = DBmanager.getInstance().getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				tot = rs.getInt("total");
				return tot;
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBmanager.getInstance().close(conn, pstmt, rs);
		}

		return tot;

	}
	
	public int getProductMenuCount(Criteria cri) {

		String sql = "select count(*) as total from tbl_product WHERE product_name LIKE '%" + cri.getKeyword() + "%'";

		int tot = 0;

		try {
			conn = DBmanager.getInstance().getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				tot = rs.getInt("total");
				return tot;
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBmanager.getInstance().close(conn, pstmt, rs);
		}

		return tot;

	}
	
	public List<ProductVo> getMyOrderWithPaging(Criteria cri, String user_id) {

		String sql = "SELECT * FROM (SELECT rownum rn, order_no, order_user, order_name,\r\n" + 
				"    order_tel, order_address, order_status, order_date \r\n" + 
				"    FROM tbl_order WHERE rownum <= ? * ? ORDER BY order_no DESC) WHERE rn > (? - 1) * ? \r\n" + 
				"    and order_user=? order by order_no desc"; 

		List<ProductVo> list = new ArrayList<ProductVo>();

		try {
			conn = DBmanager.getInstance().getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, cri.getPageNum());
			pstmt.setInt(2, cri.getAmount());
			pstmt.setInt(3, cri.getPageNum());
			pstmt.setInt(4, cri.getAmount());
			pstmt.setString(5, user_id);

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
	
	public int getMyOrderCount(Criteria cri, String user_id) {
		
		int total = 0;
		
		String sql = "select count(*) as total from tbl_order WHERE order_user LIKE ?";
		
		try {
			conn = DBmanager.getInstance().getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, user_id);
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
	

	public List<ProductVo> getAdminOrderWithPaging(Criteria cri) {

		String sql = "SELECT * FROM (SELECT rownum rn, order_no, order_user, order_name,\r\n" + 
				"    order_tel, order_address, order_status, order_date \r\n" + 
				"    FROM tbl_order WHERE rownum <= ? * ? ORDER BY order_no DESC) WHERE rn > (? - 1) * ? \r\n" + 
				"    order by order_no desc"; 

		List<ProductVo> list = new ArrayList<ProductVo>();

		try {
			conn = DBmanager.getInstance().getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, cri.getPageNum());
			pstmt.setInt(2, cri.getAmount());
			pstmt.setInt(3, cri.getPageNum());
			pstmt.setInt(4, cri.getAmount());

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
	
	public int getAdminOrderCount(Criteria cri) {
		
		int total = 0;
		
		String sql = "select count(*) as total from tbl_order";
		
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
	
	public void updateProduct(ProductVo vo,int no) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		String sql ="update tbl_product set product_name=?,product_picture=?,product_display=?"
				+ ",product_capacity=?,product_camera=?,product_color=?,product_ram=?"
				+ ",product_weight=?,product_battery=?,product_price=?,product_rdate=? where product_no=?";
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
			pstmt.setInt(12, no);
			
			pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBmanager.getInstance().close(conn, pstmt);
		}
	}
	
	public void deleteProduct(int no) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		String sql ="delete from tbl_product where product_no = ?";
		try {
			conn = DBmanager.getInstance().getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, no);
			pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBmanager.getInstance().close(conn, pstmt);
		}
	}

}
