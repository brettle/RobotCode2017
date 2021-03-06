package org.usfirst.frc199.Robot2017.commands;

import org.usfirst.frc199.Robot2017.subsystems.ShooterInterface;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class SetTurretToZero extends Command {

	ShooterInterface shooter;
    public SetTurretToZero(ShooterInterface shooter) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	this.shooter = shooter;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	shooter.resetTurretEncoder();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return true;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
