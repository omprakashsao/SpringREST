package in.ops.om.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import in.ops.om.bean.Student;
import in.ops.om.exception.StudentNotFoundException;
import in.ops.om.model.IStudentRepo;

@Service
public class StudentServiceImpl implements IStudentService {
	
	@Autowired
	private IStudentRepo repo;

	
	@Override
	@Cacheable(value="student", key = "#id")
	public Student getStudentById(Integer id) {
		// TODO Auto-generated method stub
		Optional<Student> optional = repo.findById(id);
		if(optional.isEmpty()) {
			throw new StudentNotFoundException("STUDENT IS NOT EXIST FOR GIVEN ID : "+id);
		}	
		return optional.get();
	}

	@Override
	public List<Student> getAllStudents() {
		return repo.findAll();
	}

	@Override
	@CachePut(value="student", key = "#id")
	public void updateStudent(Student s) {
		// TODO Auto-generated method stub
		if( s.getStdId() == null || !repo.existsById(s.getStdId()) ) {
		       throw new StudentNotFoundException("STUDENT NOT EXIST FOR ID : " + s.getStdId()+" FOR UPDATION ");
		}
		else repo.save(s);
		
	}

	@Override
	@CacheEvict(value = "student", allEntries = true)
	public void deleteStudent(Integer id) {
		// TODO Auto-generated method stub
		repo.delete(getStudentById(id));;
		
	}

	@Override
	public Integer saveStudent(Student s) {
		Student student = repo.save(s);
		return student.getStdId();
		
	}

	

	
	


}
