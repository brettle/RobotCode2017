// RobotBuilder Version: 2.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.

package org.usfirst.frc199.Robot2017;

import com.kauailabs.navx.frc.AHRS;

// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS
import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.CounterBase.EncodingType;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.PIDSourceType;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Talon;

// END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj.I2C;
import edu.wpi.first.wpilibj.SerialPort;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
	// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
	public static SpeedController drivetrainLeftMotor;
	public static SpeedController drivetrainRightMotor;
	public static RobotDrive drivetrainRobotDrive;
	public static Encoder drivetrainLeftEncoder;
	public static Encoder drivetrainRightEncoder;
	public static AnalogGyro drivetrainGyro;
	public static Compressor drivetrainCompressor;
	public static DoubleSolenoid drivetrainLeftShiftPiston;
	public static DoubleSolenoid drivetrainRightShiftPiston;
	public static DoubleSolenoid intakePivotPiston;
	public static SpeedController intakeIntakeMotor;
	public static SpeedController intakeIndexMotor;
	public static SpeedController shooterShootMotor;
	public static SpeedController shooterFeedMotor;
	public static Encoder shooterShootEncoder;
	public static SpeedController turretTurnMotor;
	public static SpeedController turretHoodMotor;
	public static Encoder turretTurretEncoder;
	public static Encoder turretHoodEncoder;
	public static SpeedController climberWinchMotor;
	public static DigitalInput climberPlateLimit;
	public static AHRS ahrs;

	// END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS

	public static void init() {
		// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
		drivetrainLeftMotor = new Talon(0);
		LiveWindow.addActuator("Drivetrain", "LeftMotor", (Talon) drivetrainLeftMotor);

		drivetrainRightMotor = new Talon(1);
		LiveWindow.addActuator("Drivetrain", "RightMotor", (Talon) drivetrainRightMotor);

		drivetrainRobotDrive = new RobotDrive(drivetrainLeftMotor, drivetrainRightMotor);

		drivetrainRobotDrive.setSafetyEnabled(true);
		drivetrainRobotDrive.setExpiration(0.1);
		drivetrainRobotDrive.setSensitivity(0.5);
		drivetrainRobotDrive.setMaxOutput(1.0);

		drivetrainLeftEncoder = new Encoder(0, 1, false, EncodingType.k4X);
		LiveWindow.addSensor("Drivetrain", "LeftEncoder", drivetrainLeftEncoder);
		drivetrainLeftEncoder.setDistancePerPulse(1.0);
		drivetrainLeftEncoder.setPIDSourceType(PIDSourceType.kRate);
		drivetrainRightEncoder = new Encoder(2, 3, false, EncodingType.k4X);
		LiveWindow.addSensor("Drivetrain", "RightEncoder", drivetrainRightEncoder);
		drivetrainRightEncoder.setDistancePerPulse(1.0);
		drivetrainRightEncoder.setPIDSourceType(PIDSourceType.kRate);
		drivetrainGyro = new AnalogGyro(0);
		LiveWindow.addSensor("Drivetrain", "Gyro", drivetrainGyro);
		drivetrainGyro.setSensitivity(0.007);
		drivetrainCompressor = new Compressor(0);

		drivetrainLeftShiftPiston = new DoubleSolenoid(0, 0, 1);
		LiveWindow.addActuator("Drivetrain", "LeftShiftPiston", drivetrainLeftShiftPiston);

		drivetrainRightShiftPiston = new DoubleSolenoid(0, 2, 3);
		LiveWindow.addActuator("Drivetrain", "RightShiftPiston", drivetrainRightShiftPiston);

		intakePivotPiston = new DoubleSolenoid(0, 4, 5);
		LiveWindow.addActuator("Intake", "PivotPiston", intakePivotPiston);

		intakeIntakeMotor = new Talon(2);
		LiveWindow.addActuator("Intake", "IntakeMotor", (Talon) intakeIntakeMotor);

		intakeIndexMotor = new Talon(5);
		LiveWindow.addActuator("Intake", "IndexMotor", (Talon) intakeIndexMotor);

		shooterShootMotor = new Talon(3);
		LiveWindow.addActuator("Shooter", "ShootMotor", (Talon) shooterShootMotor);

		shooterFeedMotor = new Talon(4);
		LiveWindow.addActuator("Shooter", "FeedMotor", (Talon) shooterFeedMotor);

		shooterShootEncoder = new Encoder(4, 5, false, EncodingType.k4X);
		LiveWindow.addSensor("Shooter", "ShootEncoder", shooterShootEncoder);
		shooterShootEncoder.setDistancePerPulse(1.0);
		shooterShootEncoder.setPIDSourceType(PIDSourceType.kRate);
		turretTurnMotor = new Talon(6);
		LiveWindow.addActuator("Turret", "TurnMotor", (Talon) turretTurnMotor);

		turretHoodMotor = new Talon(7);
		LiveWindow.addActuator("Turret", "HoodMotor", (Talon) turretHoodMotor);

		turretTurretEncoder = new Encoder(6, 7, false, EncodingType.k4X);
		LiveWindow.addSensor("Turret", "TurretEncoder", turretTurretEncoder);
		turretTurretEncoder.setDistancePerPulse(1.0);
		turretTurretEncoder.setPIDSourceType(PIDSourceType.kRate);
		turretHoodEncoder = new Encoder(8, 9, false, EncodingType.k4X);
		LiveWindow.addSensor("Turret", "HoodEncoder", turretHoodEncoder);
		turretHoodEncoder.setDistancePerPulse(1.0);
		turretHoodEncoder.setPIDSourceType(PIDSourceType.kRate);
		climberWinchMotor = new Talon(8);
		LiveWindow.addActuator("Climber", "WinchMotor", (Talon) climberWinchMotor);

		climberPlateLimit = new DigitalInput(10);
		LiveWindow.addSensor("Climber", "PlateLimit", climberPlateLimit);

		// END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS

		ahrs = new AHRS(SerialPort.Port.kMXP); // Alternatives: SPI.Port.kMXP,
												// I2C.Port.kMXP or
												// SerialPort.Port.kUSB
	}
}
