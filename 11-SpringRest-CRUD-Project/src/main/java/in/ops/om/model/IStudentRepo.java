package in.ops.om.model;

import org.springframework.data.jpa.repository.JpaRepository;

import in.ops.om.bean.Student;

public interface IStudentRepo extends JpaRepository<Student, Integer> {

}
