package blog.database.studentdaoimp;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import blog.database.student.Student;
import blog.database.studentdao.StudentDao;




@Component
@Transactional
public class StudentDaoImp implements StudentDao{
	
	@Autowired
	SessionFactory sessionFactory;

	

	public boolean addStudent(Student student) {
		// TODO Auto-generated method stub
		try {
			sessionFactory.getCurrentSession().save(student);
			return true;
			
		}catch (Exception e) {
			// TODO: handle exception
			return false;
		}
	}

	public boolean deleteStudent(Student student) {
		// TODO Auto-generated method stub
		try {
			sessionFactory.getCurrentSession().delete(student);
			return true;
		}catch (Exception e) {
			// TODO: handle exception
			return false;
		}
	}

	public Student getStudentById(int student_id) {
		try {
			Query<Student> query=sessionFactory.getCurrentSession().createQuery("from Student where student_id=:student_id",Student.class);
			query.setParameter("student_id", student_id);
			return query.getSingleResult();
			}catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
				return null;
			}
	}

	public Student getStudentByEmail(String student_email) {
		try {
			Query<Student> query=sessionFactory.getCurrentSession().createQuery("from Student where student_email=:student_email",Student.class);
			query.setParameter("student_email", student_email);
			return query.getSingleResult();
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}
		
	}

	}

