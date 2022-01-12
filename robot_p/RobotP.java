package robot_p;
import robocode.*;
import java.awt.Color;

// API help : https://robocode.sourceforge.io/docs/robocode/robocode/Robot.html

/**
 * RobotP - a robot by Paige Wiley
 * A Robot that zig zags across the field.
 * Scans the battle field and predicts where the robots are heading
 * Fires in those directions
 * If close enough to another robot, ram.
 */


public class RobotP extends AdvancedRobot
{


	
	/**
	 * run: RobotP's default behavior
	 */
	public void run() {
		// Initialization of the robot should be put here
		setAdjustRadarForGunTurn(true);
		setAdjustGunForRobotTurn(true);
		// After trying out your robot, try uncommenting the import at the top,
		// and the next line:

		setColors(Color.white,Color.blue,Color.green); // body,gun,radar

		// Robot main loops
		
		while(true) {
			// Replace the next 4 lines with any behavior you would like
			setTurnRadarLeft(5);
			setTurnGunLeft(5);
			setAhead(100);
			scan();
			execute();
			
			while(getDistanceRemaining() > 0 && getGunTurnRemaining() > 0 && getRadarTurnRemaining() > 0){
				execute();
			}

				
		}
	}
	
	

	/**
	 * onScannedRobot: What to do when you see another robot
	 */
	public void onScannedRobot(ScannedRobotEvent e) {
		// Replace the next line with any behavior you would like
		
		fire(1);
		
		turnGunLeft(10);
		turnRadarLeft(10);
		fire(1);
		
		turnGunRight(20);
		turnRadarRight(20);
		fire(1);
		

	}
	
	public void onRobotHit(HitRobotEvent e){
		back(10);
		turnLeft(50);
	}

	/**
	 * onHitByBullet: What to do when you're hit by a bullet
	 */
	public void onHitByBullet(HitByBulletEvent e) {
		// Replace the next line with any behavior you would like
		
	}
	
	/**
	 * onHitWall: What to do when you hit a wall
	 */
	public void onHitWall(HitWallEvent e) {
		// Replace the next line with any behavior you would like
		turnLeft(45);
	}	
}
