package miguelvargas;

import robocode.Robot;
import robocode.ScannedRobotEvent;


public class miguelvargas extends Robot { 
    public void run() {
       // intialize count variable
        int count = 0;
        

        while (true) {
            //this if statement makes the robot use the "sprayAndPray method" every 3 bullets fired
            // this is a tactic that makes sure that the robot doesn't run out of energy
            if ( count % 2 == 0){
                sprayAndPray();
            }
            
            // makes the robot go to a random location
            moveRandomAngle();
            // scans the whole battlefield
            turnRadarRight(360);
            // the count is used to keep track of how many runs/ bullets were fired
            // a bullet will be fired every turn 
            count += 1;

            


            
        }
    }

    public void onScannedRobot(ScannedRobotEvent e) {
        // fires a low power bullet so it conserves energy and has more towards movement
        fire(1);
        
    }

    public void moveRandomAngle() {
        // Move in a random pattern
        // gets a num from 0.1-1.0 and mutliplies by 360 to make it a degree in which the robot can turn
        double randomAngle = Math.random()* 360;
        turnLeft(randomAngle);
        ahead(10);
        
    }
     
    public void sprayAndPray(){
        // makes the robot shoot a bullet every five degrees
        for(int i = 0;i<360; i += 5){
               
            turnGunRight(5);
            fire(1);
        }
    }

    
    
    
}

