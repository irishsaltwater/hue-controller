package com.irishsaltwater.huecontroller.api;

import com.irishsaltwater.huecontroller.hue.HueRequestProcessor;
import com.irishsaltwater.huecontroller.model.LightName;
import com.irishsaltwater.huecontroller.model.LightStatusDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class LightApiDelegateImpl implements LightApiDelegate {

    Logger LOGGER = LoggerFactory.getLogger(this.getClass().getName());

    final HueRequestProcessor hueRequestProcessor;

    public LightApiDelegateImpl(HueRequestProcessor hueRequestProcessor) {
        this.hueRequestProcessor = hueRequestProcessor;
    }

    /**
     * POST /light/{lightName} : Sets the values on the light specified in the path
     *
     * @param lightName Parameter description in CommonMark or HTML. (required)
     * @param body  (required)
     * @return OK (status code 200)
     * @see LightApi#setLight
     */
    public ResponseEntity<Void> setLight(LightName lightName,
                                         LightStatusDTO body) {
        LOGGER.info("Request received to set light {} to custom setting", lightName.getValue());

        return new ResponseEntity<>(HttpStatus.OK);
    }

    /**
     * GET /light/{LightName} : Gets the values of the light specified in the path
     *
     * @param lightName The name of the light to get (required)
     * @return OK (status code 200)
     * @see LightApi#getLight
     */
    public ResponseEntity<LightStatusDTO> getLight(LightName lightName) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"red\" : \"\", \"green\" : \"\", \"brightness\" : \"\", \"blue\" : \"\" }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

    /**
     * PUT /light/{LightName}/off : Turns off the light
     *
     * @param lightName The name of the light to turn off (required)
     * @return OK (status code 200)
     * @see LightApi#turnOffLight
     */
    public ResponseEntity<Void> turnOffLight(LightName lightName) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

    /**
     * PUT /light/{LightName}/on : Turns on the light to default brightness and colour
     *
     * @param lightName The name of the light to turn on (required)
     * @return OK (status code 200)
     * @see LightApi#turnOnLight
     */
    public ResponseEntity<Void> turnOnLight(LightName lightName) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }
}
