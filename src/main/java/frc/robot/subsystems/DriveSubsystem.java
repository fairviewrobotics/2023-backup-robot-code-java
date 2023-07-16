package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
//import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class DriveSubsystem extends SubsystemBase {
    private final WPI_VictorSPX frontLeft = new WPI_VictorSPX(1);
    private final WPI_VictorSPX frontRight = new WPI_VictorSPX(2);
    private final WPI_VictorSPX backLeft = new WPI_VictorSPX(3);
    private final WPI_VictorSPX backRight = new WPI_VictorSPX(4);
    private MotorControllerGroup leftSideGroup = new MotorControllerGroup(frontLeft, backLeft);
    private MotorControllerGroup rightSideGroup = new MotorControllerGroup(frontRight, backRight);
    private DifferentialDrive m_robotDrive;
    public DriveSubsystem() {
        rightSideGroup.setInverted(true);
        m_robotDrive = new DifferentialDrive(leftSideGroup, rightSideGroup);
    }
    public void arcadeDrive(double speed, double rotation)
    {
        m_robotDrive.arcadeDrive(speed/1.5, rotation/1.5);
    }
}
