package lee;
import robocode.*;
import java.awt.Color;

// API help : https://robocode.sourceforge.io/docs/robocode/robocode/Robot.html

/**
 * Robot1 - a robot by (your name here)
 */
public class Robot1 extends TeamRobot
{
	/**
	 * run: Robot1's default behavior
	 */
	public void run() {
		// Initialization of the robot should be put here

		// After trying out your robot, try uncommenting the import at the top,
		// and the next line:

		setColors(Color.red,Color.blue,Color.green); // body,gun,radar

		// Robot main loop
		while(true) {
			// Replace the next 4 lines with any behavior you would like
			ahead(100);
			turnGunRight(360);
			turnRight(10);
			scan();
			
			turnRight(30);
			ahead(100);

		//	turnGunRight(360);
		}
	}

	/**
	 * onScannedRobot: What to do when you see another robot
	 */
	public void onScannedRobot(ScannedRobotEvent e) {
		// Replace the next line with any behavior you would like
		boolean isTeam = false;
		 if (isTeammate(e.getName()) ){
           return;
		   
   	    }
	  
		if (isTeammate(e.getName()) == false){
			fireBullet(2);
			turnRight(15);
			back(40);
			fireBullet(2);
			
			back(80);
			fireBullet(.1);
			scan();
		}
		
		ahead(10);
		
	}

	/*
	 * onHitByBullet: What to do when you're hit by a bullet
	 */
	public void onHitByBullet(HitByBulletEvent e) {
		// Replace the next line with any behavior you would like
		turnRight(10);
		scan();
		ahead(175);
		scan();
		turnRight(45);
	}
	
	/**
	 * onHitWall: What to do when you hit a wall
	 */
	public void onHitWall(HitWallEvent e) {
		// Replace the next line with any behavior you would like
		
		back(170);
		turnLeft(70);
		scan();
		scan();
		ahead(130);
		turnLeft(70);
		scan();
	}	
	public void onBulletMissed(BulletMissedEvent event){
		turnRight(30);
		ahead(170);
		scan();
	}
	public void onHitRobot(HitRobotEvent event){
	//fire(.5);
	back(70);
		
	scan();
		
	}
	

}
