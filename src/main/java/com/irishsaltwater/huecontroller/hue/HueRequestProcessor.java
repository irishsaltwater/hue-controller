package com.irishsaltwater.huecontroller.hue;

import com.irishsaltwater.huecontroller.hue.dto.HueDTO;
import com.irishsaltwater.huecontroller.hue.dto.HueDTOBuilder;
import com.irishsaltwater.huecontroller.model.LightName;
import com.irishsaltwater.huecontroller.model.LightStatusDTO;
import com.irishsaltwater.huecontroller.model.PlugName;
import org.apache.commons.lang3.NotImplementedException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class HueRequestProcessor {

    private Logger LOGGER = LoggerFactory.getLogger(this.getClass().getName());
    private HueClient hueClient;

    public HueRequestProcessor(HueClient hueClient){
        this.hueClient = hueClient;
    }

    public LightStatusDTO processCustomRequest(LightName lightName, LightStatusDTO lightStatusDTO){
        //convert light status using RGB conversions
        //populate Hue DTO
        //call function to send
        assertLightNameisValid(lightName);
        assertDTOIsValid(lightStatusDTO);

        HueDTO hueDTO = HueDTOBuilder.build(lightStatusDTO);
        //todo: Send HueDTO to Client
        hueClient.sendRequest(lightName, hueDTO);

        //todo implement error case and populate dto with errors
        return lightStatusDTO;
    }

    private void assertLightNameisValid(LightName lightName) {
        if(lightName == null){
            throw new IllegalArgumentException("Light Name is null.");
        }
    }

    public LightStatusDTO turnOnPlug(PlugName plugName){
        hueClient.sendRequest(plugName, HueDTOBuilder.build(DefinedHueSetting.PLUG_ON));
        return null;
    }

    public LightStatusDTO turnOffPlug(PlugName plugName){
        hueClient.sendRequest(plugName, HueDTOBuilder.build(DefinedHueSetting.PLUG_OFF));
        return null;
    }


    public LightStatusDTO turnOnLight(LightName lightName){
        assertLightNameisValid(lightName);
        hueClient.sendRequest(lightName, HueDTOBuilder.build(DefinedHueSetting.ON));
        return null;
    }

    public LightStatusDTO turnOffLight(LightName lightName){
        assertLightNameisValid(lightName);
        hueClient.sendRequest(lightName, HueDTOBuilder.build(DefinedHueSetting.OFF));
        return null;
    }

    public LightStatusDTO dimLight(LightName lightName){
        assertLightNameisValid(lightName);
        hueClient.sendRequest(lightName, HueDTOBuilder.build(DefinedHueSetting.DIMMED));
        return null;
    }

    public LightStatusDTO getLightStatus(LightName lightName){
        throw new NotImplementedException("Get light status is not implemented");
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
    }
}

