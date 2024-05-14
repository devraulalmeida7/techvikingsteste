// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkLowLevel.MotorType;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

/**
 * This is a demo program showing the use of the DifferentialDrive class. Runs the motors with
 * arcade steering.
 */
public class Robot extends TimedRobot {

  CANSparkMax motorDianteiroDireito = new CANSparkMax(3,MotorType.kBrushless);
  CANSparkMax motorDianteiroEsquerdo = new CANSparkMax(4,MotorType.kBrushless);

  CANSparkMax motorTraseiroDireito = new CANSparkMax(5,MotorType.kBrushless);
  CANSparkMax motorTraseiroEsquerdo = new CANSparkMax(6,MotorType.kBrushless);


  CANSparkMax lancador1 = new CANSparkMax(7,MotorType.kBrushless);
  CANSparkMax lancador2 = new CANSparkMax(8,MotorType.kBrushless);

  private final DifferentialDrive m_robotDrive = new DifferentialDrive(motorDianteiroEsquerdo::set, motorDianteiroDireito::set);

  private final XboxController m_stick = new XboxController(0);


  public Robot() {
  }

  @Override
  public void robotInit() {
    motorTraseiroDireito.follow(motorDianteiroDireito);
    motorTraseiroEsquerdo.follow(motorDianteiroEsquerdo);
    
  }

  @Override
  public void autonomousInit() {
    andarPraFrente();
    andarPraFrente2();


  }

  public void andarPraFrente() {
    if(Timer.getFPGATimestamp() <= 3) {
      motorDianteiroDireito.set(1);
      motorDianteiroEsquerdo.set(1);
    }
  }
  public void andarPraFrente2() {
    if(Timer.getFPGATimestamp() <= 4) {
      motorDianteiroDireito.set(1);
      motorDianteiroEsquerdo.set(1);
    }
  }
  public void lancar() {
    if(m_stick.getRawButton(4)) {
      lancador1.set(1);
      lancador2.set(1);
    }
    else {
      lancador1.set(0);
      lancador2.set(0);
    }
  }

  @Override
  public void teleopPeriodic() {
    m_robotDrive.arcadeDrive(-m_stick.getRawAxis(4), -m_stick.getRawAxis(1));
    lancar();
  }
}
