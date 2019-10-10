package service.impl;

import java.sql.SQLException;
import java.util.List;

import dao.StudentDao;
import domain.PageBean;
import domain.Student;
import impl.StudentDaoImpl;
import service.StudentService;

public class StudentServiceImpl implements StudentService{

	@Override
	public List<Student> findAll() throws SQLException {
		
		StudentDao dao = new StudentDaoImpl();
		return dao.findAll();
	}

	@Override
	public void insert(Student s) throws SQLException {
		StudentDao dao = new StudentDaoImpl();
		dao.insert(s);
	}

	@Override
	public void delete(int sid) throws SQLException {
		StudentDao dao = new StudentDaoImpl();
		dao.delete(sid);
		
	}

	@Override
	public Student findStudentById(int sid) throws SQLException {
		StudentDao dao = new StudentDaoImpl();
		return dao.findStudentById(sid);
	}

	@Override
	public void update(Student s) throws SQLException {
		StudentDao dao = new StudentDaoImpl();
		dao.update(s);
	}

	@Override
	public List<Student> findStudent(String sname, String sgender) throws SQLException {
		StudentDao dao = new StudentDaoImpl();
		return dao.findStudent(sname, sgender);
	}

	@Override
	public PageBean findStudentByPage(int page) throws SQLException {
		StudentDao dao = new StudentDaoImpl();
		return dao.findStudentByPage(page);
	}
	
}
