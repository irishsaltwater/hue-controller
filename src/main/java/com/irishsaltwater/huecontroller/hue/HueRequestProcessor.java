package com.irishsaltwater.huecontroller.hue;

import com.irishsaltwater.huecontroller.model.LightName;
import com.irishsaltwater.huecontroller.model.LightStatusDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class HueRequestProcessor {

    Logger LOGGER = LoggerFactory.getLogger(this.getClass().getName());

    public LightStatusDTO processCustomRequest(LightName lightName, LightStatusDTO lightStatusDTO){
        //convert light status using RGB conversions
        //populate Hue DTO
        //call function to send

        //todo implement error case and populate dto
        return null;
    }

    public LightStatusDTO turnOnLight(LightName lightName){
        //use DTO factory to get preexisting payload to send.
        return null;
    }

    public LightStatusDTO turnOffLight(LightName lightName){
        //use DTO factory to get preexisting payload to send
        return null;
    }

    public LightStatusDTO getLightStatus(LightName lightName){
        return null;
    }
}

