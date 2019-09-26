package frc.robot.subsystems;

import static frc.robot.RobotMap.*;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.Robot;
import frc.robot.commands.CommandDrive;

public class SubsystemDriver extends Subsystem {
	public TalonSRX masterLeft = new TalonSRX (DRIVE_MOTOR_RL_ID);
	public TalonSRX masterRight = new TalonSRX (DRIVE_MOTOR_RR_ID);
	public TalonSRX slaveLeft = new TalonSRX (DRIVE_MOTOR_FL_ID);
	public TalonSRX slaveRight = new TalonSRX(DRIVE_MOTOR_FR_ID);


	public void tankDrive(double _l, double _r){
		this.masterLeft.set(ControlMode.PercentOutput, _l);
		this.masterRight.set(ControlMode.PercentOutput, _r);
		this.slaveLeft.follow(this.masterLeft);
		this.slaveRight.follow(this.masterRight);
	}

	@Override
	public void initDefaultCommand() {
		Robot.driver.setDefaultCommand(new CommandDrive());
	}

	public SubsystemDriver() {
		super();		
	}
}
