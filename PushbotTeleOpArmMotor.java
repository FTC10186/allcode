package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.util.Range;

import org.firstinspires.ftc.teamcode.HardwarePushbot;

/**
 * Created by robotics on 11/14/2016.
 */

@TeleOp(name="Pushbot: Arm Motor", group="Pushbot")

//@Disabled
public class PushbotTeleOpArmMotor extends OpMode{



    HardwarePushbot robot       = new HardwarePushbot(); // use the class created to define a Pushbot's hardware

    final double ROBOT_SPEED_FORWARD = -.3;
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


    public void loop() {
        double left;
        double right;


        // Run arm and winch motors (note: The joystick goes negative when pushed forwards, so negate it)
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
            robot.winchMotor.setPower(.3);
        }

        else if(right < DEAD_ZONE_LOWER) {
            robot.winchMotor.setPower(-1);
        }

        else {
            robot.winchMotor.setPower(0);
        }

        telemetry.addData("left",  "%.2f",  left);
    }




}