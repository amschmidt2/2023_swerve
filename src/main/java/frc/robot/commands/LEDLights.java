package frc.robot.commands;

import edu.wpi.first.wpilibj.AddressableLED;
import edu.wpi.first.wpilibj.AddressableLEDBuffer;

public class LEDLights {

    // Test LED 31 in length
    private static final AddressableLED m_led = new AddressableLED(9);
    private static final AddressableLEDBuffer m_ledBuffer = new AddressableLEDBuffer(1);

    public LEDLights() {

    }

    // @Override
    public static void robotInit() {
        // PWM port 9
        // Must be a PWM header, not MXP or DIO
        
        // Reuse buffer
        // Default to a length of 60, start empty output
        // Length is expensive to set, so only set it once, then just update data
        m_led.setLength(m_ledBuffer.getLength());

        // Set the data
        m_led.setData(m_ledBuffer);
        m_led.start();
    }

    public static void changeColor(int r, int g, int b) {
        for (int i = 0; i < m_ledBuffer.getLength(); i++) {
        // Sets the specified LED to the RGB values for red
        m_ledBuffer.setRGB(i, r, g, b);
        }

        m_led.setData(m_ledBuffer);    
    }


}
