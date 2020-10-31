package com.irishsaltwater.huecontroller.hue;

import com.irishsaltwater.huecontroller.hue.dto.HueDTO;
import com.irishsaltwater.huecontroller.model.LightName;
import io.swagger.models.Scheme;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

@Component
public class HueClient {

    @Value("${hue.bridge.address}")
    private String hueAddress;

    @Value("${hue.bridge.apikey}")
    private String hueApiKey;

    @Value("${hue.light.bedroom}")
    private String bedroomNumber;

    @Value("${hue.light.sittingroom}")
    private String sittingroomNumber;

    @Value("${hue.light.kitchen}")
    private String kitchenNumber;

    @Value("${hue.light.cinema}")
    private String cinemaNumber;


    public void sendRequest(LightName lightName, HueDTO hueDTO){
        //build URL
        //build JSON payload
        //send
        //return response
    }

    protected String buildFullURL(LightName lightName){
        UriComponentsBuilder uriComponentsBuilder = buildBaseURL();
        UriComponents uriComponents = uriComponentsBuilder.buildAndExpand(mapLightToNumber(lightName));

        return uriComponents.toString();
    }

    /**
     * Builds the full base URL pointing to the Hue Bridge, including API key
     * @returns a String in the format 127.0.0.1/api/<key>/</key>
     */
    private UriComponentsBuilder buildBaseURL(){
        String pathToLight = "/api/" + hueApiKey + "/{light-number}";
        return UriComponentsBuilder.newInstance().scheme(Scheme.HTTP.toValue()).host(hueAddress).path(pathToLight);
    }


    private String mapLightToNumber(LightName lightName){
        switch (lightName){
            case CINEMA:
                return cinemaNumber;
            case BEDROOM:
                return bedroomNumber;
            case KITCHEN:
                return kitchenNumber;
            case GUESTROOM:
                return "1"; //todo: Implement
            case SITTINGROOM:
                return sittingroomNumber;
        }
        return "";
    }
}
