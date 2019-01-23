package blog.database.student;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.stereotype.Component;

@Entity
@Component("Student")
public class Student {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int student_id;
	private String student_name;
	private String student_mobile;
	private String student_email;
	private String student_password;
	private String role="student";
	
	public int getStudent_id() {
		return student_id;
	}
	public void setStudent_id(int student_id) {
		this.student_id = student_id;
	}
	public String getStudent_name() {
		return student_name;
	}
	public void setStudent_name(String student_name) {
		this.student_name = student_name;
	}
	public String getStudent_mobile() {
		return student_mobile;
	}
	public void setStudent_mobile(String student_mobile) {
		this.student_mobile = student_mobile;
	}
	public String getStudent_email() {
		return student_email;
	}
	public void setStudent_email(String student_email) {
		this.student_email = student_email;
	}
	public String getStudent_password() {
		return student_password;
	}
	public void setStudent_password(String student_password) {
		this.student_password = student_password;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((role == null) ? 0 : role.hashCode());
		result = prime * result + ((student_email == null) ? 0 : student_email.hashCode());
		result = prime * result + student_id;
		result = prime * result + ((student_mobile == null) ? 0 : student_mobile.hashCode());
		result = prime * result + ((student_name == null) ? 0 : student_name.hashCode());
		result = prime * result + ((student_password == null) ? 0 : student_password.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		if (role == null) {
			if (other.role != null)
				return false;
		} else if (!role.equals(other.role))
			return false;
		if (student_email == null) {
			if (other.student_email != null)
				return false;
		} else if (!student_email.equals(other.student_email))
			return false;
		if (student_id != other.student_id)
			return false;
		if (student_mobile == null) {
			if (other.student_mobile != null)
				return false;
		} else if (!student_mobile.equals(other.student_mobile))
			return false;
		if (student_name == null) {
			if (other.student_name != null)
				return false;
		} else if (!student_name.equals(other.student_name))
			return false;
		if (student_password == null) {
			if (other.student_password != null)
				return false;
		} else if (!student_password.equals(other.student_password))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Student [student_id=" + student_id + ", student_name=" + student_name + ", student_mobile="
				+ student_mobile + ", student_email=" + student_email + ", student_password=" + student_password
				+ ", role=" + role + "]";
	}
	
	}

