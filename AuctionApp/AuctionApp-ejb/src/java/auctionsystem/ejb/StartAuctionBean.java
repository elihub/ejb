/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package auctionsystem.ejb;

import auctionsystem.entity.Auction;
import auctionsystem.entity.Item;
import auctionsystem.entity.User;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Stateless;

/**
 *
 * @author Curso
 */
@Singleton
public class StartAuctionBean implements StartAuctionBeanRemote {
    List<Auction> auctions;
    
   //tipo de retorno debe de ser void
   //no admite parametros a menos que sea interceptor
   //puede tener cualquier modificador de acceso
    @PostConstruct
    private void initialize(){
      auctions=new LinkedList<>();
      //auctions.add(new Auction(55.5, "OPEN", new Date(), new Date(), new Item("Playera", "playera.png"), null));
    }
            
    
    @Override
    public void addAuction(double startAmount, Date closeTime, Item item, User seller) {
        Auction auction=new Auction(startAmount, "OPEN", new Date(), closeTime, item, seller);
        auctions.add(auction);
        System.out.println(auction);
        //return auction; 
    }

    @Override
    public List<Auction> getAuctions() {
        return auctions;
    }
    

   
}
