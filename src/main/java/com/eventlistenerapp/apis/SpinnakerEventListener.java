package com.eventlistenerapp.apis;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.util.JSONPObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@RestController
public class SpinnakerEventListener {

    private static final Logger log = LoggerFactory.getLogger(SpinnakerEventListener.class);

    @Autowired
    private ObjectMapper objectMapper;

    @RequestMapping(value = "/pushevent",method = RequestMethod.POST)
    public String storeEvent(@RequestBody String eventInput) throws IOException {
        Files.createDirectories(Paths.get("/tmp/spin-events"));
        String path = "/tmp/spin-events/"+System.currentTimeMillis() +".json";

            Files.write(Paths.get(path), eventInput.getBytes());

        log.info("Input: {} ",  eventInput);

        return "OK";

    }
}
