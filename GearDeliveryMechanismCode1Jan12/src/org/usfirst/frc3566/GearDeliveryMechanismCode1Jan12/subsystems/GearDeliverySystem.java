// RobotBuilder Version: 2.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.


package org.usfirst.frc3566.GearDeliveryMechanismCode1Jan12.subsystems;

import org.usfirst.frc3566.GearDeliveryMechanismCode1Jan12.RobotMap;
import org.usfirst.frc3566.GearDeliveryMechanismCode1Jan12.commands.*;
import com.ctre.CANTalon;
import edu.wpi.first.wpilibj.DigitalInput;

import edu.wpi.first.wpilibj.command.Subsystem;


/**
 *
 */
public class GearDeliverySystem extends Subsystem {

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    private final CANTalon cANTalon2 = RobotMap.gearDeliverySystemCANTalon2;
    private final DigitalInput limitSwitch0 = RobotMap.gearDeliverySystemLimitSwitch0;
    private final DigitalInput limitSwitch1 = RobotMap.gearDeliverySystemLimitSwitch1;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS


    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND

        setDefaultCommand(new SetGearInitialPosition());

        // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND

        // Set the default command for a subsystem here.
        // setDefaultCommand(new MySpecialCommand());
        this.stopGearPlatform();
    }
    
    
    public void raiseGearPlatform(){
    	cANTalon2.set(RobotMap.GEAR_DELIVERY_MOTOR_SPEED_BASIC);
    }
    
    public void lowerGearPlatform(){
    	cANTalon2.set(-RobotMap.GEAR_DELIVERY_MOTOR_SPEED_BASIC);
    }
    
    public void stopGearPlatform(){
    	cANTalon2.set(0.0);
    }
    
}

