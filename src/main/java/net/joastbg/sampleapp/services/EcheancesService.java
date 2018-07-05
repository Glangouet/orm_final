/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.joastbg.sampleapp.services;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import net.joastbg.sampleapp.dao.ClientDao;
import net.joastbg.sampleapp.dao.EcheancesDao;
import net.joastbg.sampleapp.interfaces.AssuranceInterface;
import net.joastbg.sampleapp.entities.Client;
import net.joastbg.sampleapp.entities.Echeances;
import net.joastbg.sampleapp.entities.PersonnePhysique;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Guillaume
 */
@Service
public class EcheancesService {
    
    @Autowired
   private EcheancesDao echeanceDao;
    
   public List<Echeances> feature7(AssuranceInterface a) {
        SimpleDateFormat formater = new SimpleDateFormat("MM");
        Date date1 = new Date();
        DateTime date2 = new DateTime();
        date2.plusMonths(6);
        String month1 = formater.format(date1);
        String month2 = Integer.toString(date2.getMonthOfYear());
       
        return echeanceDao.feature7(a, month1, month2);
   }
}
