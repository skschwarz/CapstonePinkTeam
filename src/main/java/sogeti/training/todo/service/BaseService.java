package sogeti.training.todo.service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by tkelley on 6/15/16.
 */
@Component
public class BaseService {

    @Autowired
    private SessionFactory sessionFactory;

    public void saveOrUpdate(Object o) {
        Session s = sessionFactory.openSession();
        Transaction t = s.beginTransaction();
        try{
            s.saveOrUpdate(o);
            t.commit();
        }
        finally{
            s.disconnect();
            s.close();
        }
    }

    public void save(Object o) {
        Session s = sessionFactory.openSession();
        Transaction t = s.beginTransaction();
        try{
            s.save(o);
            t.commit();
        }
        finally{
            s.disconnect();
            s.close();
        }
    }

    public void delete(Object o) {
        Session s = sessionFactory.openSession();
        Transaction t = s.beginTransaction();
        try{
            s.delete(o);
            t.commit();
        }
        finally{
            s.disconnect();
            s.close();
        }

    }

}
