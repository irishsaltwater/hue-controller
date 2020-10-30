package com.irishsaltwater.huecontroller.api;

import com.irishsaltwater.huecontroller.model.LightName;
import com.irishsaltwater.huecontroller.model.LightStatusDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class LightApiDelegateImpl implements LightApiDelegate {

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
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }
}
