package robot_p;
import robocode.AdvancedRobot;
import java.awt.Color;

// API help : https://robocode.sourceforge.io/docs/robocode/robocode/Robot.html

/**
 * RobotP - a robot by Paige Wiley
 * This robot will be controlled by the user.
 */
public class RobotP extends Robot
{
	/**
	 * run: RobotP's default behavior
	 */
	 
	public void onKeyPressed (KeyEvent e){
		if(e.getKeyCode() == 32) {//If the space bar is pressed fire the bullet
			fireBullet(//assign a power level);
	}
	
	/*
	 * Will determine the direction the tank will move in 
	 * and where the gun is pointed
	 */
	public void onMousedMoved (KeyEvent e){
		int aimX;
		int aimY;
		//Redirect where the gun is pointed 
		aimX = e.getX();
		aimY = e.getY();
		turnGunLeft(aimX);
	}
	
	public void run() {
		// Initialization of the robot should be put here

		// After trying out your robot, try uncommenting the import at the top,
		// and the next line:

		// setColors(Color.red,Color.blue,Color.green); // body,gun,radar
		

		// Robot main loops
		
		while(true) {
			// 
			
			
		}
	}

	/**
	 * onScannedRobot: What to do when you see another robot
	 */
	public void onScannedRobot(ScannedRobotEvent e) {
		// Replace the next line with any behavior you would like
		fire(1);
	}

	/**
	 * onHitByBullet: What to do when you're hit by a bullet
	 */
	public void onHitByBullet(HitByBulletEvent e) {
		// Replace the next line with any behavior you would like
		back(10);
	}
	
	/**
	 * onHitWall: What to do when you hit a wall
	 */
	public void onHitWall(HitWallEvent e) {
		// Replace the next line with any behavior you would like
		back(20);
	}
	
	
	
	
}
