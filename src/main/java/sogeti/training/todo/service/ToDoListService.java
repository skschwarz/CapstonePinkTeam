package sogeti.training.todo.service;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import sogeti.training.todo.model.ToDoList;

import java.util.List;

@Component
public class ToDoListService extends BaseService {

	@Autowired
	private SessionFactory sessionFactory;

	public List<ToDoList> getLists() throws Exception {
		Session session = null;
		try {
			session = sessionFactory.openSession();
			return session.createCriteria(ToDoList.class).list();
 		}
		finally {
			session.close();
		}
	}
	
	public List<ToDoList> getListsForUser(int id) {
		Session session = null;
		try {
			session = sessionFactory.openSession();
			
			Criteria criteria = session.createCriteria(ToDoList.class, "l");
			criteria.createAlias("l.users", "u");
			criteria.add(Restrictions.eq("u.id", id));
			criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
			
			return criteria.list();
 		}
		finally {
			session.close();
		}
	}
	
	public ToDoList getList(int id) throws Exception {
		Session session = null;
		try {
			session = sessionFactory.openSession();
			return (ToDoList) session.get(ToDoList.class, id);
 		}
		finally {
			session.close();
		}
	}
	
	public void deleteList(int id) throws Exception {
		Session session = null;
		try {
			session = sessionFactory.openSession();
			ToDoList list = (ToDoList) session.get(ToDoList.class, id);
			Transaction t = session.beginTransaction();
			session.delete(list);
			t.commit();
			session.flush();
 		}
		finally {
			session.close();
		}
	}	
}
