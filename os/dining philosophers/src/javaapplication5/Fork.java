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
public class Fork {

        public int forkId;
        private boolean status;
        
        Fork(int forkId){
            this.forkId = forkId;
            this.status = true;
        }
        public synchronized void free() throws InterruptedException{
            status = true;
        }
        public synchronized boolean pick(int philosopherID) throws InterruptedException{
            int counter = 0;
            int waitUntil = new Random().nextInt(10)+5;
            while(!status){
                Thread.sleep(new Random().nextInt(100)+50);
                counter++;
                if (counter > waitUntil){
                    return false;
                }
            }
            status = false;
            return true;
        }
    }
        
