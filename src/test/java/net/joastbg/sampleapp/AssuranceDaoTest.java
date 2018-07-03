package net.joastbg.sampleapp;

import java.util.Date;
import java.util.List;
import java.util.Set;
import junit.framework.Assert;
import net.joastbg.sampleapp.dao.AssuranceDao;
import net.joastbg.sampleapp.dao.ClientDao;
import net.joastbg.sampleapp.entities.AssuranceAuto;
import net.joastbg.sampleapp.entities.AssuranceHabitat;
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
import net.joastbg.sampleapp.entities.Sinistre;

@TransactionConfiguration(transactionManager="transactionManager", defaultRollback=false)
@Transactional
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/spring/config/BeanLocations.xml")
    public class AssuranceDaoTest {

    @Autowired
    AssuranceDao assuranceDao;

    @Before
    public void setUp() {
    }

    @Test
    public void testPersist(){
        AssuranceAuto aa = new AssuranceAuto();
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
    }

}
