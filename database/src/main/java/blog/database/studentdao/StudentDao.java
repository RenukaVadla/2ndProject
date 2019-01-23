package blog.database.studentdao;

import blog.database.student.Student;

public interface StudentDao {
	
	public abstract boolean addStudent(Student student);
	public abstract boolean deleteStudent(Student student);
	public abstract Student  getStudentById(int student_id);
	public abstract Student getStudentByEmail(String student_email);

}
