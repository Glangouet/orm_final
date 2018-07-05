package net.joastbg.sampleapp.dao;

import java.util.Date;
import net.joastbg.sampleapp.entities.Client;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import net.joastbg.sampleapp.entities.PersonnePhysique;
import org.hibernate.Query;

@Service
@Transactional
public class ClientDao {

    @Autowired
    SessionFactory sessionFactory;

    public int persist(Client client){
        Session session = sessionFactory.getCurrentSession();
        return (int) session.save(client);
    }

    public List<Client> findAll(){
        Session session = sessionFactory.getCurrentSession();
        return  session.createQuery("SELECT * from CLIENT").list();
    }
    
    public List<PersonnePhysique> findAllPersonnePhysique() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("FROM PersonnePhysique").list();
    }
    
    public void delete(Client client) {
        Session session= sessionFactory.getCurrentSession();
        session.delete(client);
    }
    
    public List<PersonnePhysique> feature10(String month1, String month2) {
        Session session = sessionFactory.getCurrentSession();
        Query q = session.createQuery("FROM PersonnePhysique WHERE to_char(birthDate, 'MM') >= :month1 AND to_char(birthDate, 'MM') <= :month2");
        q.setParameter("month1", month1);
        q.setParameter("month2", month2);
        
        return q.list();
    }
}
