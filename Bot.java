package Rh;
import robocode.*;
import robocode.Robot;
import robocode.ScannedRobotEvent;
import static robocode.util.Utils.normalRelativeAngleDegrees;
import java.awt.Color;

//Rohan Bopardikar 1/30/22

public class Bot extends TeamRobot
{
  
    public void run() {
    
        //Team colors
        setGunColor( Color.BLACK);
		setRadarColor(Color.BLUE);
		setBodyColor(new Color(67,012,118));
		setBulletColor(Color.BLACK);

        while (true) {
            turnGunRight(360);
			ahead(40);
        }
    }

    public void onScannedRobot(ScannedRobotEvent e) {
        // dont shoot teammate, taken from Paige's code
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
        // Scanning from Trackfire
        double absoluteBearing = getHeading() + e.getBearing();
        double gunBearing = normalRelativeAngleDegrees(absoluteBearing - getGunHeading());
        double distance = e.getDistance();
		
        // close range 
        if (Math.abs(gunBearing) <= 3 && e.getDistance() < 1000) {
            turnGunRight(gunBearing);
            fire(2);
        }
        
        else {
            turnGunRight(gunBearing);
        }
       
    }
 //From Fire Sample Robot
    public void onHitByBullet(HitByBulletEvent e) {
        // Move perpendicular to where bullet came from
        turnRight(normalRelativeAngleDegrees(90 - (getHeading() - e.getHeading())));
        back(200);
        scan();
    }
	public void onHitWall(HitWallEvent e){
		back(100);
	}
}