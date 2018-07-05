/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.joastbg.sampleapp.services;

import java.util.Date;
import java.util.List;
import net.joastbg.sampleapp.dao.AssuranceDao;
import net.joastbg.sampleapp.entities.Assurance;
import net.joastbg.sampleapp.interfaces.AssuranceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Guillaume
 */
@Service
public class AssuranceService {
    
    @Autowired
    private AssuranceDao assuranceDao;
    
    public void feature9() {
        Date d = new Date();
        List<AssuranceInterface> la = assuranceDao.findAll();
        for (AssuranceInterface a : la) {
           if (a.getBirthDate() == d) {
               assuranceDao.delete(a);
           }
        }
    }
    
    public int feature9bis() {
        return assuranceDao.deleteBybirthDate();
    }
}
