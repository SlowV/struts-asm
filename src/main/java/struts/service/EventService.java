package struts.service;

import org.hibernate.Session;
import org.hibernate.Transaction;
import struts.entity.Event;
import struts.util.HibernateUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class EventService {
    private static Logger LOGGER = Logger.getLogger(EventService.class.getSimpleName());

    public boolean save(Event event) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSession()) {
            transaction = session.beginTransaction();
            session.saveOrUpdate(event);
            transaction.commit();
            System.out.println("Save thanh cong!");
            return true;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        }

        return false;
    }

    public List<Event> findAll() {
        try (Session session = HibernateUtil.getSession()) {
            return (List<Event>) session.createSQLQuery("SELECT * FROM Event").addEntity(Event.class).list();
        } catch (Exception e) {

        }
        return new ArrayList<>();
    }

    public void deleteById(String id) {
        LOGGER.warning("da chay vao ham delete service");
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        Event event = session.get(Event.class, id);
        System.out.println(id);
        System.out.println(event.toString());
        session.delete(event);
        session.getTransaction().commit();
        LOGGER.warning("xoa thanh cong");
    }

    public Event findOne(String id) {
        Session session = HibernateUtil.getSession();
        Event event  = session.get(Event.class, id);
        if (event != null) {
            return event;
        }
        return null;
    }
}
