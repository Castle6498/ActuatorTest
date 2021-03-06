/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team6498.robot;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;


public class Robot extends IterativeRobot {
	LinearActuator m;
	Joystick j;
	IRSensor i;
	NidecBrushless motor;
	@Override
	public void robotInit() {
		m = new LinearActuator(0);
		j=new Joystick(0);
		//i = new IRSensor(0, 2, 3);//port, min volt, max volt triggers
		motor = new NidecBrushless(6,5,7,1,3);//pwmEnableChannel, dioChannel, pwmDirectionChannel, encoderAChannel, encoderBChannel
	}

	
	@Override
	public void autonomousInit() {
		
	}

	/**
	 * This function is called periodically during autonomous.
	 */
	@Override
	public void autonomousPeriodic() {
		
	}

	/**
	 * This function is called periodically during operator control.
	 */	
	public void teleopInit() {
		motor.enable();
	}
	@Override
	public void teleopPeriodic() {
		m.set((j.getRawAxis(3)+1)/2);
		System.out.println(m.get());
		
		//System.out.println("Voltage: "+i.getVoltage());
	//	System.out.println("Target? "+i.seesBall());
	
		
		
		
		motor.set(j.getY());
		//motor.set(-0.5);
		System.out.println(motor.get()+" Distance: "+motor.getDistance()+ "Rate: "+motor.getRate());
		
	}

	/**
	 * This function is called periodically during test mode.
	 */
	@Override
	public void testPeriodic() {
	}
}
