// RobotBuilder Version: 2.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.


package org.usfirst.frc3566.MecanumDriveJan21;

import edu.wpi.cscore.UsbCamera;
import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.networktables.NetworkTable;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc3566.MecanumDriveJan21.commands.*;
import org.usfirst.frc3566.MecanumDriveJan21.subsystems.*;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {

	public static FishyThread camA;
	public static UsbCamera camB;
	public static NetworkTable table;
    Command autonomous;
    public static Mailbox mailbox;
    public static OI oi;
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    public static MecanumDriveTrain mecanumDriveTrain;
    public static Encoder encoder1;
    SendableChooser<Command> autoChooser;
    public static GearDelivery GearDelivery;
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() {
    	
    	RobotMap.init();
    
        mecanumDriveTrain = new MecanumDriveTrain();
        
        //NOTE: FishyThread includes vision processing loop. DO NOT CREATE TWO
        	FishyThread camA = new FishyThread (0, FishyThread.defaultStart);
    		
    		camA.setDaemon(true);
    		camA.start();
    		  
    		camB = CameraServer.getInstance().startAutomaticCapture(1);
    		
    		NetworkTable.setIPAddress("roborio-3566-Frc.local");
    		table = NetworkTable.getTable("datatable");
    		
    		autoChooser = new SendableChooser<Command>();
    		autoChooser.addDefault("autoLiftFront", new AutonomousLiftFront());
    		autoChooser.addObject("autoLiftLeft", new AutonomousLiftSide(1));
    		autoChooser.addObject("autoLiftRight", new AutonomousLiftSide(2));
    		SmartDashboard.putData("Auto Chooser", autoChooser);
    		
    	mailbox = new Mailbox();
    	GearDelivery= new GearDelivery();
    	
        oi = new OI();
        OI.slowDownValue = 0.5;
        
        encoder1 = new Encoder(0, 1); //parameters: A channel and B channel
        encoder1.setMaxPeriod(.1);
        encoder1.setMinRate(10);
        encoder1.setDistancePerPulse(5);
        encoder1.setReverseDirection(true);
        encoder1.setSamplesToAverage(7);
        
    }

    /**
     * This function is called when the disabled button is hit.
     * You can use it to reset subsystems before shutting down.
     */
    public void disabledInit(){
    }

    public void disabledPeriodic() {
        Scheduler.getInstance().run();
    }

    public void autonomousInit() {
        autonomous = (Command) autoChooser.getSelected();
        autonomous.start();
    }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {
        Scheduler.getInstance().run();
    }

    public void teleopInit() {
        // This makes sure that the autonomous stops running when
        // teleop starts running. If you want the autonomous to
        // continue until interrupted by another command, remove
        // this line or comment it out.
        if (autonomous!= null) autonomous.cancel();
        
    }

    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() {
        Scheduler.getInstance().run();
    
    }

    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
        LiveWindow.run();
    }
    
    public NetworkTable getTable(){
		return table;
	}

}
