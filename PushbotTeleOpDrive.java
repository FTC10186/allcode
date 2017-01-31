/*
Copyright (c) 2016 Robert Atkinson
All rights reserved.
Redistribution and use in source and binary forms, with or without modification,
are permitted (subject to the limitations in the disclaimer below) provided that
the following conditions are met:
Redistributions of source code must retain the above copyright notice, this list
of conditions and the following disclaimer.
Redistributions in binary form must reproduce the above copyright notice, this
list of conditions and the following disclaimer in the documentation and/or
other materials provided with the distribution.
Neither the name of Robert Atkinson nor the names of his contributors may be used to
endorse or promote products derived from this software without specific prior
written permission.
NO EXPRESS OR IMPLIED LICENSES TO ANY PARTY'S PATENT RIGHTS ARE GRANTED BY THIS
LICENSE. THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
"AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO,
THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESSFOR A PARTICULAR PURPOSE
ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE
FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL
DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER
CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR
TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF
THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
*/
package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.util.Range;

import org.firstinspires.ftc.teamcode.HardwarePushbot;

/**
 * Created by robotics on 11/7/2016.
 */

@TeleOp(name="Pushbot: Teleop Drive", group="Pushbot")
//@Disabled
public class PushbotTeleOpDrive extends OpMode{

    HardwarePushbot robot       = new HardwarePushbot(); // use the class created to define a Pushbot's hardware

    final double ROBOT_SPEED_FORWARD = -1;
    final double ROBOT_SPEED_BACKWARDS = -1*(ROBOT_SPEED_FORWARD);

    final double DEAD_ZONE = .1;
    final double DEAD_ZONE_LOWER = -1*(DEAD_ZONE);

    double leftMinusRight = 0;
    double leftPlusRight = 0;

    @Override
    public void init() {
        /* Initialize the hardware variables.
         * The init() method of the hardware class does all the work here
         */
        robot.init(hardwareMap);


        // Send telemetry message to signify robot waiting;
        telemetry.addData("Say", "Hello Driver");    //
    }


    @Override
    public void loop() {
        double left;
        double right;

        // Run wheels in tank mode (note: The joystick goes negative when pushed forwards, so negate it)
        left = -gamepad1.left_stick_y;
        right = -gamepad1.right_stick_x;
        /*robot.leftMotor.setPower(left);
          robot.rightMotor.setPower(right);*/

        if(left < DEAD_ZONE && left > DEAD_ZONE_LOWER) {
            left = 0;
        }
        if(right < DEAD_ZONE && right > DEAD_ZONE_LOWER) {
            right = 0;
        }
        leftMinusRight = left - (.9*right);
        leftPlusRight = left + (.9*right);

        double leftMinusRightMagnitude = Math.abs(leftMinusRight);
        double leftPlusRightMagnitude = Math.abs(leftPlusRight);
        if(leftMinusRightMagnitude > 1) {
            robot.leftMotor.setPower(leftMinusRight / leftMinusRightMagnitude);
            robot.rightMotor.setPower(leftPlusRight / leftMinusRightMagnitude);
        }
        else if(leftPlusRightMagnitude > 1) {
            robot.leftMotor.setPower(leftMinusRight / leftPlusRightMagnitude);
            robot.rightMotor.setPower(leftPlusRight / leftPlusRightMagnitude);
        }
        else {
            robot.leftMotor.setPower(leftMinusRight);
            robot.rightMotor.setPower(leftPlusRight);
        }

        telemetry.addData("left",  "%.2f", left);
        telemetry.addData("right", "%.2f", right);

        //___________________________________________________________________________________________________________________


        // Run arm and winch motors (note: The joystick goes negative when pushed forwards, so negate it)
        /*****
        left = -gamepad2.left_stick_y;
        right = -gamepad2.right_stick_x;

        if(left > DEAD_ZONE) {
            robot.armMotor.setPower(.5);
        }

        else if(left < DEAD_ZONE_LOWER) {
            robot.armMotor.setPower(-.5);
        }
        else {
            robot.armMotor.setPower (0);
        }

        telemetry.addData("left",  "%.2f", left);




        if(right > DEAD_ZONE) {
            robot.winchMotor.setPower(.6);
        }

        else if(right < DEAD_ZONE_LOWER) {
            robot.winchMotor.setPower(-1);
        }

        else {
            robot.winchMotor.setPower(0);
        }

        telemetry.addData("left",  "%.2f",  left);
    }*/
    }






}