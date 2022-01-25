package robot_p;
import robocode.*;
import java.awt.Color;

// API help : https://robocode.sourceforge.io/docs/robocode/robocode/Robot.html

/**
 * RobotP - a robot by Paige Wiley
 * A Robot that zig zags across the field.
 * Scans the battle field and predicts where the robots are heading
 * Fires in those directions
 */


public class RobotP extends TeamRobot
{



	/**
	 * run: RobotP's default behavior
	 */
	public void run() {
		// Initialization of the robot should be put here
		setAdjustRadarForGunTurn(true);
		setAdjustGunForRobotTurn(true);
		setAdjustRadarForGunTurn(false);

		setColors(Color.white,Color.blue,Color.green); // body,gun,radar

		// Robot main loops
		while(true) {
			setTurnGunLeft(5);
			setAhead(100);
			scan();
			execute();
			
/*
			if(getX() >= 0 || getX() <= battlefield_width){
				turnLeft(45);
			}
			*/
		
			
			
			while(getDistanceRemaining() > 0 && getGunTurnRemaining() > 0){
				execute();
			}
	
				
		}
	}
	
	public void onBulletHit(BulletHitEvent e){
		setFire(2);
	}
	


	/**
	 * onScannedRobot: What to do when you see another robot
	 */
	public void onScannedRobot(ScannedRobotEvent e) {

		if(isTeammate(e.getName())) {
			return;//returns true if teammate, false if not
		}
		if(isTeammate(e.getName()) == false){
			fire(3);
			fire(2);
			
			setTurnGunLeft(10);
			setFire(2);
			setFire(2);
			
			setTurnGunRight(20);
			setFire(2);
			setFire(2);
		}

	}
	
	public void onRobotHit(HitRobotEvent e){
		
	}

	/**
	 * onHitByBullet: What to do when you're hit by a bullet
	 */
	public void onHitByBullet(HitByBulletEvent e) {
		// Replace the next line with any behavior you would like
		turnLeft(45);
	}
	
	/**
	 * onHitWall: What to do when you hit a wall
	 */
	public void onHitWall(HitWallEvent e) {
		// Replace the next line with any behavior you would like
		turnLeft(45);
	}	
}
