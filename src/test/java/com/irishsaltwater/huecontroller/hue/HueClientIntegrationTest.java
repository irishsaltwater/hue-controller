package com.irishsaltwater.huecontroller.hue;

import com.irishsaltwater.huecontroller.hue.dto.HueDTO;
import com.irishsaltwater.huecontroller.model.LightName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
class HueClientIntegrationTest {

    private static final String JSON_PAYLOAD_ON = "{\r\n" +
            "  \"on\" : true,\r\n" +
            "  \"bri\" : 254,\r\n" +
            "  \"hue\" : 8402,\r\n" +
            "  \"sat\" : 140\r\n" +
            "}";

    @Autowired
    HueClient hueClient;

    @Value("${hue.bridge.address}")
    private String hueAddress;

    @Value("${hue.bridge.apikey}")
    private String hueApiKey;

    @Test
    void buildFullURL_Kitchen(){
        String url = hueClient.buildFullURL(LightName.KITCHEN);
        String expectedURL = "http://" + hueAddress + "/api/" + hueApiKey + "/4/state";
        assertEquals(expectedURL, url);
    }

    @Test
    void buildJsonStringFromDTO(){
        HueDTO hueDTO = new HueDTO();
        hueDTO.setOn(true);
        hueDTO.setBri(254);
        hueDTO.setHue(8402);
        hueDTO.setSat(140);

        String jsonPayload = hueClient.buildJsonStringFromDTO(hueDTO);
        assertEquals(JSON_PAYLOAD_ON, jsonPayload);
    }
}
