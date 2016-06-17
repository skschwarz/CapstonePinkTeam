package sogeti.training.todo.service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import sogeti.training.todo.model.User;

import java.util.List;

@Component
public class UserService extends BaseService {

	@Autowired
	private SessionFactory sessionFactory;

	public List<User> getUsers() throws Exception {
		Session session = null;
		try {
			session = sessionFactory.openSession();
			return session.createCriteria(User.class).list();
 		}
		finally {
			session.close();
		}
	}
	
	public User getUser(int id) throws Exception {
		Session session = null;
		try {
			session = sessionFactory.openSession();
			User user = (User) session.get(User.class, id);
			return user;
 		}
		finally {
			session.close();
		}
	}
	
	public void deleteUser(int id) throws Exception {
		Session session = null;
		try {
			session = sessionFactory.openSession();
			User user = (User) session.get(User.class, id);
			Transaction t = session.beginTransaction();
			session.delete(user);
			t.commit();		
			session.flush();
 		}
		finally {
			session.close();
		}
	}
}
