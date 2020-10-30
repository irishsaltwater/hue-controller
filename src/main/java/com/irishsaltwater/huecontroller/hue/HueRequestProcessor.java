package com.irishsaltwater.huecontroller.hue;

import com.irishsaltwater.huecontroller.model.LightName;
import com.irishsaltwater.huecontroller.model.LightStatusDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class HueRequestProcessor {

    Logger LOGGER = LoggerFactory.getLogger(this.getClass().getName());

    public void processCustomRequest(LightName lightName, LightStatusDTO lightStatusDTO){
        //convert light status using RGB conversions
        //populate DTO
    }

    public void turnOnLight(LightName lightName){
        //use DTO factory to get preexisting payload to send
    }

    public void turnOffLight(LightName lightName){
        //use DTO factory to get preexisting payload to send
    }

    public LightStatusDTO getLightStatus(LightName lightName){

    }
}
