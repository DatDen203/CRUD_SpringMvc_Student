package Test.ConnetcMysql.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.StudentDao;
import Models.StudentDTO;

import javax.servlet.annotation.WebServlet;

@WebServlet(urlPatterns = "/update")
public class UpdateStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id_res = request.getParameter("id");
		StudentDao dao = new StudentDao();
		try {
			int id = Integer.parseInt(id_res);
			StudentDTO obj = dao.getIdStudent(id);
			request.setAttribute("dataStudent", obj);
			request.getRequestDispatcher("update.jsp").forward(request, response);
		} catch (NumberFormatException e) {
			System.out.println(e);
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
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
			StudentDTO newStudent = new StudentDTO(id, name, classStudent, ageNew);
			dao.update(newStudent);
			response.sendRedirect("list");
		} catch (NumberFormatException e) {
			System.out.println(e);
		}
	}

}
