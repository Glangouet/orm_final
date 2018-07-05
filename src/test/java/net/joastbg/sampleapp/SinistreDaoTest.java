package net.joastbg.sampleapp;


import java.util.Date;
import junit.framework.Assert;
import net.joastbg.sampleapp.dao.AssuranceDao;
import net.joastbg.sampleapp.dao.ContactDao;
import net.joastbg.sampleapp.dao.SinistreDao;
import net.joastbg.sampleapp.entities.Assurance;
import net.joastbg.sampleapp.entities.AssuranceHabitat;
import net.joastbg.sampleapp.entities.CompteBancaire;
import net.joastbg.sampleapp.entities.Contact;
import net.joastbg.sampleapp.entities.Sinistre;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

@TransactionConfiguration(transactionManager="transactionManager", defaultRollback=false)
@Transactional
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/spring/config/BeanLocations.xml")
public class SinistreDaoTest {


    @Autowired
    SinistreDao sinistreDao;
    
    @Autowired
    AssuranceDao assuranceDao;

    Sinistre sinistre;
    
    AssuranceHabitat assuranceHabitat;

    @Before
    public void setUp() {
        assuranceHabitat = new AssuranceHabitat();
        assuranceHabitat.setAddress("Hello");
        assuranceHabitat.setBirthDate(new Date());
        assuranceHabitat.setCoverValue(2000);
        assuranceHabitat.setDraftDate(new Date());
        assuranceHabitat.setSubscriptionDate(new Date());
        assuranceHabitat.setTypeAssurance("HABITAT");
        
        sinistre = new Sinistre();
        sinistre.setDate(new Date());
        sinistre.setDescription("Hello");
        sinistre.setTitre("World");
    }

    @Test
    public void testPersist(){
        
        System.out.println("TEST PERSSIST SINISTRE");
        
        int ida = assuranceDao.persist(assuranceHabitat);
        Assurance assuranceFound = assuranceDao.find(ida);
        
        sinistre.setIdAssurance(assuranceFound);
        int id = (int) sinistreDao.persist(sinistre);
        Assert.assertTrue(id > -1);
        
        Sinistre s = sinistreDao.find(id);
        System.out.println("idAssurance: " + s.getIdAssurance().getIdAssurance() + ", TITRE: " + s.getTitre() + ", DESCRIPRION: " + s.getDescription());
        
        sinistreDao.delete(sinistre);
        
        System.out.println("FIN TEST PERSSIST SINISTRE");
    }

}
