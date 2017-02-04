package org.usfirst.frc199.Robot2017;

import org.usfirst.frc199.Robot2017.commands.*;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.*;
import org.usfirst.frc199.Robot2017.subsystems.*;

public class OI {
	public JoystickButton switchDriveButton;
	public JoystickButton autoAlignGearRoutineButton;
	public Joystick leftJoy;
	public JoystickButton shiftGearsButton;
	public JoystickButton gradualDriveButton;
	public JoystickButton autoShootRoutineButton;
	public Joystick rightJoy;
	public JoystickButton intakeButton;
	public JoystickButton outputButton;
	public JoystickButton shootOutButton;
	public JoystickButton winchInButton;
	public JoystickButton winchButton;
	public JoystickButton feedInButton;
	public JoystickButton feedOutButton;
	public JoystickButton toggleIntakeButton;
	public JoystickButton autoUSAdjustButton;
	public Joystick manipulator;
	public JoystickButton toggleFlipper;

	public OI() {
		manipulator = new Joystick(2);

		feedOutButton = new JoystickButton(manipulator, 8);
		feedOutButton.whileHeld(new RunFeeder(Robot.getPref("feederDirection", 1), Robot.shooter));
		feedInButton = new JoystickButton(manipulator, 6);
		feedInButton.whileHeld(new RunFeeder(-Robot.getPref("feederDirection", 1), Robot.shooter));
		winchButton = new JoystickButton(manipulator, 2);
		winchButton.whileHeld(new Climb(Robot.climber));
		shootOutButton = new JoystickButton(manipulator, 4);
		shootOutButton.whileHeld(new RunShooter(Robot.getPref("shooterDirection", 1), Robot.shooter));
		outputButton = new JoystickButton(manipulator, 5);
		outputButton.whileHeld(new RunIntake(Robot.getPref("intakeDirection", 1), Robot.intake));
		intakeButton = new JoystickButton(manipulator, 7);
		intakeButton.whileHeld(new RunIntake(-Robot.getPref("intakeDirection", 1), Robot.intake));
		toggleIntakeButton = new JoystickButton(manipulator, 3);
		toggleIntakeButton.whenPressed(new ToggleIntake(Robot.intake));
		autoUSAdjustButton = new JoystickButton(manipulator, 1);
		autoUSAdjustButton.whenPressed(new AutoDrive(Robot.drivetrain.getUSDistToDrive(),
				Robot.drivetrain.calcUSTargetAngle(), Robot.drivetrain));
		
		rightJoy = new Joystick(1);
		
		autoShootRoutineButton = new JoystickButton(rightJoy, 4);
		// TODO: (Ana T.) Insert accurate AutoShoot arguments to be executed
		// when autoShootRoutineButton is held
		autoShootRoutineButton.whileHeld(new AutoShoot(0, 0, Robot.shooter));
		gradualDriveButton = new JoystickButton(rightJoy, 1);
		gradualDriveButton.whileHeld(new GradualDrive(Robot.drivetrain));
		shiftGearsButton = new JoystickButton(rightJoy, 2);
		shiftGearsButton.whenPressed(new ToggleDrivetrainShift(Robot.drivetrain));
		toggleFlipper = new JoystickButton(rightJoy, 5);
		toggleFlipper.whenPressed(new ToggleIntakeRamp(Robot.intake));
		
		leftJoy = new Joystick(0);

		switchDriveButton = new JoystickButton(leftJoy, 4);
		switchDriveButton.whenPressed(new ToggleDriveType(Robot.drivetrain));
		autoAlignGearRoutineButton = new JoystickButton(leftJoy, 2);
		// TODO: (Ana T.) Insert accurate AutoAlignGear arguments to be executed
		// when autoShootRoutineButton is held
		autoAlignGearRoutineButton.whileHeld(new AutoAlignGear());

		// SmartDashboard Buttons
		SmartDashboard.putData("MainAutoMode", new MainAutoMode());
		SmartDashboard.putData("AutoDrive", new AutoDrive(0, 0, Robot.drivetrain));
		SmartDashboard.putData("AutoDelay", new AutoDelay(0, Robot.intake));
		SmartDashboard.putData("AutoAdjustHood", new AutoAdjustHood(Robot.shooter));
		SmartDashboard.putData("AutoAdjustTurret", new AutoAdjustTurret());
		SmartDashboard.putData("AutoShoot", new AutoShoot(0, 0, Robot.shooter));
		SmartDashboard.putData("TeleopDrive", new TeleopDrive(Robot.drivetrain));
		SmartDashboard.putData("GradualDrive", new GradualDrive(Robot.drivetrain));
		SmartDashboard.putData("ToggleDriveType", new ToggleDriveType(Robot.drivetrain));
		SmartDashboard.putData("ToggleDrivetrainShift", new ToggleDrivetrainShift(Robot.drivetrain));
		SmartDashboard.putData("TestPID", new TestPID(TestPID.System.DRIVEDISTANCE, Robot.shooter, Robot.drivetrain));
		SmartDashboard.putData("IntakeIn", new RunIntake(0, Robot.intake));
		SmartDashboard.putData("FeederIn", new RunFeeder(0, Robot.shooter));
		SmartDashboard.putData("TurnTurret", new TurnTurret());
		SmartDashboard.putData("ToggleIntake", new ToggleIntake(Robot.intake));
		SmartDashboard.putData("Climb", new Climb(Robot.climber));

		// For use by Manual Control Widget
		SmartDashboard.putData("ManualControl/Command",
				new ManualControlMechs(Robot.intake, Robot.shooter, Robot.climber));
		
		//TestPID Commands
		SmartDashboard.putData("PID/DriveDistance/TestDriveDistancePID", new TestPID(TestPID.System.DRIVEDISTANCE, Robot.shooter, Robot.drivetrain));
		SmartDashboard.putData("PID/DriveDistance/TestDriveAnglePID", new TestPID(TestPID.System.DRIVEANGLE, Robot.shooter, Robot.drivetrain));
		SmartDashboard.putData("PID/Shooter/TestShooterPID", new TestPID(TestPID.System.SHOOTER, Robot.shooter, Robot.drivetrain));
		SmartDashboard.putData("PID/DriveVelocity/TestDriveVelocityPID", new TestPID(TestPID.System.DRIVEVELOCITY, Robot.shooter, Robot.drivetrain));
		SmartDashboard.putData("PID/DriveAngularVelocity/TestDriveAngularVelocityPID", new TestPID(TestPID.System.DRIVEANGULARVELOCITY, Robot.shooter, Robot.drivetrain));

		

	}

	public Joystick getLeftJoy() {
		return leftJoy;
	}

	public Joystick getRightJoy() {
		return rightJoy;
	}

	public Joystick getManipulator() {
		return manipulator;
	}

}
