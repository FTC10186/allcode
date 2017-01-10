package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.util.Range;

import org.firstinspires.ftc.teamcode.HardwarePushbot;

/**
 * Created by robotics on 11/14/2016.
 */

@TeleOp(name="Pushbot: Run Motor", group="Pushbot")

//@Disabled
public class PushbotTeleOpRunMotor extends OpMode {


    HardwarePushbot robot = new HardwarePushbot(); // use the class created to define a Pushbot's hardware

    @Override
    public void init() {
        /* Initialize the hardware variables.
         * The init() method of the hardware class does all the work here
         */
        robot.init(hardwareMap);


        // Send telemetry message to signify robot waiting;
        //telemetry.addData("Say", "Hello Driver");    //
    }


    public void loop() {
        robot.armMotor.setPower(1);
        robot.leftMotor.setPower(1);
        robot.rightMotor.setPower(1);
    }
}


