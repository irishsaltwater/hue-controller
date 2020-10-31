package com.irishsaltwater.huecontroller.hue.dto;

import com.irishsaltwater.huecontroller.hue.DefinedHueSetting;
import com.irishsaltwater.huecontroller.model.LightStatusDTO;
import com.irishsaltwater.huecontroller.util.ColourConverter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.xml.bind.helpers.AbstractUnmarshallerImpl;
import java.util.List;

import static com.irishsaltwater.huecontroller.hue.dto.DefaultHueParameters.*;

public class HueDTOBuilder {

    private static Logger LOGGER = LoggerFactory.getLogger(HueDTOBuilder.class.getName());

    private HueDTOBuilder() {
    }

    ;

    public static HueDTO build(LightStatusDTO lightStatusDTO) {
        LOGGER.info("Building HueDTO for LightStatusDTO");
        HueDTO hueDTO = new HueDTO();

        hueDTO.setOn(true);
        hueDTO.setSat(DEFAULT_SAT);
        hueDTO.setHue(DEFAULT_HUE);
        hueDTO.setBri(lightStatusDTO.getBrightness() == null ? DEFAULT_BRI : lightStatusDTO.getBrightness()); //Bad developer, no cookie

        List<Double> XYColour = ColourConverter.convertRGBtoXY(lightStatusDTO.getRed(),
                lightStatusDTO.getGreen(),
                lightStatusDTO.getBlue());
        hueDTO.setXy(XYColour);

        //todo LOG dto to String (or do at point of JSON payload)
        return hueDTO;
    }

    public static HueDTO build(DefinedHueSetting definedHueSetting) {
        HueDTO hueDTO = new HueDTO();
        //todo build correct dto
        switch (definedHueSetting) {
            case ON:
                hueDTO = buildDefaultDTOforOn();
                break;
            case OFF:
                hueDTO = buildDefaultDTOforOff();
            case DIMMED:
                hueDTO = buildDefaultDTOforDimmed();
        }
        return hueDTO;
    }

    private static HueDTO buildDefaultDTOforDimmed() {
        HueDTO hueDTO = new HueDTO();
        return null;
    }

    private static HueDTO buildDefaultDTOforOff() {

        return null;
    }

    private static HueDTO buildDefaultDTOforOn() {
        return null;
    }

}
