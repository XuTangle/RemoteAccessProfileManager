package domain;

import java.util.Date;

/**
 * This is a bean that encapsulates student information
 * @author situh
 *
 */
public class Student {
	
	// The class members names need to be identical to the MySQL table. This is necessary for DBUtils to load the information properly. 
	private int sid;
	private String sname;
	private String gender;
	private String phone;
	private Date birthday;
	private String hobby;
	private String info;

	// This parameterless constructor must be defined here, because BeanListHandler needs to call the parameterless constructor.
	public Student() {
		super();
	}
	
	// The constructor that's actually call when UPDATING student profiles
	public Student(int sid, String sname, String gender, String phone, Date birthday, String hobby, String info) {
		super();
		this.sid = sid;
		this.sname = sname;
		this.gender = gender;
		this.phone = phone;
		this.birthday = birthday;
		this.hobby = hobby;
		this.info = info;
	}
	
	// The constructor that's actually call when ADDING student profiles
	public Student(String sname, String gender, String phone, Date birthday, String hobby, String info) {
		super();
		this.sname = sname;
		this.gender = gender;
		this.phone = phone;
		this.birthday = birthday;
		this.hobby = hobby;
		this.info = info;
	}
	
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getHobby() {
		return hobby;
	}
	public void setHobby(String hobby) {
		this.hobby = hobby;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	
}
