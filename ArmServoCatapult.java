package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.Range;
import java.lang.Thread;

import org.firstinspires.ftc.teamcode.HardwarePushbot;

/**
 * Created by robotics on 11/14/2016.
 */

@TeleOp(name="Pushbot: Servo Catapult", group="Pushbot")

//@Disabled
public class ArmServoCatapult extends OpMode {

    static final double INCREMENT   = 0.01;     // amount to slew servo each CYCLE_MS cycle
    static final int    CYCLE_MS    =   50;     // period of each cycle
    static final double MAX_POS     =  1.0;     // Maximum rotational position
    static final double MIN_POS     =  0.0;     // Minimum rotational position
    final double ROBOT_SPEED_FORWARD = -.3;
    final double ROBOT_SPEED_BACKWARDS = -1*(ROBOT_SPEED_FORWARD);

    final double DEAD_ZONE = .1;
    final double DEAD_ZONE_LOWER = -1*(DEAD_ZONE);

    Servo servo;
    //double  position = (MAX_POS - MIN_POS) / 2; // Start at halfway position
    boolean position1;
    boolean position2;
    boolean YcodeRun = false;


    HardwarePushbot robot = new HardwarePushbot(); // use the class created to define a Pushbot's hardware

    @Override
    public void init() {
        /* Initialize the hardware variables.
         * The init() method of the hardware class does all the work here
         */
        robot.init(hardwareMap);

        //telemetry.addData(">", "Press Start to scan Servo." );
        //telemetry.update();


        // Send telemetry message to signify robot waiting;
        //telemetry.addData("Say", "Hello Driver");    //
    }


    public void loop() {
        servo = hardwareMap.servo.get("catapult");

        double left;
        double right;
        Thread t;


        int i = 5;
        //waitForStart();
        position1 = gamepad2.dpad_down;
        position2 = gamepad2.dpad_up;

        if (position1){
            robot.catapult.setPosition(.5);
        }

        if (position2){
            robot.catapult.setPosition(0);
        }

       /* //boolean lastlever;
        if(lever && position&&!YcodeRun) {
            lever = false;
            position = false;
            YcodeRun = true;

            
        }

        else if(lever && !position && !YcodeRun){
            lever = false;
            position = true;
            YcodeRun = true;

        }

        if (YcodeRun && !lever){
            YcodeRun  = false;
        }

        if (position) {
            robot.catapult.setPosition(.5);

        }

        else if (!position) {
            robot.catapult.setPosition(0);
         }
         */





        //telemetry.addData("servo",  "%.2f",  servo);

    }


}
