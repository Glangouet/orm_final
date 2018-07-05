package net.joastbg.sampleapp;

import java.util.Date;
import junit.framework.Assert;
import net.joastbg.sampleapp.dao.ClientDao;
import net.joastbg.sampleapp.entities.Client;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import net.joastbg.sampleapp.entities.PersonneMorale;
import net.joastbg.sampleapp.entities.PersonnePhysique;

@TransactionConfiguration(transactionManager="transactionManager", defaultRollback=false)
@Transactional
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/spring/config/BeanLocations.xml")
public class ClientDaoTest {

    @Autowired
    ClientDao clientDao;

    @Before
    public void setUp() {
    }

    @Test
    public void testPersist(){
        System.out.println("TEST CREATION DES CLIENTS");
        
        PersonneMorale p = new PersonneMorale();
        p.setSiren("000000000");
        p.setCompanyName("test");
        int idP = clientDao.persist(p);
        Assert.assertTrue(idP > 0);
        
        PersonnePhysique r = new PersonnePhysique();
        r.setBirthDate(new Date());
        r.setFirstname("Guillaume");
        r.setLastname("Langouet");
        int idR = clientDao.persist(r);
        Assert.assertTrue(idR > 0);
        
        System.out.println("FIN TEST CREATION DES CLIENTS");
    }



}
