package com.irishsaltwater.huecontroller.api;

import com.irishsaltwater.huecontroller.hue.HueRequestProcessor;
import com.irishsaltwater.huecontroller.model.PlugName;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class PlugApiDelegateImpl implements PlugApiDelegate {

    Logger LOGGER = LoggerFactory.getLogger(this.getClass().getName());

    final HueRequestProcessor hueRequestProcessor;

    public PlugApiDelegateImpl(HueRequestProcessor hueRequestProcessor){
        this.hueRequestProcessor = hueRequestProcessor;
    }

    /**
     * GET /plug/{PlugName}/off : Turns off the plug
     *
     * @param plugName The name of the plug to turn off (required)
     * @return OK (status code 200)
     * @see PlugApi#plugOff
     */
    public ResponseEntity<Void> plugOff(PlugName plugName) {
        LOGGER.info("Received request to turn off plug " + plugName);
        hueRequestProcessor.turnOffPlug(plugName);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    /**
     * GET /plug/{PlugName}/on : Turns on the plug
     *
     * @param plugName The name of the plug to turn on (required)
     * @return OK (status code 200)
     * @see PlugApi#plugOn
     */
    public ResponseEntity<Void> plugOn(PlugName plugName) {
        LOGGER.info("Received request to turn on plug " + plugName);
        hueRequestProcessor.turnOnPlug(plugName);
        return new ResponseEntity<>(HttpStatus.OK);

    }
}
