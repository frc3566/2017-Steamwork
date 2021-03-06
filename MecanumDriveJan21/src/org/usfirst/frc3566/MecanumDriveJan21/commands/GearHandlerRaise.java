package org.usfirst.frc3566.MecanumDriveJan21.commands;

import org.usfirst.frc3566.MecanumDriveJan21.Robot;
import org.usfirst.frc3566.MecanumDriveJan21.navigation.VisionValues;
import org.usfirst.frc3566.MecanumDriveJan21.subsystems.GearHandler;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class GearHandlerRaise extends Command {
	private GearHandler gearHandler;
	private double mySpeed;
	private double distance = -1;

	public GearHandlerRaise() {
		requires(Robot.gearHandler);
		gearHandler = Robot.gearHandler;
		mySpeed = 0.7;
	}

	public GearHandlerRaise(double speed, double PotentiometerDistance) {
		mySpeed = speed;
		distance = PotentiometerDistance;
	}

	public GearHandlerRaise(double timeout) {
		this();
		this.setTimeout(timeout);
		mySpeed = 0.7;
	}

	// Called just before this Command runs the first time
	protected void initialize() {
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		gearHandler.deliver(mySpeed);
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return (this.isTimedOut() || (!gearHandler.isAtFrontLimit()));
	}

	// Called once after isFinished returns true
	protected void end() {
		gearHandler.stop();
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
		end();
	}
}
