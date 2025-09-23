package edu.ijse.learners.dao.custom.impl;

import edu.ijse.learners.configuration.FactoryConfiguration;
import edu.ijse.learners.dao.custom.LessonsDAO;
import edu.ijse.learners.entity.Lesson;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;
import java.util.Optional;

public class LessonDAOImpl implements LessonsDAO {

    private final FactoryConfiguration factoryConfiguration = FactoryConfiguration.getInstance();

    @Override
    public List<Lesson> getAll() throws Exception {
        Session session = factoryConfiguration.getSession();
        try {
            Query<Lesson> query = session.createQuery("from Lessons ",Lesson.class);
            List<Lesson> lessonsList = query.list();
            return lessonsList;
        }finally {
            session.close();
        }
    }

    @Override
    public String getLastId() throws Exception {
        Session session = factoryConfiguration.getSession();
        try {
            Query<String> query = session.createQuery("SELECT l.lessonId FROM Lessons l ORDER BY l.lessonId DESC", String.class)
                    .setMaxResults(1);
            List<String> lessonsList = query.list();
            if (lessonsList.isEmpty()) {
                return null;
            }
            return lessonsList.getFirst();
        } finally {
            session.close();
        }
    }

    @Override
    public boolean save(Lesson lesson) throws Exception {
        Session session = factoryConfiguration.getSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.persist(lesson);
            transaction.commit();
            return true;
        }catch (Exception e){
            transaction.rollback();
            return false;
        }finally {
            session.close();
        }
    }

    @Override
    public boolean update(Lesson lesson) throws Exception {
        Session session = factoryConfiguration.getSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.merge(lesson);
            transaction.commit();
            return true;
        }catch (Exception e){
            transaction.rollback();
            return false;
        }finally {
            session.close();
        }
    }

    @Override
    public boolean delete(String id) throws Exception {
        Session session = factoryConfiguration.getSession();
        Transaction transaction = session.beginTransaction();
        try {
            Lesson lessons = (Lesson) session.get(Lesson.class, id);
            if (lessons != null) {
                session.remove(lessons);
                transaction.commit();
                return true;
            }
            return false;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
            return false;
        } finally {
            session.close();
        }
    }

    @Override
    public List<String> getAllIds() throws Exception {
        Session session = factoryConfiguration.getSession();
        try {
            Query<String> query = session.createQuery("SELECT l.lessonId FROM Lessons l", String.class);
            return query.list();
        } finally {
            session.close();
        }
    }

    @Override
    public Optional<Lesson> findById(String id) throws Exception {
        Session session = factoryConfiguration.getSession();
        try {
            Lesson lessons = session.get(Lesson.class, id);
            return Optional.ofNullable(lessons);
        } finally {
            session.close();
        }
    }

    @Override
    public String generateNewId() {
        String lastId = null;
        try {
            lastId = getLastId();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        if (lastId == null) {
            return "L-001";
        } else {
            int num = Integer.parseInt(lastId.split("-")[1]);
            num++;
            return String.format("L-%03d", num);
        }
    }
}
