/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package auctionsystem.ejb;

import auctionsystem.entity.Item;
import java.util.List;
import java.util.concurrent.Future;
import javax.ejb.Remote;

/**
 *
 * @author Cursos Montoya
 */
@Remote
public interface AuctionManagerBeanRemote {

    String communicationTest(String message);

    Item addItem(Item item);

    Item addItem(String description, String image);
            
    List<Item> getItems();

    void remove();

    Future<String> checkout();

    
    
}
