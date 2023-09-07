/* Copyright (c) 2017 FIRST. All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without modification,
 * are permitted (subject to the limitations in the disclaimer below) provided that
 * the following conditions are met:
 *
 * Redistributions of source code must retain the above copyright notice, this list
 * of conditions and the following disclaimer.
 *
 * Redistributions in binary form must reproduce the above copyright notice, this
 * list of conditions and the following disclaimer in the documentation and/or
 * other materials provided with the distribution.
 *
 * Neither the name of FIRST nor the names of its contributors may be used to endorse or
 * promote products derived from this software without specific prior written permission.
 *
 * NO EXPRESS OR IMPLIED LICENSES TO ANY PARTY'S PATENT RIGHTS ARE GRANTED BY THIS
 * LICENSE. THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
 * "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO,
 * THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE
 * FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL
 * DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
 * SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER
 * CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY,
 * OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
 * OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

package org.firstinspires.ftc.teamcode.OpModes;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.teamcode.BotActions.IBotAction;
import org.firstinspires.ftc.teamcode.BotActions.SimpleGamePadDrive;
import org.firstinspires.ftc.teamcode.Bots.FourMotorBot;
import org.firstinspires.ftc.teamcode.Bots.Robot;
import org.firstinspires.ftc.teamcode.internals.OpModeBase;
import org.firstinspires.ftc.teamcode.internals.TelemetryHandler;


/**
 * This file contains an minimal example of a Linear "OpMode". An OpMode is a 'program' that runs in either
 * the autonomous or the teleop period of an FTC match. The names of OpModes appear on the menu
 * of the FTC Driver Station. When a selection is made from the menu, the corresponding OpMode
 * class is instantiated on the Robot Controller and executed.
 *
 * This particular OpMode just executes a basic Tank Drive Teleop for a two wheeled robot
 * It includes all the skeletal structure that all linear OpModes contain.
 *
 * Use Android Studio to Copy this Class, and Paste it into your team's code folder with a new name.
 * Remove or comment out the @Disabled line to add this opmode to the Driver Station OpMode list
 */

@TeleOp(name="BasicDriveOdeya", group="BasicOpModes")
public class Odeya extends OpModeBase {

    // Declare OpMode members.
    private FourMotorBot robot;

    private IBotAction botAction;

    private DcMotor Elevator;
    private CRServo Claw;


    @Override
    public void run() {
        this.robot.DriveRobot();

        
        // Use gamepad buttons to move the arm up (Y) and down (A)
        if (gamepad1.y)
            Elevator.setPower(-0.5);
        else if (gamepad1.a)
            Elevator.setPower(0.2);
        else
            Elevator.setPower(0.0);

        TelemetryHandler.logData("Status", "Run Time: " + runtime.toString());
        telemetry.addData("odeya", "Orel is the King of my life.");
        telemetry.addData("odeya", "Orel is my King.");


        // Use gamepad buttons to move the Claw Open (B) and Close (B && RT)
        if (gamepad1.b)
            this.Claw.setPower(0.5);
        else if (gamepad1.x)
            this.Claw.setPower(-1.0);
        else
            this.Claw.setPower(0.0);
    }

    @Override
    public void customInit() {
        this.botAction = new SimpleGamePadDrive(this.gamepad1);
        this.robot = new Robot(this.botAction);

        this.Elevator = hardwareMap.get(DcMotor.class, "Elevator");
        this.Claw = hardwareMap.get(CRServo.class, "armOpener");


    }
}

