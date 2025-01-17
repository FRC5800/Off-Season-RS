/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import static frc.robot.RobotMap.*;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.VictorSP;

/**
 * Add your docs here.
 */
public class SubsystemIntakeHatch extends Subsystem {

  protected VictorSP hatchMotor = new VictorSP(HATCH_ID);
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  public void intakeUp(double sp){
    hatchMotor.set(sp);
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
}
