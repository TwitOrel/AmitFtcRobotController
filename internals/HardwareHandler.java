package org.firstinspires.ftc.teamcode.internals;

import com.qualcomm.robotcore.hardware.HardwareMap;

public class HardwareHandler {
    private static HardwareMap hwMap;

    public static void InitializeHardwareMap(HardwareMap srcHwMap)
    {
        hwMap = srcHwMap;
    }

    public static  <T> T GetHardwareItem(Class<? extends T> classOrInterface, String deviceName)
    {
        return hwMap.get(classOrInterface, deviceName);
    }
}
