package Test.ConnetcMysql.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.StudentDao;
import Models.StudentDTO;

import javax.servlet.annotation.WebServlet;

@WebServlet(urlPatterns = "/add")
public class AddStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Get data from form
		String idStudent = request.getParameter("id");
		String name = request.getParameter("name");
		String age = request.getParameter("age");
		String classStudent = request.getParameter("class");
		int id, ageNew;
		StudentDao dao = new StudentDao();
		try {
			id = Integer.parseInt(idStudent);
			ageNew = Integer.parseInt(age);
			StudentDTO obj = dao.getIdStudent(id);
			if (obj == null) {
				StudentDTO newStudent = new StudentDTO(id, name, classStudent, ageNew);
				dao.insert(newStudent);
				response.sendRedirect("list");
				
			} else {
				request.setAttribute("err", "ID: " + id + " existed!!!");
				request.getRequestDispatcher("add.jsp").forward(request, response);
			}
			;
		} catch (NumberFormatException e) {
			System.out.println(e);
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
