package fr.raprincis.demo.messaging.routes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import fr.raprincis.demo.messaging.services.CommonLogging;

import java.time.LocalDateTime;

import org.apache.camel.LoggingLevel;
import org.apache.camel.builder.RouteBuilder;

//@Component
public class TimerRoute extends RouteBuilder {

    @Autowired
    private CommonLogging commonLogging;

    @Override
    public void configure() throws Exception {
        /**
         * https://camel.apache.org/components/latest/timer-component.html
         */
        from("timer:my-first?period=3s")
            .transform().constant(String.format("Premier body %s", LocalDateTime.now())) // Transformation
                .log(LoggingLevel.INFO, "middle-logger", "${body}")
                .bean(commonLogging) // Change le body
                .log(LoggingLevel.INFO, "middle-logger", "${body}")
                .to("log:my-logger?level=INFO");

    }

}
