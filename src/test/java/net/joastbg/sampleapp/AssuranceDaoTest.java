package net.joastbg.sampleapp;

import java.util.Date;
import junit.framework.Assert;
import net.joastbg.sampleapp.dao.AssuranceDao;
import net.joastbg.sampleapp.dao.ClientDao;
import net.joastbg.sampleapp.entities.AssuranceAuto;
import net.joastbg.sampleapp.entities.AssuranceHabitat;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import net.joastbg.sampleapp.entities.PersonnePhysique;

@TransactionConfiguration(transactionManager="transactionManager", defaultRollback=false)
@Transactional
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/spring/config/BeanLocations.xml")
    public class AssuranceDaoTest {

    @Autowired
    AssuranceDao assuranceDao;
    
    @Autowired
    ClientDao clientDao;

    @Before
    public void setUp() {
    }

    @Test
    public void testPersist(){
        System.out.println("TEST CREATION DES ASSURANCES");
        
        PersonnePhysique r = new PersonnePhysique();
        r.setBirthDate(new Date());
        r.setFirstname("Guillaume");
        r.setLastname("Langouet");
        int idR = clientDao.persist(r);
        
        AssuranceAuto aa = new AssuranceAuto();
        aa.getClientList().add(r);
        aa.setBonnusMalus(10);
        aa.setBirthDate(new Date());
        aa.setDraftDate(new Date());
        aa.setImmatriculation("AABBDDE");
        aa.setSubscriptionDate(new Date());
        aa.setTypeAssurance("AUTO");
        int idAa = assuranceDao.persist(aa);
        Assert.assertTrue(idAa > 0);
        System.out.println(idAa);
        assuranceDao.delete(aa);
        
        AssuranceHabitat ah = new AssuranceHabitat();
        aa.getClientList().add(r);
        ah.setCoverValue(10000);
        ah.setBirthDate(new Date());
        ah.setDraftDate(new Date());
        ah.setAddress("MONTEPLLIER 34000");
        ah.setSubscriptionDate(new Date());
        ah.setTypeAssurance("AUTO");
        int idAh = assuranceDao.persist(ah);
        Assert.assertTrue(idAh > 0);
        System.out.println(idAh);
        assuranceDao.delete(ah);
        
        System.out.println("FIN TEST CREATION DES ASSURANCES");
    }

}
