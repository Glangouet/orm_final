/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.joastbg.sampleapp;

import java.util.Date;
import java.util.List;
import junit.framework.Assert;
import net.joastbg.sampleapp.dao.ClientDao;
import net.joastbg.sampleapp.entities.PersonnePhysique;
import net.joastbg.sampleapp.services.ClientService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Guillaume
 */
@TransactionConfiguration(transactionManager="transactionManager", defaultRollback=false)
@Transactional
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/spring/config/BeanLocations.xml")
public class ClientServiceTest {
    
    @Autowired
    ClientService clientService;
    
    @Autowired
    ClientDao clientDao;
    
    @Before
    public void setUp() {
    }

    @Test
    public void testGetClientBirthdate() {
        PersonnePhysique cp = new PersonnePhysique();
        cp.setBirthDate(new Date());
        cp.setFirstname("Guillaume");
        cp.setLastname("LANGOUET");
        clientDao.persist(cp);
        
        List<PersonnePhysique> lp = this.clientService.feature10();
        System.out.println(lp.size());
        for (PersonnePhysique p : lp) {
          System.out.println(p.getFirstname() + ' ' + p.getLastname());
        }
        Assert.assertTrue(lp.size() > 0);
    }
    
}
