package org.usfirst.frc3566.MecanumDriveJan21.subsystems;

import java.awt.Robot;

import org.usfirst.frc3566.MecanumDriveJan21.RobotMap;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.command.Subsystem;


/**
 * package org.usfirst.frc3566.MecanumDriveJan21.subsystems;

import org.usfirst.frc3566.MecanumDriveJan21.Robot;

import org.usfirst.frc3566.MecanumDriveJan21.RobotMap;


import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class pickingBalls extends Subsystem {
	private final CANTalon ballPick = RobotMap.fuelPickerUpper8;
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public void ballIn(){
    
    	ballPick.set(-1);
    }
    
    public void ballOut(){
    	//if(Robot.gearLimitSwitchBack.get())
    	ballPick.set(1);
    }
    
	public void stop() {
		// TODO Auto-generated method stub
		ballPick.set(0.0);
		
	}
}
