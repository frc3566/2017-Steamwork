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

import org.usfirst.frc3566.MecanumDriveJan21.commands.*;
import org.usfirst.frc3566.MecanumDriveJan21.subsystems.MecanumDriveTrain.Direction;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;



/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {


    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    public Joystick driveTrainJoystick;
    public Joystick miscellaneousJoystick;
    public static double slowDownValue;
    public static JoystickButton hopeMailMoves;
    public static JoystickButton hopeMailMovesOpp;
    public static JoystickButton gearPositive;
    public static JoystickButton gearNegative;
    public static JoystickButton ballIn;
    public static JoystickButton fuelOut;
    public static JoystickButton climbUP;
    public static JoystickButton climbDOWN;
    public static JoystickButton shoot, fuelIn;
    public static JoystickButton ballTriggerOpen, ballTriggerClose, trigger3;
    public static JoystickButton sidewayL, sidewayR, rotateL, rotateR;
    public static JoystickButton frontAndBack;
    public static JoystickButton deliverGear, deliverGear2;
    public static JoystickButton front, back;
   
    // END AUTOGENERATED CODE, SOURCE=ROBOT0BUILDER ID=DECLARATIONS

	public OI() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS

    	driveTrainJoystick = new Joystick(0);
        miscellaneousJoystick = new Joystick(1);
        
    //    hopeMailMoves = new JoystickButton(joystick1, 1);
    //    hopeMailMoves.whileHeld(new moveMailBox(true));

        front = new JoystickButton(driveTrainJoystick, 1);
        front.whenPressed(new DriveForDistance(Direction.FORWARD, 0.15, 0.2));
        
        back = new JoystickButton(driveTrainJoystick, 2);
        back.whenPressed(new DriveForDistance(Direction.BACKWARD, 0.15, 0.2));
        
        sidewayL = new JoystickButton(driveTrainJoystick, 5);
        sidewayL.whileHeld(new Strafe(Direction.LEFT));
        
        sidewayR = new JoystickButton(driveTrainJoystick, 6);
        sidewayR.whileHeld(new Strafe(Direction.RIGHT));
        
        rotateL = new JoystickButton(driveTrainJoystick, 7);
        rotateL.whileHeld(new Rotate(Direction.LEFT));
        
        rotateR = new JoystickButton(driveTrainJoystick, 8);
        rotateR.whileHeld(new Rotate(Direction.RIGHT));
        
        deliverGear2 = new JoystickButton(driveTrainJoystick, 3);
        deliverGear2.whenPressed(new PlaceGearOnLiftHook());
        
        gearPositive = new JoystickButton(miscellaneousJoystick,4);
        gearPositive.whileHeld(new RaiseGearHandler());
        gearPositive.whenReleased(new StopGearHandler());
        
        gearNegative = new JoystickButton(miscellaneousJoystick, 3);
        gearNegative.whileHeld(new LowerGearHandler());
        gearNegative.whenReleased(new StopGearHandler());
        
        ballIn = new JoystickButton(miscellaneousJoystick, 1);
        ballIn.whileHeld(new FuelIn());
        
        deliverGear = new JoystickButton(miscellaneousJoystick, 10);
        deliverGear.whenPressed(new PlaceGearOnLiftHook());
        
        shoot = new JoystickButton(miscellaneousJoystick, 8);
        shoot.whileHeld(new EnableShooter());
        
        fuelIn = new JoystickButton(miscellaneousJoystick, 7);
       fuelIn.whileHeld(new FuelIn());
        
        fuelOut = new JoystickButton(miscellaneousJoystick, 2);
       fuelOut.whileHeld(new FuelOut());
        
        ballTriggerOpen = new JoystickButton(miscellaneousJoystick, 5);
        ballTriggerOpen.whileHeld(new BallTriggerOpen());
        

        ballTriggerClose = new JoystickButton(miscellaneousJoystick, 6);
        ballTriggerClose.whileHeld(new BallTriggerClose());
        /** style style style
        climbUP= new JoystickButton(miscellaneousJoystick, 5);
        climbUP.whileHeld(new climbPositive());
        
        climbDOWN = new JoystickButton (miscellaneousJoystick, 6);
        climbDOWN.whileHeld(new climbNegative());
        **/
        
        
        

      //  hopeMailMovesOpp = new JoystickButton(joystick1, 2);
       //// hopeMailMovesOpp.whileHeld(new moveMailBox(false));
        
        
        
        
        // SmartDashboard Buttons
        SmartDashboard.putData("AutoLiftFront", new AutonomousLiftFront());
        // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
    }

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=FUNCTIONS
    public Joystick getJoystick1() {
        return driveTrainJoystick;
    }

    public double getStraight(){
    	//on large robot logitech dual action, this axis is the y axis, axis 1
    	return driveTrainJoystick.getRawAxis(1);
    }
    
    public double getSideWays(){
    	return driveTrainJoystick.getRawAxis(0) * -1;
    }
    
    public double getRotation(){
    	return driveTrainJoystick.getRawAxis(2) * slowDownValue;
    }
    
    
    
    
    
    
    
    
}

