package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.Student;
import service.StudentService;
import service.impl.StudentServiceImpl;

/**
 * Servlet implementation class SearchStudentServlet
 */
@WebServlet("/SearchStudentServlet")
public class SearchStudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		try {
			// 1. Obtain the 2 key fields: gender and name
			String sname = request.getParameter("sname");
			String sgender = request.getParameter("sgender");
			
			// 2. Submit request to Service
			StudentService service = new StudentServiceImpl();
			List<Student> list = service.findStudent(sname, sgender);
			
			// 3. Jump
			request.setAttribute("list", list);
			request.getRequestDispatcher("list.jsp").forward(request, response);
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
