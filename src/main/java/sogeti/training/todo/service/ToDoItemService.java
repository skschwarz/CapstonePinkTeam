package sogeti.training.todo.service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import sogeti.training.todo.model.ToDoItem;

import java.util.List;

@Component
public class ToDoItemService extends BaseService {

	@Autowired
	private SessionFactory sessionFactory;

	public List<ToDoItem> getToDoItems() throws Exception {
		Session session = null;
		try {
			session = sessionFactory.openSession();
			return session.createCriteria(ToDoItem.class).list();
 		}
		finally {
			session.close();
		}
	}
	
	public ToDoItem getToDoItem(int id) throws Exception {
		Session session = null;
		try {
			session = sessionFactory.openSession();
			return (ToDoItem) session.get(ToDoItem.class, id);
 		}
		finally {
			session.close();
		}
	}
	
	public void deleteToDoItem(int id) throws Exception {
		Session session = null;
		try {
			session = sessionFactory.openSession();
			ToDoItem item = (ToDoItem) session.get(ToDoItem.class, id);
			Transaction t = session.beginTransaction();
			session.delete(item);
			t.commit();
			session.flush();
 		}
		finally {
			session.close();
		}
	}
}
