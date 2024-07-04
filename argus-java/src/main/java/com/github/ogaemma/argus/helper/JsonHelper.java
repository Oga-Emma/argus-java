package com.github.ogaemma.argus.helper;

import com.fasterxml.jackson.jr.ob.JSON;
import com.github.ogaemma.argus.model.ArgusEvent;

import java.io.IOException;
import java.time.OffsetDateTime;
import java.util.Map;

public class JsonHelper {
    public static Boolean isJson(String data){
        try {
            JSON.std.mapFrom(data);
        } catch (IOException e) {
            return false;
        }

        return true;
    }

    public static ArgusEvent parseJson(String data) throws IOException {
        Map<String, Object> map = JSON.std
                .with(JSON.Feature.PRETTY_PRINT_OUTPUT)
                .mapFrom(data);

        return new ArgusEvent(
                map.get("Action").toString(),
                map.get("ActionDescription").toString(),
                map.get("Name").toString(),
                OffsetDateTime.parse(map.get("Timestamp").toString())
        );
    }
}
