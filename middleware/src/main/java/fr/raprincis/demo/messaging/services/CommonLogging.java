package fr.raprincis.demo.messaging.services;

import org.springframework.stereotype.Component;

@Component
public class CommonLogging {
    public String getLogMessage() {
        return "CommonLogging";
    }
}
