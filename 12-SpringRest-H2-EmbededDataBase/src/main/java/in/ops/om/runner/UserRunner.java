package in.ops.om.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import in.ops.om.bean.User;
import in.ops.om.dao.IUserRepo;

@Component
public class UserRunner implements ApplicationRunner {

	@Autowired
	private IUserRepo repo;
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		
		User user = new User();
		user.setAddress("bhiali");
		
		user.setName("om prakash");
	      repo.save(user);

	}

}
