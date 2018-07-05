package net.joastbg.sampleapp;


import java.util.Date;
import java.util.List;
import junit.framework.Assert;
import net.joastbg.sampleapp.dao.AssuranceDao;
import net.joastbg.sampleapp.dao.ContactDao;
import net.joastbg.sampleapp.dao.EcheancesDao;
import net.joastbg.sampleapp.dao.SinistreDao;
import net.joastbg.sampleapp.entities.Assurance;
import net.joastbg.sampleapp.entities.AssuranceAuto;
import net.joastbg.sampleapp.entities.AssuranceHabitat;
import net.joastbg.sampleapp.entities.CompteBancaire;
import net.joastbg.sampleapp.entities.Contact;
import net.joastbg.sampleapp.entities.Echeances;
import net.joastbg.sampleapp.entities.Sinistre;
import net.joastbg.sampleapp.services.EcheancesService;
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
public class EcheancesServiceTest {


    @Autowired
    EcheancesDao echeanceDao;
    
    @Autowired
    EcheancesService echeancesService;
    
    @Autowired
    AssuranceDao assuranceDao;

    @Before
    public void setUp() {
    }

    @Test
    public void feature7test() {
        System.out.println("TEST RECUPERATION ECHEANCE 6MOIS");
        
        AssuranceAuto aa = new AssuranceAuto();
        aa.setBonnusMalus(10);
        aa.setBirthDate(new Date());
        aa.setDraftDate(new Date());
        aa.setImmatriculation("AABBDDE");
        aa.setSubscriptionDate(new Date());
        aa.setTypeAssurance("AUTO");
        int idAa = assuranceDao.persist(aa);
        Assert.assertTrue(idAa > 0);
        aa.setIdAssurance(idAa);
        System.out.println("AJOUT D'UNE ASSURANCE ID : " + idAa);
        
        Echeances e = new Echeances();
        e.setAssurance(aa);
        e.setIssueBillDate(new Date());
        e.setIssueDate(new Date());
        e.setPaiementDate(new Date());
        e.setPrice(500);
        int idEch = echeanceDao.persist(e);
        System.out.println("AJOUT D'UNE ECHEANCE ID : " + idEch);
        Assert.assertTrue(idEch > 0);
        
        List<Echeances> le = echeancesService.feature7(aa);
        System.out.println("NOMBRE D'ECHEANCES TROUVE DANS LES 6 MOIS POUR CETTE ASSURANCE : " + idEch);
        Assert.assertTrue(le.size() > 0);
    }

}
