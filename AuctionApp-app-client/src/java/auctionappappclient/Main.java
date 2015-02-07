/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package auctionappappclient;

import auctionsystem.ejb.AuctionManagerBeanRemote;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 *
 * @author Cursos Montoya
 */
public class Main {

    private static AuctionManagerBeanRemote auctionManagerBeanRemote;
    
    public static void main(String[] args) throws NamingException {
        
        String jndiPath = "java:global/AuctionApp/AuctionApp-ejb/AuctionManagerBean!auctionsystem.ejb.AuctionManagerBeanRemote";
        System.setProperty("java.naming.factory.initial", "com.sun.enterprise.naming.SerialInitContextFactory");
        System.setProperty("java.naming.factory.url.pkgs", "com.sun.enterprise.naming");
        System.setProperty("java.naming.factory.state", "com.sun.corba.ee.impl.presentation.rmi.JNDIStateFactoryImpl");
        //*********************************
        System.setProperty("org.omg.CORBA.ORBInitialHost", "localhost"); //Aquí se podría poner la IP del server donde está montada la App
        System.setProperty("org.omg.CORBA.ORBInitialPort", "3700");
        
        Context context = new InitialContext();
        auctionManagerBeanRemote = (AuctionManagerBeanRemote)context.lookup(jndiPath);
        System.out.println("auctionappclient.Main.main: found AuctionManagerBeanRemote: " + auctionManagerBeanRemote);
       
        System.out.println("auctionappclient.Main.main: calling communicationTest");
        
        String greeting = auctionManagerBeanRemote.communicationTest("Hello on startup");
        System.out.println("auctionManagerBeanRemote say: " + greeting);
    }
    
}
