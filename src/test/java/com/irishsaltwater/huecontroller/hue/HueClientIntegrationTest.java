package com.irishsaltwater.huecontroller.hue;

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

    @Autowired
    HueClient hueClient;

    @Value("${hue.bridge.address}")
    private String hueAddress;

    @Value("${hue.bridge.apikey}")
    private String hueApiKey;

    @Test
    void buildFullURL_Kitchen(){
        String url = hueClient.buildFullURL(LightName.KITCHEN);
        String expectedURL = "http://" + hueAddress + "/api/" + hueApiKey + "/4";
        assertEquals(expectedURL, url);
    }
}
