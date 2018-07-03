package net.joastbg.sampleapp.dao;

import net.joastbg.sampleapp.entities.Assurance;
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

    public void delete(Assurance compteBancaire){
        Session session= sessionFactory.getCurrentSession();
        session.delete(compteBancaire);
    }
}