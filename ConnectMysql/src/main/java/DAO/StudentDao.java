package DAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import ConnectSql.MySql;
import Models.StudentDTO;

public class StudentDao extends MySql {

	public List<StudentDTO> getAll() {
		List<StudentDTO> list = new ArrayList<>();
		String SQL_SELECT = "Select * from student";
		try {
			PreparedStatement st = conn.prepareStatement(SQL_SELECT);
			ResultSet resultSet = st.executeQuery();
			while (resultSet.next()) {
				int idStudent = resultSet.getInt("idStudent");
				int age = resultSet.getInt("age");
				String name = resultSet.getString("name");
				String classStudent = resultSet.getString("class");

				StudentDTO obj = new StudentDTO();

				obj.setIdStudent(idStudent);
				obj.setAge(age);
				obj.setClassStudent(classStudent);
				obj.setName(name);

				list.add(obj);
			}
		} catch (SQLException e) {
			System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}

	public StudentDTO getIdStudent(int id) {
		String SQL_SELECT = "Select * from student where idStudent=?";
		try {
			PreparedStatement st = conn.prepareStatement(SQL_SELECT);
			st.setInt(1, id);
			ResultSet resultSet = st.executeQuery();
			if (resultSet.next()) {

				int idStudent = resultSet.getInt("idStudent");
				int age = resultSet.getInt("age");
				String name = resultSet.getString("name");
				String classStudent = resultSet.getString("class");

				StudentDTO obj = new StudentDTO();

				obj.setIdStudent(idStudent);
				obj.setAge(age);
				obj.setClassStudent(classStudent);
				obj.setName(name);

				return obj;
			}
		} catch (SQLException e) {
			System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	public void insert(StudentDTO obj) {
		String sql = "INSERT INTO student (idStudent, name, age, class) VALUES (?,?,?,?)";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, obj.getIdStudent());
			ps.setString(2, obj.getName());
			ps.setInt(3, obj.getAge());
			ps.setString(4, obj.getClassStudent());
			
			ps.executeUpdate();
			
		} catch (SQLException e) {
			System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
		} catch (Exception e) {
			System.out.println(e);
		}

	}
	
	public void update(StudentDTO obj) {
		String sql = "update student set name=?,age=?,class=? where idStudent = ?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, obj.getName());
			ps.setInt(2, obj.getAge());
			ps.setString(3, obj.getClassStudent());
			ps.setInt(4, obj.getIdStudent());
			
			ps.executeUpdate();
			
		} catch (SQLException e) {
			System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
		} catch (Exception e) {
			System.out.println(e);
		}

	}
	
	public void delete(int id) {
		String sql="Delete from student where idStudent=?";
		try {
			PreparedStatement ps= conn.prepareStatement(sql);
			ps.setInt(1, id);
			ps.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
