/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package auctionsystem.ejb;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.LocalBean;
import javax.ejb.Startup;

/**
 *
 * @author Curso
 */
@Startup
@Singleton(name="ClaseA")
@LocalBean

public class A {
@PostConstruct
public void init(){
    System.out.println("A.init(): @PostConstruct");
}
}
