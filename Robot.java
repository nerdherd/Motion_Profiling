//ATTENTION:
/*Things to finish:
 * Set motor values
 */
package org.usfirst.frc.team687.robot;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.IterativeRobot;
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
	VictorSP kDriveFrontLeft;
	VictorSP kDriveFrontRight;
	VictorSP kDriveBackLeft;
	VictorSP kDriveBackRight;
	Encoder encode;
	double last_time;
	double last_encode;
	double acc;
	double m_end_time;
	double m_max_acceleration;
	double m_desired_distance;
	double m_max_speed;
	
	
    /**
//     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() {
    	encode = new Encoder(0,0);
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
    	double current_encode = encode.getRaw();
    	double time = System.currentTimeMillis();
    	double delta_time = time - last_time;
    	double delta_encode = current_encode - last_encode;
    	double actual_rpm = (delta_encode/delta_time)/ 250.0;
    	
    	
    	
    	last_time = time;
    	last_encode = current_encode;
    	
    	acc = actual_rpm < m_max_speed - m_max_acceleration * m_end_time ? m_max_acceleration : actual_rpm < m_max_speed ? (m_max_speed - actual_rpm) * m_end_time : 0; 
        SmartDashboard.putNumber("Distance", current_encode);
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
