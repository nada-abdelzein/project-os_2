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
public class Player {

        private int playerId;
        private Glove left, right;
        
        public Player(int playerId) {
            this.playerId = playerId;
        }
        public void start(Glove left, Glove right) throws InterruptedException{
            this.left = left;
            this.right = right;
            
            while(true){
                if(new Random().nextBoolean()){
                    Play();
                }else{
                    think();
                }
            }
        }
        public void think() throws InterruptedException{
            System.out.println("The player: " + playerId + " is now Waiting.");
            Thread.sleep(new Random().nextInt(1000)+100);
            System.out.println("The player: " + playerId + "has stopped Waiting.");
            
        }
        public void Play() throws InterruptedException{
            boolean rightPick = false;
            boolean leftPick = false;
            
            System.out.println("The player: " + playerId + " is now ready and wants to play.");
            System.out.println("The player: " + playerId + " is now pick the gloves: " + left.gloveId);
            leftPick = left.Pick(playerId);
            if (!leftPick){
                return;
            }
            System.out.println("The player: " + playerId + " is now pick the gloves: " + right.gloveId);
            rightPick = right.Pick(playerId);
            if (!rightPick){
                left.free();
                return;
            }
            System.out.println("The player: " + playerId + " is now playing.");
            Thread.sleep(new Random().nextInt(1000) + 100);
            
            left.free();
            right.free();
            System.out.println("The player: " + playerId + " has stopped playing and freed the gloves.");
        }
    }

