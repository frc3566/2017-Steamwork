package org.usfirst.frc3566.MecanumDriveJan21.commands;

import org.usfirst.frc3566.MecanumDriveJan21.Robot;
import org.usfirst.frc3566.MecanumDriveJan21.subsystems.Shooter;

import edu.wpi.first.wpilibj.command.Command;

public class ShooterStart extends Command {

    private boolean finished;
    private Shooter shooter;

    public ShooterStart() {
	requires(Robot.shooter);
	shooter = Robot.shooter;
    }
    
    // Called just before this Command runs the first time
    protected void initialize() {
	shooter.startShooter();
	finished = false;
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
	if (shooter.isReady()) {
	    shooter.openTrigger();
	    finished = true;
	}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
	return finished;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
