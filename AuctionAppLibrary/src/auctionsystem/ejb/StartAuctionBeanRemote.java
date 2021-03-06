/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package auctionsystem.ejb;

import auctionsystem.entity.Auction;
import auctionsystem.entity.Bid;
import auctionsystem.entity.Item;
import auctionsystem.entity.User;
import java.util.Date;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author Curso
 */
@Remote
public interface StartAuctionBeanRemote {

    void addAuction(double startAmount, Date closeTime, Item item, User seller);

    List<Auction> getAuctions();
    
    User login(String displayName, String password);

    boolean addBid(Auction nameAuction, double amount, User bidder);

    List<Bid> getBids();
    
}
