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
        lightStatusDTO.setBlue(1);
        ResponseEntity<String> response = restTemplate.postForEntity("http://localhost:" + port + "/light/KITCHEN",
                lightStatusDTO, String.class);
        assertEquals(HttpStatus.NOT_IMPLEMENTED, response.getStatusCode());
    }

    @Test
    void postToLight_Kitchen_IncompleteDTO(){
        ResponseEntity<String> response = restTemplate.postForEntity("http://localhost:" + port + "/light/kitchen",
                new LightStatusDTO(), String.class);
        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
    }

    @Test
    void postToLight_NonExisting(){
        ResponseEntity<String> response = restTemplate.postForEntity("http://localhost:" + port + "/light/wrong",
                new LightStatusDTO(), String.class);
        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
    }

}
