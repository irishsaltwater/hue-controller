package com.irishsaltwater.huecontroller.hue;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.irishsaltwater.huecontroller.hue.dto.HueDTO;
import com.irishsaltwater.huecontroller.hue.dto.HueDTOBuilder;
import com.irishsaltwater.huecontroller.model.LightName;
import io.swagger.models.Scheme;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

@Component
public class HueClient {

    private static Logger LOGGER = LoggerFactory.getLogger(HueClient.class.getName());

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


    public HueDTO sendRequest(LightName lightName, HueDTO hueDTO){
        LOGGER.info("Sending request to light {}", lightName);

        //build URL
        String url = buildFullURL(lightName);
        LOGGER.debug("Request being sent to URL: {}", url);

        //build JSON payload
        String payload = buildJsonStringFromDTO(hueDTO);

        //send
        RestTemplate restTemplate = new RestTemplate();
        //todo Method to read response
        restTemplate.put(url, payload);
        //return response?
        return hueDTO;
    }

    protected String buildJsonStringFromDTO(HueDTO hueDTO) {
        ObjectMapper mapper = new ObjectMapper();
        mapper.enable(SerializationFeature.INDENT_OUTPUT);
        String json = "ErrorOccurred";
        try {
            json = mapper.writeValueAsString(hueDTO);
        } catch (JsonProcessingException e) {
            LOGGER.error("Error converting HueDTO to JSON string.");
            e.getStackTrace();
        }

        LOGGER.debug("Object Converted to JSON");
        LOGGER.debug(json);

        return json;
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
        String pathToLight = "/api/" + hueApiKey + "/{light-number}/state";
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
