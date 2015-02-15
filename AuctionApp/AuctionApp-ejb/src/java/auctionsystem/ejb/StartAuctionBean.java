/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package auctionsystem.ejb;

import auctionsystem.entity.Auction;
import auctionsystem.entity.Bid;
import auctionsystem.entity.CreditCard;
import auctionsystem.entity.Item;
import auctionsystem.entity.User;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.ConcurrencyManagement;
import javax.ejb.ConcurrencyManagementType;
import javax.ejb.Lock;
import javax.ejb.LockType;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.ejb.Stateless;

/**
 *
 * @author Curso
 */
@ConcurrencyManagement(ConcurrencyManagementType.CONTAINER)
@Startup //iguer
@Singleton

public class StartAuctionBean implements StartAuctionBeanRemote {
    
    public StartAuctionBean(){
        System.out.println("se contrulle el bean");
    }
    List<Auction> auctions;
    private List<User> users;
    private List<Bid> bids;
   //tipo de retorno debe de ser void
   //no admite parametros a menos que sea interceptor
   //puede tener cualquier modificador de acceso
    @PostConstruct
    private void initialize(){
      auctions=new LinkedList<>();
      bids=new LinkedList<>();
      users=new LinkedList<>();
      users.add(new User("Jennifer", "Whalen", "3 South Washington St. Binghamton, N.Y 13903", new CreditCard("1234-5678-9012-3456".toCharArray(), (short) 11, (short) 25, "503".toCharArray(), "Jennifer Whalen"), "JWHALEN", "Jennifer", "Jennifer123"));
      users.add(new User("Karen", "Colmenares", "1100 Van Ness Avenue Fresno, CA 93724-0002", new CreditCard("0987-6543-2198".toCharArray(), (short) 9, (short) 18, "605".toCharArray(), "Karen Colmenares"), "KCOLMENA", "Karen", "Karen123"));
      //auctions.add(new Auction(55.5, "OPEN", new Date(), new Date(), new Item("Playera", "playera.png"), null));
      System.out.println("StartAuctionBean.initialize(): @PostConstruct");
              
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
    
 @Override
    public User login(String displayName, String password) {
        for (User user : users) {
            if(user.getDisplayName().equals(displayName)&&user.getPassword().equals(password))
                return  user;         
     }
        return null;
    }
    
    @Lock(LockType.WRITE)
    @Override
    public boolean addBid(Auction nameAuction, double amount, User bidder) {
       
        return false;
    }
    
   @Lock(LockType.READ)
    @Override
    public List<Bid> getBids() {
        return bids;
    }
    
    
   
}
