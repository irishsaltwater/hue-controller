package com.irishsaltwater.huecontroller.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ColourConverter {

    private static Logger LOGGER = LoggerFactory.getLogger(ColourConverter.class.getName());

    public static List<Double> convertRGBtoXY(Integer inputRed, Integer inputGreen, Integer inputBlue){
        double redNormalised, greenNormalised, blueNormalised;
        double red, green, blue;
        double X, Y, Z;
        Double xToReturn, yToReturn;

        redNormalised = (double) inputRed / 255;
        greenNormalised = (double) inputGreen / 255;
        blueNormalised = (double) inputBlue / 255;

        //Red Conversion Logic
        if(redNormalised > 0.04045){
            red = Math.pow((redNormalised + 0.055) / (1.0 + 0.055), 2.4);
        }else{
            red = redNormalised / 12.92;
        }

        //Green Conversion Logic
        if (greenNormalised > 0.04045) {
            green = Math.pow((greenNormalised + 0.055) / (1.0 + 0.055), 2.4);
        } else {
            green = greenNormalised / 12.92;
        }

        //Blue Conversion Logic
        if (blueNormalised > 0.04045) {
            blue = Math.pow((blueNormalised + 0.055) / (1.0 + 0.055), 2.4);
        } else {
            blue =(blueNormalised / 12.92);
        }

        X = red * 0.649926 + green * 0.103455 + blue * 0.197109;
        Y = red * 0.234327 + green * 0.743075 + blue * 0.022598;
        Z = red * 0.0000000 + green * 0.053077 + blue * 1.035763;
        //todo round?
        xToReturn = X / (X + Y + Z);
        yToReturn = Y / (X + Y + Z);

        return Arrays.asList(xToReturn, yToReturn);
    }
}
