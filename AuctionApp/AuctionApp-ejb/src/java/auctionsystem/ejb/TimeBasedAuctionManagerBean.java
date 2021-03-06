/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package auctionsystem.ejb;

import java.text.DateFormat;
import java.util.Date;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.ejb.Stateful;

/**
 *
 * @author Cursos Montoya
 */
@Stateful
@LocalBean
public class TimeBasedAuctionManagerBean {

    public String communicationTest(String message) {
        DateFormat df = DateFormat.getDateInstance();
        return "Received " + message + " at: " + df.format( new Date() );
    }
}
