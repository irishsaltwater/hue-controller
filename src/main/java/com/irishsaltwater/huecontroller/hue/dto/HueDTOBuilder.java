package com.irishsaltwater.huecontroller.hue.dto;

import com.irishsaltwater.huecontroller.hue.DefinedHueSetting;
import com.irishsaltwater.huecontroller.model.LightStatusDTO;

import javax.xml.bind.helpers.AbstractUnmarshallerImpl;

public class HueDTOBuilder {
    private HueDTOBuilder(){};

    public static HueDTO build(LightStatusDTO lightStatusDTO){
        HueDTO hueDTO = new HueDTO();
        //todo conversion
        return hueDTO;
    }

    public static HueDTO build(DefinedHueSetting definedHueSetting){
        HueDTO hueDTO = new HueDTO();
        //todo build correct dto
        return hueDTO;
    }

}
