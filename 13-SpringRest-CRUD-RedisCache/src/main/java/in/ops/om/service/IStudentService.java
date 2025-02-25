package in.ops.om.service;

import java.util.List;

import in.ops.om.bean.Student;

public interface IStudentService {
	
	//insert
	public Integer saveStudent(Student s );
	
	//select
	public Student getStudentById(Integer id);
	
	//select all 
	public List<Student> getAllStudents();
	
	//update student
	public void updateStudent(Student s);
	
	//delete student
	public void deleteStudent(Integer id);
}
