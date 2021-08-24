package fr.raprincis.demo.messaging.routes;

import org.apache.camel.Exchange;
import org.apache.camel.LoggingLevel;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class RestConsumer extends RouteBuilder{

    @Override
    public void configure() throws Exception {
        
      // Périod of 5s
      from("timer:launcher?period=60s")
        .to("http://jsonplaceholder.typicode.com/users/1")
        .log(LoggingLevel.INFO, "my-logger", "${body}");
    }
}

