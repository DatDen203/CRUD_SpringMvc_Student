package Test.ConnetcMysql.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.StudentDao;
import Models.StudentDTO;

import javax.servlet.annotation.WebServlet;

@WebServlet(urlPatterns = "/list")
public class ListStudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ListStudentServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		StudentDao dao = new StudentDao();
		List<StudentDTO> list = dao.getAll();
		request.setAttribute("dataStudent", list);
		RequestDispatcher dispatcher= request.getRequestDispatcher("/WEB-INF/views/list.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
