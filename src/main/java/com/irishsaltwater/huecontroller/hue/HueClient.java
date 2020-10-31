package com.irishsaltwater.huecontroller.hue;

import com.irishsaltwater.huecontroller.hue.dto.HueDTO;
import com.irishsaltwater.huecontroller.model.LightName;
import org.springframework.stereotype.Component;

@Component
public class HueClient {

    public void sendRequest(LightName lightName, HueDTO hueDTO){
        //will take HueRequestDTO
        // will build appropriate URL to send to
        // URL built based on default info, api key, PLUS light name
        // default info pulled from property file
        //will send request
    }

}
