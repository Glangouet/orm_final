package net.joastbg.sampleapp.dao;

import java.util.Date;
import java.util.List;
import net.joastbg.sampleapp.entities.Assurance;
import net.joastbg.sampleapp.interfaces.AssuranceInterface;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AssuranceDao {

    @Autowired
    SessionFactory sessionFactory;

    public int persist(Assurance assurance){
        Session session = sessionFactory.getCurrentSession();
        int returnID = (int) session.save(assurance);
        return returnID;
    }


    public Assurance find(int idAssurance){
        Session session= sessionFactory.getCurrentSession();
        return (Assurance) session.load(Assurance.class, idAssurance);
    }
    
    public List<AssuranceInterface> findAll(){
        Session session= sessionFactory.getCurrentSession();
        return session.createQuery("FROM Assurance").list();
    }

    public void delete(AssuranceInterface assurance){
        Session session= sessionFactory.getCurrentSession();
        session.delete(assurance);
    }
    
    public List<AssuranceInterface> findByDate() {
        Session session = sessionFactory.getCurrentSession();
        Query q = session.createQuery("FROM AssuranceAuto WHERE birthDate = :date");
        q.setParameter("date", new Date());
        return q.list();
    }
    
    public int deleteBybirthDate() {
        Session session = sessionFactory.getCurrentSession();
        Query q = session.createQuery("DELETE FROM Assurance WHERE birthDate = :date");
        q.setParameter("date", new Date());
        return q.executeUpdate();
    }
    
}