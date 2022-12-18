/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication8;

import java.util.Random;

/**
 *
 * @author Radwa osman
 */
public class Glove {
         int gloveId;
        private boolean status;
        
        Glove(int gloveId){
            this.gloveId = gloveId;
            this.status = true;
        }
        public synchronized void free() throws InterruptedException{
            status = true;
        }
        public synchronized boolean Pick(int roomID) throws InterruptedException{
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

