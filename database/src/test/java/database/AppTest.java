package database;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import blog.database.HibernateConfiguration;
import blog.database.student.Student;
import blog.database.studentdao.StudentDao;



@SpringJUnitConfig(classes=HibernateConfiguration.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class AppTest
{
	@Autowired
	Student student;
	
	@Autowired
	StudentDao studentDao;
	
	@Before
	public void setUp()
	{
		student.setStudent_name("renuka");
		student.setStudent_mobile("9885249966");
		student.setStudent_email("renuka@gmail.com");
		student.setStudent_password("vadla");
		student.setRole("student");
	}
	@Test
	public void addStudent()
	{
		assertEquals("addUser() testcase failed", true, studentDao.addStudent(student));
	}
	@Test
	public void getStudentById()
	{
		studentDao.addStudent(student);
		System.out.println(student.getStudent_id());
		assertEquals("getUserById() testcase failed", student, studentDao.getStudentById(student.getStudent_id()));
	}
	@After
	public void deleteStudent()
	{
		if(studentDao.getStudentById(student.getStudent_id())!=null)
		{
			assertEquals("deleteStudent() testcase failed", true, studentDao.deleteStudent(student));
		}
	}
}