package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.Student;
import service.StudentService;
import service.impl.StudentServiceImpl;

/**
 * Used to add student profiles
 */
@WebServlet("/AddServlet")
public class AddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.setCharacterEncoding("UTF-8");
		
		
		try {  
			// 1. Obtain the data submitted by client
			String sname = req.getParameter("sname");
			String gender = req.getParameter("gender");
			String phone = req.getParameter("phone");
			String birthdayString = req.getParameter("birthday");
			
			// Note: getParameterValues() will encapsulate all the checked items in a specific field into an array
			String hobby = Arrays.toString(req.getParameterValues("hobby"));
			hobby = hobby.substring(1, hobby.length()-1);
			String info = req.getParameter("info");
			
			// 2. Add them to the database via the StudentServiceImpl class
			Date birthday;
			birthday = new SimpleDateFormat("yyyy-mm-dd").parse(birthdayString);
			Student s = new Student(sname, gender, phone, birthday , hobby, info);
			StudentService service = new StudentServiceImpl();
			service.insert(s);
			
			// 3. Jump to the student list page
			req.getRequestDispatcher("StudentListServlet").forward(req, resp);
			
		} catch (Exception e) {
			
			PrintWriter writer = resp.getWriter();
			writer.println("Error occurred when adding data");
			writer.flush(); // is this needed?
			e.printStackTrace();
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
