//ATTENTION:
/*Things to do eventually:
 * Determine values for "SetKnownVariables"
 */
package org.usfirst.frc.team687.robot;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */

public class Robot extends IterativeRobot {
	VictorSP kDriveFrontLeft, kDriveFrontRight, kDriveBackLeft, kDriveBackRight;
	Encoder encodeLeft, encodeRight;
	double last_time;
	double last_encodeLeft, last_encodeRight;
	double accLeft, accRight;
	double m_end_time;
	double m_max_acceleration;
	double m_desired_distance;
	double m_max_speed;
	double velocityLeft, velocityRight;
	
	
    /**
//     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() {
    	encodeLeft = new Encoder(0,1);
    	encodeRight = new Encoder(2,3);
    	kDriveFrontLeft = new VictorSP(2);
    	kDriveFrontRight = new VictorSP(3);
    	kDriveBackLeft = new VictorSP(4);
    	kDriveBackRight = new VictorSP(5);
    	
    			
    }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {

    }

    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() {
    	kDriveFrontLeft.set(velocityLeft);
    	kDriveBackLeft.set(velocityLeft);
    	kDriveFrontRight.set(velocityRight);
    	kDriveBackRight.set(velocityRight);
    	double current_encodeLeft = encodeLeft.getRaw();
    	double current_encodeRight = encodeRight.getRaw();
    	double time = System.currentTimeMillis();
    	double delta_time = time - last_time;
    	double delta_encodeLeft = current_encodeLeft - last_encodeLeft;
    	double delta_encodeRight = current_encodeRight- last_encodeRight;
    	double actual_rpmLeft = (delta_encodeLeft/delta_time)/ 250 / 60000.0;
    	double actual_rpmRight = (delta_encodeRight/delta_time)/ 250.0;
    	
    	velocityLeft = (current_encodeLeft - 0.5 * accLeft * time * time) / time;
    	velocityRight = (current_encodeRight - 0.5 * accRight * time * time) / time;
    	
    	last_time = time;
    	last_encodeLeft = current_encodeLeft;
    	last_encodeRight = current_encodeRight;
    	
    	accLeft = actual_rpmLeft < m_max_speed - m_max_acceleration * m_end_time ? m_max_acceleration : actual_rpmLeft < m_max_speed ? (m_max_speed - actual_rpmLeft) * m_end_time : 0; 
    	accRight = actual_rpmRight < m_max_speed - m_max_acceleration * m_end_time ? m_max_acceleration : actual_rpmRight < m_max_speed ? (m_max_speed - actual_rpmRight) * m_end_time : 0; 
        SmartDashboard.putNumber("Distance (Left Encode)", current_encodeLeft);
        SmartDashboard.putNumber("Distance (Right Encode)", current_encodeRight);
        SmartDashboard.putNumber("Time", time);
       

        
    }
    
    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
    
    }
    void SetKnownVariables (double end_time, double max_acceleration, double desired_distance, double max_speed){
    	double m_end_time = end_time;
    	double m_max_acceleration = max_acceleration;
    	double m_desired_distance = desired_distance;
    	double m_max_speed = max_speed;
    	
    	
    	
    
    }
    
}
