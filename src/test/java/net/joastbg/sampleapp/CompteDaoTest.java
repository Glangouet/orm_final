package net.joastbg.sampleapp;


import junit.framework.Assert;
import net.joastbg.sampleapp.dao.ClientDao;
import net.joastbg.sampleapp.dao.CompteDao;
import net.joastbg.sampleapp.entities.CompteBancaire;
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
public class CompteDaoTest {


    @Autowired
    CompteDao compteDao;

    CompteBancaire compte;

    @Before
    public void setUp() {
        compte = new CompteBancaire(
                "FR7612548029980000000150086",
                "bic",
                "pcode",
                false
        );
    }

    @Test
    public void testPersist(){
        
        System.out.println("TEST PERSSIST COMPTE BANCAIRE");
        
        String id = compteDao.persist(compte);
        Assert.assertTrue(id != null);
        compteDao.delete(compte);
        
        System.out.println("FIN TEST PERSSIST COMPTE BANCAIRE");
    }

    @Test
    public void testFind(){
        
        System.out.println("TEST FIND A COMPTE BANCAIRE BY ID");
        
        String id = compteDao.persist(compte);
        CompteBancaire compteFound = compteDao.find(id);
        Assert.assertNotNull(compteFound);
        Assert.assertEquals(compte,compteFound);
        compteDao.delete(compte);
        
        System.out.println("FIN TEST FIND A COMPTE BANCAIRE BY ID");
    }

}
