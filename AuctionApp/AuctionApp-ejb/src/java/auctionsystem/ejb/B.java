/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package auctionsystem.ejb;

import javax.annotation.PostConstruct;
import javax.ejb.DependsOn;
import javax.ejb.Singleton;
import javax.ejb.LocalBean;
import javax.ejb.Startup;

/**
 *
 * @author Curso
 */
@Startup
@Singleton
@LocalBean
@DependsOn("ClaseA")//la clase de la cual depende para que el servidor las cargue en un orde
public class B {
@PostConstruct
  public void init(){
    System.out.println("B.init(): @PostConstruct");
}
}
