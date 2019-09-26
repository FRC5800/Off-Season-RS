package frc.robot.commands;

import frc.robot.subsystems.SubsystemJoystick;
import frc.robot.Robot;
import edu.wpi.first.wpilibj.command.*;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class CommandDrive extends Command {
	double arcadeSpeed;
	double arcadeRotation;

	public static final double minR = 0.4D, difR = 0.5D;

	public CommandDrive() {
		super(Robot.driver);
	}

	@Override
	protected void execute() {
		this.arcadeSpeed = - SubsystemJoystick.axis_d_LY.get();
		this.arcadeRotation = SubsystemJoystick.axis_d_RX.get();

		this.arcadeDrive(this.arcadeSpeed, this.arcadeRotation);

		SmartDashboard.putNumber("Left Master", Robot.driver.masterLeft.getMotorOutputPercent());
    	SmartDashboard.putNumber("Left  Slave", Robot.driver.slaveLeft.getMotorOutputPercent());
    	SmartDashboard.putNumber("Rigth Master", Robot.driver.masterRight.getMotorOutputPercent());
  	  	SmartDashboard.putNumber("Rigth Slave", Robot.driver.slaveRight.getMotorOutputPercent());
	}
	
	@Override
	protected boolean isFinished() {
		return false;
	}

	public void arcadeDrive(double speed, double rotation) {
		double modifier = minR + difR * Math.pow(1 - Math.abs(speed), 2);
		double rate = Math.pow(rotation, 3) * modifier;
		Robot.driver.tankDrive(-0.8 * (speed - rotation) , 0.8 * (speed + rotation));

		SmartDashboard.putNumber("Speed", speed);
		SmartDashboard.putNumber("Rate", rate);
		SmartDashboard.putNumber("Rotation", rotation);
	}

	@Override
	protected void end() {
	}
}
