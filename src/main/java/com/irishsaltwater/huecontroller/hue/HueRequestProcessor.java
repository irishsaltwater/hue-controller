package com.irishsaltwater.huecontroller.hue;

import com.irishsaltwater.huecontroller.model.LightName;
import com.irishsaltwater.huecontroller.model.LightStatusDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class HueRequestProcessor {

    private Logger LOGGER = LoggerFactory.getLogger(this.getClass().getName());

    public LightStatusDTO processCustomRequest(LightName lightName, LightStatusDTO lightStatusDTO){
        //convert light status using RGB conversions
        //populate Hue DTO
        //call function to send
        assertLightNameisValid(lightName);
        assertDTOIsValid(lightStatusDTO);

        

        //todo implement error case and populate dto
        return null;
    }

    private void assertLightNameisValid(LightName lightName) {
        if(lightName == null){
            throw new IllegalArgumentException("Light Name is null.");
        }
    }

    public LightStatusDTO turnOnLight(LightName lightName){
        //use DTO factory to get preexisting payload to send.
        assertLightNameisValid(lightName);
        return null;
    }

    public LightStatusDTO turnOffLight(LightName lightName){
        //use DTO factory to get preexisting payload to send
        assertLightNameisValid(lightName);
        return null;
    }

    public LightStatusDTO getLightStatus(LightName lightName){
        assertLightNameisValid(lightName);
        return null;
    }

    private void assertDTOIsValid(LightStatusDTO lightStatusDTO){
        if(lightStatusDTO == null){
            throw new IllegalArgumentException("Light Status DTO is null.");
        }
        if (lightStatusDTO.getBlue() == null){
            throw new IllegalArgumentException("Blue is set to null");
        }
        if (lightStatusDTO.getRed() == null){
            throw new IllegalArgumentException("Red is set to null");
        }
        if (lightStatusDTO.getGreen() == null){
            throw new IllegalArgumentException("Green is set to null");
        }
        if (lightStatusDTO.getBrightness() == null){
            throw new IllegalArgumentException("Brightness is set to null");
        }
    }
}

