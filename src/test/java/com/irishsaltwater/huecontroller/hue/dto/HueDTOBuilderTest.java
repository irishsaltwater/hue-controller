package com.irishsaltwater.huecontroller.hue.dto;

import com.irishsaltwater.huecontroller.model.LightStatusDTO;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HueDTOBuilderTest {

    @Test
    void constructor_withFullBrightness(){
        HueDTO hueDTO =  HueDTOBuilder.build(generateLightStatusDTO_FullBrightness());
    }

    //todo builders for expected values, pull from node file
    private LightStatusDTO generateLightStatusDTO_FullBrightness() {
        LightStatusDTO lightStatusDTO = new LightStatusDTO();
        lightStatusDTO.setBrightness(254);
        lightStatusDTO.setRed(255);
        lightStatusDTO.setBlue(255);
        lightStatusDTO.setGreen(255);
        return lightStatusDTO;
    }

    private LightStatusDTO generateLightStatusDTO_MiddleBrightness() {
        LightStatusDTO lightStatusDTO = new LightStatusDTO();
        lightStatusDTO.setBrightness(77);
        lightStatusDTO.setRed(255);
        lightStatusDTO.setBlue(255);
        lightStatusDTO.setGreen(255);
        return lightStatusDTO;
    }

    private LightStatusDTO generateLightStatusDTO_Red() {
        LightStatusDTO lightStatusDTO = new LightStatusDTO();
        lightStatusDTO.setBrightness(254);
        lightStatusDTO.setRed(254);
        lightStatusDTO.setBlue(0);
        lightStatusDTO.setGreen(0);
        return lightStatusDTO;
    }

    private LightStatusDTO generateLightStatusDTO_Green() {
        LightStatusDTO lightStatusDTO = new LightStatusDTO();
        lightStatusDTO.setBrightness(254);
        lightStatusDTO.setRed(0);
        lightStatusDTO.setBlue(0);
        lightStatusDTO.setGreen(254);
        return lightStatusDTO;
    }

    private LightStatusDTO generateLightStatusDTO_Blue() {
        LightStatusDTO lightStatusDTO = new LightStatusDTO();
        lightStatusDTO.setBrightness(254);
        lightStatusDTO.setRed(0);
        lightStatusDTO.setBlue(254);
        lightStatusDTO.setGreen(0);
        return lightStatusDTO;
    }

}
