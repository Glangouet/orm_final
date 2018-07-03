package net.joastbg.sampleapp.dao;

import net.joastbg.sampleapp.entities.Contact;
import net.joastbg.sampleapp.entities.Sinistre;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class SinistreDao {

    @Autowired
    SessionFactory sessionFactory;

    public int persist(Sinistre sinistre){
        Session session = sessionFactory.getCurrentSession();
        int returnID = (int) session.save(sinistre);
        return returnID;
    }


    public Sinistre find(int idSinistre){
        Session session= sessionFactory.getCurrentSession();
        return (Sinistre) session.load(Sinistre.class, idSinistre);
    }

    public void delete(Sinistre sinistre){
        Session session= sessionFactory.getCurrentSession();
        session.delete(sinistre);
    }
}
