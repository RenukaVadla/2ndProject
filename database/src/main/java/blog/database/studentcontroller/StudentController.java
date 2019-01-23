package blog.database.studentcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import blog.database.student.Student;
import blog.database.studentdao.StudentDao;


@RestController
@CrossOrigin(origins = "*",allowedHeaders= {"*"})
public class StudentController {
	
	@Autowired
	StudentDao studentDao;
	
	@PostMapping("/addStudent")
	public String getStudentForm(@RequestBody Student student)
	{
		if(studentDao.getStudentByEmail(student.getStudent_email())!=null)
		{
			return "student already Exists";
		}
		else
		{
			if(studentDao.addStudent(student))
			{
				return "student add";
			}else
			{
				return "student not add";
			}
		}
			
		
	}
	
	
}

