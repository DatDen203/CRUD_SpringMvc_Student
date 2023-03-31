package Test.ConnetcMysql.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.StudentDao;

import javax.servlet.annotation.WebServlet;

@WebServlet(urlPatterns="/delete")
public class DeleteStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id_res=request.getParameter("id");
		int id;
		try {
			id= Integer.parseInt(id_res);
			StudentDao  dao= new StudentDao();
			dao.delete(id);
			response.sendRedirect("list");
		} catch (Exception e) {
			
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
