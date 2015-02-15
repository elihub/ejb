/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package auctionsystem.ejb;

import auctionsystem.entity.CreditCard;
import auctionsystem.entity.Item;
import auctionsystem.entity.User;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.Future;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.AsyncResult;
import javax.ejb.Asynchronous;
import javax.ejb.EJB;
import javax.ejb.PostActivate;
import javax.ejb.PrePassivate;
import javax.ejb.Remove;
import javax.ejb.Stateful;
import javax.ejb.Stateless;

/**
 *
 * @author Cursos Montoya
 */
@Stateful
public class AuctionManagerBean implements AuctionManagerBeanRemote {
    
    @EJB
    private TimeBasedAuctionManagerBean timeBasedAuctionManagerBean;
    @EJB
    private TimeBasedAuctionManagerBean timeBasedAuctionManagerBean2;
    private List<Item> items = new LinkedList<Item>();
    private List<User> users;
    
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
    
    @PostConstruct
    public void initialize(){
          users=new LinkedList<>();
          users.add(new User("Jennifer", "Whalen", "3 South Washington St. Binghamton, N.Y 13903", new CreditCard("1234-5678-9012-3456".toCharArray(), (short) 11, (short) 25, "503".toCharArray(), "Jennifer Whalen"), "JWHALEN", "Jennifer", "Jennifer123"));
          users.add(new User("Karen", "Colmenares", "1100 Van Ness Avenue Fresno, CA 93724-0002", new CreditCard("0987-6543-2198".toCharArray(), (short) 9, (short) 18, "605".toCharArray(), "Karen Colmenares"), "KCOLMENA", "Karen", "Karen123"));
    }
    //call backs de los metodos en la vida de ejecucion de un EJB
    
    @PrePassivate
    private void passive(){
        System.out.println("AuctionManagerBean.passive():@PrePassivate");
        
    }    
  
    @PostActivate
    private void activate(){
        System.out.println("AuctionManagerBean.activate():@PostActivate");
        users=new LinkedList<>();
    }
    
    @Remove
    public void remove() {
        System.out.println("AuctionManagerBean.remove():@Remove");
    }
    //se ejecuta antes de que el EJB muera mandando llamar el @Remove o se ejecuta cuando existe en error
    @PreDestroy
    private void destroy(){
       System.out.println("AuctionManagerBean.destroy():@PreDestroy"); 
        
    }

    @Asynchronous
    public Future<String> checkout() {
        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(1000);
                System.out.println("Trabajando...");
            } catch (InterruptedException ex) {
                Logger.getLogger(AuctionManagerBean.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        String orderId="102";
        return new AsyncResult<>(orderId);
    }

   
    
    
    
}