package dao.product;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import dao.Action;

public class ProductUpdateService implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");

		

		 String savePath ="/images/product/\\"; //업로드 폴더
	      int maxPostSize = 20*1024*1024;//최대 업로드 용량
	      String enctype = "utf-8";//인코딩 문자
	      
	      ServletContext context = request.getServletContext();
	      String path = context.getRealPath(savePath);
	      System.out.println("서버상의 업로드 실제 디렉토리: " + path); 
	      
	      
	      //공지사항 처럼 저장하려면 요청 (request.getParameter())을 해야 하는데
	      //첨부파일 처리할 떄는 COS.JAR에서 제공해주는 MultipartReqeust 객체로 요청을 해야한다.
	      
	      // file upload 처리 ==> 첨부처리 완료
	      MultipartRequest multi = new MultipartRequest(
	            request,
	            path,
	            maxPostSize,
	            enctype,
	            new DefaultFileRenamePolicy()// 같은 파일을 또 업로드 했을 경우 덮어씌기가 아니라 이름을 변경해서 새로 업로드시키는 방식.
	            );
	      
	      //업로드된 파일명을 구하기 ==> MultipartRequest 객체를 이용한다.
	      
			int product_no = Integer.parseInt(multi.getParameter("product_no"));
			System.out.println(product_no);
	     String name = multi.getParameter("product_name");
			String picture = multi.getFilesystemName("product_picture");
			String display = multi.getParameter("product_display");
			String capacity = multi.getParameter("product_capacity");
			String camera = multi.getParameter("product_camera");
			String color = multi.getParameter("product_color");
			String ram = multi.getParameter("product_ram");
			String weight = multi.getParameter("product_weight");
			String battery = multi.getParameter("product_battery");
			int price = Integer.parseInt(multi.getParameter("product_price"));
			String rdate = multi.getParameter("product_rdate");
		
		ProductVo vo = new ProductVo();
		vo.setProduct_name(name);
		vo.setProduct_picture(picture);
		vo.setProduct_display(display);
		vo.setProduct_capacity(capacity);
		vo.setProduct_camera(camera);
		vo.setProduct_color(color);
		vo.setProduct_ram(ram);
		vo.setProduct_weight(weight);
		vo.setProduct_battery(battery);
		vo.setProduct_price(price);
		vo.setProduct_rdate(rdate);
		
		ProductDao dao = new ProductDao();
		dao.updateProduct(vo, product_no);
		
	}

}
