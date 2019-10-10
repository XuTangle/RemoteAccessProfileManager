package service;

import java.sql.SQLException;
import java.util.List;

import domain.PageBean;
import domain.Student;

public interface StudentService {
	
	List<Student> findAll() throws SQLException; 
	
	List<Student> findStudent(String sname, String sgender) throws SQLException;
	
	PageBean findStudentByPage(int page) throws SQLException;
	
	void insert(Student s) throws SQLException;
	
	void delete(int sid) throws SQLException;
	
	Student findStudentById(int sid) throws SQLException;
	
	void update(Student s) throws SQLException;
	
}
