package org.usfirst.frc199.Robot2017.commands;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class AutoAdjustTurret extends Command {

    public AutoAdjustTurret() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	//will use feedback loop with Vision and PID. Somehow...
    	//Good luck to whoever does this :)
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
