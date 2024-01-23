package dao.product;

public class ProductVo {
	
	private int product_no;
	private String product_name;
	private String product_picture;
	private String product_detailpicture;
	private String product_display;
	private String product_capacity;
	private String product_camera;
	private String product_color;
	private String product_ram;
	private String product_weight;
	private String product_battery;
	private String product_rdate;
	private int product_price;
	
	private int cart_no;
	private String cart_user;
	private int cart_productno; 
	private String cart_product;
	private String cart_picture;
	private int cart_quantity;
	private int cart_price; 
	
	private int order_no;
	private String order_user;
	private String order_name;
	private String order_tel;
	private String order_address;
	private String order_status;
	private String order_date;
	
	private int orderdetail_no;
	private int orderdetail_orderno;
	private String orderdetail_picture;
	private String orderdetail_product;
	private int orderdetail_quantity;
	private int orderdetail_price;   
	
	
    
	public String getProduct_detailpicture() {
		return product_detailpicture;
	}
	public void setProduct_detailpicture(String product_detailpicture) {
		this.product_detailpicture = product_detailpicture;
	}
	public int getOrderdetail_quantity() {
		return orderdetail_quantity;
	}
	public void setOrderdetail_quantity(int orderdetail_quantity) {
		this.orderdetail_quantity = orderdetail_quantity;
	}
	public int getOrderdetail_price() {
		return orderdetail_price;
	}
	public void setOrderdetail_price(int orderdetail_price) {
		this.orderdetail_price = orderdetail_price;
	}
	public int getOrderdetail_orderno() {
		return orderdetail_orderno;
	}
	public void setOrderdetail_orderno(int orderdetail_orderno) {
		this.orderdetail_orderno = orderdetail_orderno;
	}
	public int getCart_quantity() {
		return cart_quantity;
	}
	public void setCart_quantity(int cart_quantity) {
		this.cart_quantity = cart_quantity;
	}
	public String getProduct_rdate() {
		return product_rdate;
	}
	public int getOrderdetail_no() {
		return orderdetail_no;
	}
	public void setOrderdetail_no(int orderdetail_no) {
		this.orderdetail_no = orderdetail_no;
	}
	public String getOrderdetail_product() {
		return orderdetail_product;
	}
	public void setOrderdetail_product(String orderdetail_product) {
		this.orderdetail_product = orderdetail_product;
	}
	public String getOrderdetail_picture() {
		return orderdetail_picture;
	}
	public void setOrderdetail_picture(String orderdetail_picture) {
		this.orderdetail_picture = orderdetail_picture;
	}
	public void setProduct_rdate(String product_rdate) {
		this.product_rdate = product_rdate;
	}
	public String getOrder_name() {
		return order_name;
	}
	public void setOrder_name(String order_name) {
		this.order_name = order_name;
	}
	public String getOrder_address() {
		return order_address;
	}
	public void setOrder_address(String order_address) {
		this.order_address = order_address;
	}
	public String getOrder_tel() {
		return order_tel;
	}
	public void setOrder_tel(String order_tel) {
		this.order_tel = order_tel;
	}
	public int getCart_productno() {
		return cart_productno;
	}
	public void setCart_productno(int cart_productno) {
		this.cart_productno = cart_productno;
	}
	public int getCart_no() {
		return cart_no;
	}
	public void setCart_no(int cart_no) {
		this.cart_no = cart_no;
	}
	public String getCart_user() {
		return cart_user;
	}
	public void setCart_user(String cart_user) {
		this.cart_user = cart_user;
	}
	public String getCart_product() {
		return cart_product;
	}
	public void setCart_product(String cart_product) {
		this.cart_product = cart_product;
	}
	public String getCart_picture() {
		return cart_picture;
	}
	public void setCart_picture(String cart_picture) {
		this.cart_picture = cart_picture;
	}
	public int getCart_price() {
		return cart_price;
	}
	public void setCart_price(int cart_price) {
		this.cart_price = cart_price;
	}
	public int getOrder_no() {
		return order_no;
	}
	public void setOrder_no(int order_no) {
		this.order_no = order_no;
	}
	public String getOrder_user() {
		return order_user;
	}
	public void setOrder_user(String order_user) {
		this.order_user = order_user;
	}
	public String getOrder_status() {
		return order_status;
	}
	public void setOrder_status(String order_status) {
		this.order_status = order_status;
	}
	public String getOrder_date() {
		return order_date;
	}
	public void setOrder_date(String order_date) {
		this.order_date = order_date;
	}
	public int getProduct_no() {
		return product_no;
	}
	public void setProduct_no(int product_no) {
		this.product_no = product_no;
	}
	public String getProduct_name() {
		return product_name;
	}
	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}
	public String getProduct_picture() {
		return product_picture;
	}
	public void setProduct_picture(String product_picture) {
		this.product_picture = product_picture;
	}
	public String getProduct_display() {
		return product_display;
	}
	public void setProduct_display(String product_display) {
		this.product_display = product_display;
	}
	public String getProduct_capacity() {
		return product_capacity;
	}
	public void setProduct_capacity(String product_capacity) {
		this.product_capacity = product_capacity;
	}
	public String getProduct_camera() {
		return product_camera;
	}
	public void setProduct_camera(String product_camera) {
		this.product_camera = product_camera;
	}
	public String getProduct_color() {
		return product_color;
	}
	public void setProduct_color(String product_color) {
		this.product_color = product_color;
	}
	public String getProduct_ram() {
		return product_ram;
	}
	public void setProduct_ram(String product_ram) {
		this.product_ram = product_ram;
	}
	public String getProduct_weight() {
		return product_weight;
	}
	public void setProduct_weight(String product_weight) {
		this.product_weight = product_weight;
	}
	public String getProduct_battery() {
		return product_battery;
	}
	public void setProduct_battery(String product_battery) {
		this.product_battery = product_battery;
	}
	public int getProduct_price() {
		return product_price;
	}
	public void setProduct_price(int product_price) {
		this.product_price = product_price;
	}

	
}
