/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication5;

import java.util.Random;

/**
 *
 * @author Radwa osman
 */
public class Philosopher {
   
        private int philosopherId;
        private Fork left, right;
        
        public Philosopher(int philosopherId) {
            this.philosopherId = philosopherId;
        }
        public void start(Fork left,Fork right) throws InterruptedException{
            this.left = left;
            this.right = right;
            
            while(true){
                if(new Random().nextBoolean()){
                    eat();
                }else{
                    think();
                }
            }
    }
        public void think() throws InterruptedException{
            System.out.println("The philosopher: " + philosopherId + " is now thinking.");
            Thread.sleep(new Random().nextInt(1000)+100);
            System.out.println("The philosopher: " + philosopherId + " has stopped thinking.");
            
        }
        public void eat() throws InterruptedException{
            boolean rightPick = false;
            boolean leftPick = false;
            
            System.out.println("The philosopher: " + philosopherId + " is now hungry and wants to eat.");
            System.out.println("The philosopher: " + philosopherId + " is now picking up the fork: " + left.forkId);
            leftPick = left.pick(philosopherId);
            if (!leftPick){
                return;
            }
            System.out.println("The philosopher: " + philosopherId + " is now picking up the fork: " + right.forkId);
            rightPick = right.pick(philosopherId);
            if (!rightPick){
                left.free();
                return;
            }
            System.out.println("The philosopher: " + philosopherId + " is now eating.");
            Thread.sleep(new Random().nextInt(1000) + 100);
            
            left.free();
            right.free();
            System.out.println("The philosopher: " + philosopherId + " has stopped eating and freed the forks.");
        }
}

