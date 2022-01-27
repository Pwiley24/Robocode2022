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

		setColors(new Color(67,12,118),Color.black, Color.blue); // body,gun,radar
		setBulletColor(Color.black);
		double angleA = 0;
		double sideA = 0;
		// Robot main loops
		while(true) {
			setTurnGunLeft(5);
			//determine the side of the field the robot is on:
			if (getX() >= getWidth()/2){ //right side of field
				sideA = (getWidth()-5) - getX();
				if(getY() >= getHeight()/2) { //top half of field
					angleA = Math.toRadians(90 - getHeading());
				} else {//bottom half
					angleA = Math.toRadians(getHeading() - 90);
				}
			}else{//left side of field
				sideA = getX();
				if(getY() >= getHeight()/2) { //top half of field
					angleA = Math.toRadians(90 - getHeading());
				} else { //bottom half
					angleA = Math.toRadians(getHeading() - 90);
				}
			}
			//calculate the distance to go:
			double distance = Math.acos(angleA) / sideA;
			setAhead(distance);
			scan();
			execute();
				
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
		if(isTeammate(e.getName()) == false){//if they are not on my team 
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
