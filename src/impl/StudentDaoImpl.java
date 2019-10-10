package impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import dao.StudentDao;
import domain.PageBean;
import domain.Student;
import util.JDBCUtil;

/**
 * The implementation of StudentDao. All the functions are actually realized in this class.
 * @author situh
 *
 */
public class StudentDaoImpl implements StudentDao {

	final int PAGE_SIZE = 3;
	
	@Override
	public List<Student> findAll() throws SQLException {
		QueryRunner runner = new QueryRunner(JDBCUtil.getDataSource());
		List<Student> list = runner.query("select * from students", new BeanListHandler<Student>(Student.class));
		return list;
	}

	@Override
	public void insert(Student s) throws SQLException {
		QueryRunner runner = new QueryRunner(JDBCUtil.getDataSource());
		runner.update("insert into students values(null, ?, ?, ?, ?, ?, ?);" , 
				s.getSname(),
				s.getGender(),
				s.getPhone(),
				s.getBirthday(),
				s.getHobby(),
				s.getInfo()
				);
	}

	@Override
	public void delete(int sid) throws SQLException {
		QueryRunner runner = new QueryRunner(JDBCUtil.getDataSource());
		runner.update("delete from students where sid = ?", sid );
	}

	@Override
	public Student findStudentById(int sid) throws SQLException {
		QueryRunner runner = new QueryRunner(JDBCUtil.getDataSource());
		Student student = runner.query("select * from students where sid =? ;", new BeanHandler<Student>(Student.class), sid);
		return student;
	}

	@Override
	public void update(Student s) throws SQLException {
		QueryRunner runner = new QueryRunner(JDBCUtil.getDataSource());
		runner.update("update students set sname=?, gender=?, phone=?, birthday=?, hobby=?, info=? where sid=?" , 
				s.getSname(),
				s.getGender(),
				s.getPhone(),
				s.getBirthday(),
				s.getHobby(),
				s.getInfo(),
				s.getSid()
				);
	}

	@Override
	public List<Student> findStudent(String sname, String sgender) throws SQLException {
		QueryRunner runner = new QueryRunner(JDBCUtil.getDataSource());
		BeanListHandler<Student> handler = new BeanListHandler<Student>(Student.class);
		
		//Search students according to how many fields are specified: 1. both; 2. gender; 3. name; 4. neither -> return all students.
		String sql = "select * from students ";
		if (!sname.equals("") && !sgender.equals("")) {
			sql += "where sname like ? and gender = ?;";
			return runner.query(sql, handler, "%"+sname+"%", sgender); //%word% means containing
		}
		else if (!sgender.equals("")) {
			sql += "where gender = ?;";
			return runner.query(sql, handler, sgender);
		}
		else if (!sname.equals("")) {
			sql += "where sname like ?;" ;
			return runner.query(sql, handler, "%"+sname+"%");
		}
		else {
			sql += ";";
			return runner.query(sql, handler);
		}
	}

	@Override
	public PageBean findStudentByPage(int page) throws SQLException {
		QueryRunner runner = new QueryRunner(JDBCUtil.getDataSource());
		List<Student> list = runner.query("select * from students order by sid limit ? offset ?", 
				new BeanListHandler<Student>(Student.class),
				PAGE_SIZE, PAGE_SIZE*(page-1) );
		
		int totalSize =  runner.query("select * from students;",new BeanListHandler<Student>(Student.class)).size();
		int totalPage = (totalSize%PAGE_SIZE ==0) ? totalSize/PAGE_SIZE : (totalSize/PAGE_SIZE)+1 ;
		return new PageBean(page, totalPage, PAGE_SIZE, totalSize, list);
	}

}
