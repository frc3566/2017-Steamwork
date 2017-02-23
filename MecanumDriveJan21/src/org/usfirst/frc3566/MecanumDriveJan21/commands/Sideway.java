package org.usfirst.frc3566.MecanumDriveJan21.commands;

import org.usfirst.frc3566.MecanumDriveJan21.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class Sideway extends Command {

	char myDirection;
	
    public Sideway(char direction) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	myDirection = direction;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if(myDirection=='l'){
    		Robot.mecanumDriveTrain.driveTrainSidewayLeft(0.8);
    	}else if(myDirection=='r'){
    		Robot.mecanumDriveTrain.driveTrainSidewayRight(0.8);
    	}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.mecanumDriveTrain.stopDriveTrain();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
