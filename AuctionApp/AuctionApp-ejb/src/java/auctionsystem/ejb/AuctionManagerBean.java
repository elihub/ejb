/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package auctionsystem.ejb;

import auctionsystem.entity.Item;
import java.util.LinkedList;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author Cursos Montoya
 */
@Stateless
public class AuctionManagerBean implements AuctionManagerBeanRemote {
    
    @EJB
    private TimeBasedAuctionManagerBean timeBasedAuctionManagerBean;
    @EJB
    private TimeBasedAuctionManagerBean timeBasedAuctionManagerBean2;
    private List<Item> items = new LinkedList<Item>();
    
    @Override
    public String communicationTest(String message) {
        System.out.println("AuctionManagerBean.communicationTest");
        System.out.println("equals Stateful "+timeBasedAuctionManagerBean.equals(timeBasedAuctionManagerBean2));
        return timeBasedAuctionManagerBean.communicationTest(message);
    }

    @Override
    public Item addItem(String description, String image) {
        Item item = new Item(description, image);
        items.add(item);
        System.out.println("addItem[" + description + ", " + image + ")");
        return item;
    }
    
    @Override
    public Item addItem(Item item) {
        items.add(item);
        return item;
    }

    @Override
    public List<Item> getItems() {
        return items;
    }
}