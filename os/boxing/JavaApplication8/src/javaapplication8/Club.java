/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package javaapplication8;
import java.util.Random ;
import java.util.Scanner;
public class Club {

     Player[] players;
     Glove[] gloves;
     Thread[] threads;
     Scanner scan;
     int number;
  
    public static void main(String[] args) {
        
        Club object = new Club();
        object.init();
        object.StartWaitingPlay();  
    }
    public void init () {
        scan = new Scanner(System.in);
        System.out.println("boxing problem.");
        try{
            System.out.println("Enter the number of players.");
            number = scan.nextInt();
            
            if(number < 2){
                System.out.println("Number must be greater than 1.");
                return;
            }
        }catch(Exception e){
             System.out.println("You must enter an integer.");
        }
        players = new Player[number];
        gloves = new Glove[number];
        threads = new Thread[number];
        
        for(int i=0; i< number; i++){
            players[i] = new Player(i+1);
            gloves[i] = new Glove(i+1);
        }
    }
    public void StartWaitingPlay(){
        for(int i=0; i< number; i++){
            final int index = i;
            threads[i] = new Thread(new Runnable(){
                public void run(){
                    try {
                        players[index].start(gloves[index],gloves[(index + 1) % (number)]);
                    } catch (InterruptedException e){
                        e.printStackTrace();
                    }
                }
            } );
            threads[i].start();
        }
    }


}
