// RobotBuilder Version: 2.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.


package org.usfirst.frc199.Robot2017.subsystems;

import org.usfirst.frc199.Robot2017.Robot;
import org.usfirst.frc199.Robot2017.PID;
import org.usfirst.frc199.Robot2017.DashboardInterface;
import org.usfirst.frc199.Robot2017.RobotMap;
import org.usfirst.frc199.Robot2017.commands.*;

import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.CounterBase.EncodingType;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.PIDSourceType;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Talon;

import edu.wpi.first.wpilibj.command.Subsystem;


/**
 *
 */
public class Drivetrain extends Subsystem implements DashboardInterface{

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    private final SpeedController leftMotor = RobotMap.drivetrainLeftMotor;
    private final SpeedController rightMotor = RobotMap.drivetrainRightMotor;
    private final RobotDrive robotDrive = RobotMap.drivetrainRobotDrive;
    private final Encoder leftEncoder = RobotMap.drivetrainLeftEncoder;
    private final Encoder rightEncoder = RobotMap.drivetrainRightEncoder;
    // private final AnalogGyro gyro = RobotMap.drivetrainGyro;
    private final Compressor compressor = RobotMap.drivetrainCompressor;
    private final DoubleSolenoid leftShiftPiston = RobotMap.drivetrainLeftShiftPiston;
    private final DoubleSolenoid rightShiftPiston = RobotMap.drivetrainRightShiftPiston;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    
    private final AHRS gyro = RobotMap.ahrs;

    public boolean isInArcadeDrive = true;
    private double currentSpeed = 0; //only used and changed in Arcade Drive
    private double currentTurn = 0;
    
    public PID drivePID = new PID("drivePID");
    public PID turnPID = new PID("turnPID");

    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND


        // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND

        // Set the default command for a subsystem here.
        // setDefaultCommand(new MySpecialCommand());
    	setDefaultCommand(new TeleopDrive());
    	
    }
    
    public void resetEncoder() {
    	leftEncoder.reset();
    	rightEncoder.reset();
    }
    
    public void resetGyro() {
    	gyro.reset();
    }
    
    public double getAngle() {
    	return gyro.getAngle();
    }
    public double getDistance() {
    	return (leftEncoder.get() + rightEncoder.get()) / 2;
    }
    
    public double getSpeed() {
    	return (leftEncoder.getRate() + rightEncoder.getRate()) / 2;
    }
    
    public void gradualDrive() {
    	if (isInArcadeDrive) {
    		currentSpeed += Math.signum(Robot.oi.rightJoy.getY() - currentSpeed) * 0.05;
    		currentTurn += Math.signum(Robot.oi.leftJoy.getX() - currentTurn) * 0.05;
    		robotDrive.arcadeDrive(currentTurn, currentSpeed);
    	} else {
    		robotDrive.tankDrive(leftMotor.get() + Math.signum(Robot.oi.leftJoy.getY() - leftMotor.get()) * 0.05, 
    				rightMotor.get() + Math.signum(Robot.oi.rightJoy.getY() - rightMotor.get()) * 0.05);
    	}
    }
    
    public void drive() {
    	
    	if (isInArcadeDrive) {
    		currentSpeed = Robot.oi.rightJoy.getY();
    		currentTurn = Robot.oi.leftJoy.getX();
    		robotDrive.arcadeDrive(currentTurn, currentSpeed);
    	} else {
    		robotDrive.tankDrive(Robot.oi.leftJoy.getY(), Robot.oi.rightJoy.getY());
    	}
    }
    
    public void autoDrive() {
    	drivePID.update(getDistance());
    	turnPID.update(getAngle());
    	robotDrive.arcadeDrive(drivePID.getOutput(), turnPID.getOutput());
    }
    
    public void stopDrive() {
    	robotDrive.arcadeDrive(0, 0);
    }

	@Override
	public void displayData() {
		// TODO Auto-generated method stub
		
	}
}


