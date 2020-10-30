package com.irishsaltwater.huecontroller.api;

import com.irishsaltwater.huecontroller.model.LightStatusDTO;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;

class LightApiDelegateImplTest extends BaseIntegrationTest {

    @Test
    void postToLight_Kitchen(){
        LightStatusDTO lightStatusDTO = new LightStatusDTO();

        int blue = 1;
        int red = 2;
        int green = 3;
        int brightness = 4;

        lightStatusDTO.setBlue(blue);
        lightStatusDTO.setRed(red);
        lightStatusDTO.setGreen(green);
        lightStatusDTO.setBrightness(brightness);
        ResponseEntity<LightStatusDTO> response = restTemplate.postForEntity("http://localhost:" + port + "/v1/light/KITCHEN",
                lightStatusDTO, LightStatusDTO.class);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
        assertEquals(blue, response.getBody().getBlue());
        assertEquals(red, response.getBody().getRed());
        assertEquals(green, response.getBody().getGreen());
        assertEquals(brightness, response.getBody().getBrightness());
    }

    @Test //todo No validation?
    void postToLight_Kitchen_IncorrectValues(){
        LightStatusDTO lightStatusDTO = new LightStatusDTO();
        lightStatusDTO.setBlue(-1);
        lightStatusDTO.setRed(-1);
        lightStatusDTO.setGreen(-1);
        lightStatusDTO.setBrightness(-1);
        ResponseEntity<String> response = restTemplate.postForEntity("http://localhost:" + port + "/v1/light/KITCHEN",
                lightStatusDTO, String.class);
        assertEquals(HttpStatus.NOT_IMPLEMENTED, response.getStatusCode());
    }

    @Test
    void postToLight_Kitchen_IncompleteDTO(){
        ResponseEntity<String> response = restTemplate.postForEntity("http://localhost:" + port + "/v1/light/kitchen",
                new LightStatusDTO(), String.class);
        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
    }

    @Test
    void postToLight_NonExisting(){
        ResponseEntity<String> response = restTemplate.postForEntity("http://localhost:" + port + "/v1/light/wrong",
                new LightStatusDTO(), String.class);
        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
    }

    //assert PUT operation allowed
    //Put from rest template doesn't allow a response be captured
    @Test
    void turnOnLight_Kitchen(){
        LightStatusDTO lightStatusDTO = new LightStatusDTO();
        restTemplate.put("http://localhost:" + port + "/v1/light/KITCHEN/on", null);
    }

}
