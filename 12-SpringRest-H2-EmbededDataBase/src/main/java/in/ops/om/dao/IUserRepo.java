package in.ops.om.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import in.ops.om.bean.User;

public interface IUserRepo extends JpaRepository<User, Integer> {

}
