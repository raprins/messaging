package fr.raprincis.demo.messaging.routes;

import org.springframework.stereotype.Component;
import org.apache.camel.LoggingLevel;
import org.apache.camel.builder.RouteBuilder;

@Component
public class TimerRoute extends RouteBuilder{

    @Override
    public void configure() throws Exception {
        /**
         * 
         * https://camel.apache.org/components/latest/timer-component.html
         */
        from("timer:my-first")
            .transform().constant("Something clear") // Transformation
            .to("log:my-logger");
    }
    
}
