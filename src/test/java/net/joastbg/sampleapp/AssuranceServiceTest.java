/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.joastbg.sampleapp;

import java.util.Date;
import java.util.List;
import junit.framework.Assert;
import net.joastbg.sampleapp.dao.AssuranceDao;
import net.joastbg.sampleapp.dao.ClientDao;
import net.joastbg.sampleapp.entities.Assurance;
import net.joastbg.sampleapp.entities.AssuranceAuto;
import net.joastbg.sampleapp.interfaces.AssuranceInterface;
import net.joastbg.sampleapp.entities.PersonnePhysique;
import net.joastbg.sampleapp.services.AssuranceService;
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
public class AssuranceServiceTest {
    
    @Autowired
    AssuranceService assuranceService;
    
    @Autowired
    AssuranceDao assuranceDao;
    
    @Before
    public void setUp() {
    }

    @Test
    public void feature9bisTest() {
        System.out.println("TEST ASSURANCE SERVICE FEATURE 9 BIS");

        AssuranceAuto aa = new AssuranceAuto();
        aa.setBonnusMalus(10);
        aa.setBirthDate(new Date());
        aa.setDraftDate(new Date());
        aa.setImmatriculation("AABBDDE");
        aa.setSubscriptionDate(new Date());
        aa.setTypeAssurance("AUTO");
        int idAa = assuranceDao.persist(aa);
        Assert.assertTrue(idAa > 0);
        System.out.println("ID ASSURANCE CREE PR LE TEST : " + idAa);
        
        List<AssuranceInterface> la = assuranceDao.findByDate();
        int countLa = la.size();
        System.out.println("NB ASSURANCE BIRTHDAY TODAY : " + countLa);
        
        int nbDelete = assuranceService.feature9bis();
        System.out.println("NB ASSURANCE DELETE : " + nbDelete);
        
        List<AssuranceInterface> la2 = assuranceDao.findByDate();
        int countLa2 = la2.size();
        
        System.out.println("NB ASSURANCE BIRTHDAY AFTER DELETE CODE : " + countLa2);
        
        Assert.assertTrue(countLa != countLa2);
    }
    
}
