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

	/*
	 * run: RobotP's default behavior
	 */
	public void run() {
		// Initialization of the robot should be put here
		setAdjustRadarForGunTurn(true);
		setAdjustGunForRobotTurn(true);
		setAdjustRadarForGunTurn(false);
		//colors:
		setGunColor(Color.BLACK);
		setRadarColor(Color.BLUE);
		setBodyColor(new Color(67,012,118));
		setBulletColor(Color.BLACK);
		
		/*
		 * Varibales for the commented out code below
		 
		double angleA = 0;
		double sideA = 0;
		double y = 0;
		*/
		
		// Robot main loops
		while(true) {
			setTurnGunLeft(5);
			
			/*
			 * not enough time to get this code to work.
			 * was supposed to calculate the distance till the 
			 * robot reaches the edge of the battle field
			 * then turns before it takes damage.
			 
			//determine the side of the field the robot is on:
			if (getX() >= getBattleFieldWidth()/2){ //right side of field
				sideA = (getBattleFieldWidth()-100) - getX();
				if(getY() >= getBattleFieldHeight()/2) { //top half of field
					angleA = 90 - getHeading();
				} else {//bottom half
					y = 180 - getHeading();
					angleA = getHeading() - y + 90;
				}
			}else{//left side of field
				sideA = getX() - 100;
				if(getY() >= getBattleFieldHeight()/2) { //top half of field
					y = 360 - getHeading();
					angleA = 90 - y;
				} else { //bottom half
					angleA = getHeading() - 90;
				}
			}
			//calculate the distance to go:
			double distance = Math.cos(angleA) * sideA;
			if(distance <= 0){
				turn(45);
				setAhead(10);
			}else {
				setAhead(distance);
			}
			*/
			
			setAhead(100);
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
	


	/*
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

	/*
	 * onHitByBullet: What to do when you're hit by a bullet
	 */
	public void onHitByBullet(HitByBulletEvent e) {
		turnLeft(45);
	}
	
	/*
	 * onHitWall: What to do when you hit a wall
	 */
	public void onHitWall(HitWallEvent e) {
		turnLeft(45);
	}	

}
