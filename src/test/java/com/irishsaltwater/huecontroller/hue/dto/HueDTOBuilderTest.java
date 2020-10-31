package com.irishsaltwater.huecontroller.hue.dto;

import com.irishsaltwater.huecontroller.hue.DefinedHueSetting;
import com.irishsaltwater.huecontroller.model.LightStatusDTO;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HueDTOBuilderTest {

    private static final double RED_X = 0.6822;
    private static final double RED_Y = 0.3064;
    //Todo: add tests for more colours

    //Pre-defined settings tests
    @Test
    void buildPredefined_withFullBrightness(){
        HueDTO hueDTO =  HueDTOBuilder.build(DefinedHueSetting.ON);
        HueDTO expectedHueDTO = generateHueDTO_FullBrightness();

        assertEquals(expectedHueDTO.isOn(), hueDTO.isOn());
        assertEquals(expectedHueDTO.getBri(), hueDTO.getBri());
        assertEquals(expectedHueDTO.getHue(), hueDTO.getHue());
        assertEquals(expectedHueDTO.getSat(), hueDTO.getSat());
    }

    @Test
    void buildPredefined_withMiddleBrightness(){
        HueDTO hueDTO =  HueDTOBuilder.build(DefinedHueSetting.DIMMED);
        HueDTO expectedHueDTO = generateHueDTO_Dimmed();

        assertEquals(expectedHueDTO.isOn(), hueDTO.isOn());
        assertEquals(expectedHueDTO.getBri(), hueDTO.getBri());
        assertEquals(expectedHueDTO.getHue(), hueDTO.getHue());
        assertEquals(expectedHueDTO.getSat(), hueDTO.getSat());
    }

    @Test
    void buildPredefined_Off(){
        HueDTO hueDTO =  HueDTOBuilder.build(DefinedHueSetting.OFF);
        HueDTO expectedHueDTO = generateHueDTO_Dimmed();

        assertEquals(expectedHueDTO.isOn(), hueDTO.isOn());
        assertEquals(expectedHueDTO.getBri(), hueDTO.getBri());
        assertEquals(expectedHueDTO.getHue(), hueDTO.getHue());
        assertEquals(expectedHueDTO.getSat(), hueDTO.getSat());
    }

    //Custom Colours
    @Test
    void buildCustom_Red(){
        LightStatusDTO lightStatusDTO = generateLightStatusDTO_Red();
        HueDTO hueDTO =  HueDTOBuilder.build(lightStatusDTO);
        HueDTO expectedHueDTO = generateHueDTO_Red();

        assertEquals(expectedHueDTO.isOn(), hueDTO.isOn());
        assertEquals(expectedHueDTO.getBri(), hueDTO.getBri());
        assertEquals(expectedHueDTO.getHue(), hueDTO.getHue());
        assertEquals(expectedHueDTO.getSat(), hueDTO.getSat());
        //assertArrayEquals(expectedHueDTO.getXy(), hueDTO.getXy());
        //assertEquals(expectedHueDTO.getXy().get(0), hueDTO.getXy().get(0));
        assertEquals(expectedHueDTO.getXy().get(1), hueDTO.getXy().get(1));
    }

    //These values are defaults, need to do them for non-default, like purple etc
    //todo builders for expected values, pull from node file
    private LightStatusDTO generateLightStatusDTO_FullBrightness() {
        LightStatusDTO lightStatusDTO = new LightStatusDTO();
        lightStatusDTO.setBrightness(254);
        lightStatusDTO.setRed(255);
        lightStatusDTO.setBlue(255);
        lightStatusDTO.setGreen(255);
        return lightStatusDTO;
    }

    private HueDTO generateHueDTO_FullBrightness() {
        HueDTO hueDTO = new HueDTO();
        hueDTO.setOn(true);
        hueDTO.setBri(254);
        hueDTO.setHue(8402);
        hueDTO.setSat(140);
        return hueDTO;
    }

    private HueDTO generateHueDTO_Dimmed() {
        HueDTO hueDTO = new HueDTO();
        hueDTO.setOn(true);
        hueDTO.setBri(77);
        hueDTO.setHue(8402);
        hueDTO.setSat(140);
        return hueDTO;
    }

    private HueDTO generateHueDTO_Off() {
        HueDTO hueDTO = new HueDTO();
        hueDTO.setOn(false);
        return hueDTO;
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

    private HueDTO generateHueDTO_Red() { //todo: unsure if these are the correct values for 254, 0, 0
        HueDTO hueDTO = new HueDTO();
        hueDTO.setOn(true);
        hueDTO.setBri(254);
        hueDTO.setHue(8418);
        hueDTO.setSat(140);
        hueDTO.getXy().add(RED_X);
        hueDTO.getXy().add(RED_Y);
        return hueDTO;
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
