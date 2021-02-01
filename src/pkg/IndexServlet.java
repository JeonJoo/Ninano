package pkg;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/IndexServlet1")
public class IndexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		response.getWriter().append("GET호출").append(request.getContextPath());
		
		// 꽃 사진 크롤링
		FlowerCraw flr = new FlowerCraw();
		ArrayList<HashMap<String, String>> list = flr.getFlower("https://mall.epost.go.kr/display/viewMCategory.do?ctgryCd=112201000");
//		System.out.println(list.size());
//		System.out.println(list);
	
		request.setAttribute("FLOWER_LIST", list);
		request.getRequestDispatcher("/index.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
