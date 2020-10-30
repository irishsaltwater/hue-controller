package com.irishsaltwater.huecontroller.hue;

import com.irishsaltwater.huecontroller.model.LightName;
import com.irishsaltwater.huecontroller.model.LightStatusDTO;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HueRequestProcessorTest {

    private HueRequestProcessor processor = new HueRequestProcessor();

    @Test
    void processCustomRequest(){
        LightStatusDTO lightStatusDTO = generateLightStatusDTO();
        LightStatusDTO returnedLightStatusDTO = processor.processCustomRequest(LightName.BEDROOM, lightStatusDTO);

        assertEquals(lightStatusDTO.getBlue(), returnedLightStatusDTO.getBlue());
        assertEquals(lightStatusDTO.getRed(), returnedLightStatusDTO.getRed());
        assertEquals(lightStatusDTO.getGreen(), returnedLightStatusDTO.getGreen());
        assertEquals(lightStatusDTO.getBrightness(), returnedLightStatusDTO.getBrightness());
    }

    @Test
    void processCustomRequest_invalidLightName(){
        LightStatusDTO lightStatusDTO = generateLightStatusDTO();

        assertThrows(IllegalArgumentException.class, () ->{ processor.processCustomRequest(null, lightStatusDTO);});
    }

    @Test
    void processCustomRequest_invalidPayload(){
        LightStatusDTO lightStatusDTO = generateLightStatusDTO();

        assertThrows(IllegalArgumentException.class, () ->{ processor.processCustomRequest(LightName.BEDROOM, new LightStatusDTO());});
    }

    @Test
    void processCustomRequest_nullPayload(){
        assertThrows(IllegalArgumentException.class, () ->{ processor.processCustomRequest(LightName.BEDROOM, null);});
    }

    @Test
    void turnOnLight(){
        //need expected lightstatus DTO here.
    }

    @Test
    void turnOnLight_nullValue(){
        assertThrows(IllegalArgumentException.class, () ->{ processor.turnOnLight(null);});
    }

    @Test
    void turnOffLight_nullValue(){
        assertThrows(IllegalArgumentException.class, () ->{ processor.turnOffLight(null);});
    }

    @Test
    void getLightStatus_nullValue(){
        assertThrows(IllegalArgumentException.class, () ->{ processor.getLightStatus(null);});
    }

    private LightStatusDTO generateLightStatusDTO() {
        LightStatusDTO lightStatusDTO = new LightStatusDTO();
        lightStatusDTO.setBrightness(100);
        lightStatusDTO.setRed(5);
        lightStatusDTO.setBlue(10);
        lightStatusDTO.setGreen(15);
        return lightStatusDTO;
    }

}
