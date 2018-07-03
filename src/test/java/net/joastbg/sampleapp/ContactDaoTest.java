package net.joastbg.sampleapp;


import junit.framework.Assert;
import net.joastbg.sampleapp.dao.ContactDao;
import net.joastbg.sampleapp.entities.CompteBancaire;
import net.joastbg.sampleapp.entities.Contact;
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
public class ContactDaoTest {


    @Autowired
    ContactDao contactDao;

    Contact contact;

    @Before
    public void setUp() {
        contact = new Contact();
        contact.setType("PHONE");
        contact.setVal("0781858640");
    }

    @Test
    public void testPersist(){
        int id = (int) contactDao.persist(contact);
        Assert.assertTrue(id > -1);
        contactDao.delete(contact);
    }

    @Test
    public void testFind(){
        int id = (int) contactDao.persist(contact);
        System.out.println(id);
        Contact contactFound = contactDao.find(id);
        Assert.assertNotNull(contactFound);
        Assert.assertEquals(contact, contactFound);
        contactDao.delete(contact);
    }

}
