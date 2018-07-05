package net.joastbg.sampleapp.dao;

import java.util.List;
import net.joastbg.sampleapp.interfaces.AssuranceInterface;
import net.joastbg.sampleapp.entities.Contact;
import net.joastbg.sampleapp.entities.Echeances;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class EcheancesDao {

    @Autowired
    SessionFactory sessionFactory;

    public int persist(Echeances echeance){
        Session session = sessionFactory.getCurrentSession();
        int returnID = (int) session.save(echeance);
        return returnID;
    }

    public Echeances find(int idEcheance){
        Session session= sessionFactory.getCurrentSession();
        return (Echeances) session.load(Echeances.class, idEcheance);
    }

    public void delete(Echeances echeance){
        Session session= sessionFactory.getCurrentSession();
        session.delete(echeance);
    }
    
   public List<Echeances> feature7(AssuranceInterface a, String month1, String month2) {
        Session session= sessionFactory.getCurrentSession();
        Query q = session.createQuery("FROM Echeances WHERE to_char(issueDate, 'MM') >= :month1 AND to_char(issueDate, 'MM') <= :month2 AND assurance = :a");
        q.setParameter("month1", month1);
        q.setParameter("month2", month2);
        q.setParameter("a", a);
        return q.list();
   }
}
