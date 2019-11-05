package se.rampoon.example4.routes;

import org.apache.camel.LoggingLevel;
import org.apache.camel.builder.RouteBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class RouteFromActiveMQ extends RouteBuilder {
    private static final Logger LOG = LoggerFactory.getLogger(RouteFromActiveMQ.class);
    private final static String ROUTE_ID = "FromActiveMQToFileRoute";

    @Override
    public void configure() throws Exception {
        Map<String, String> map = new HashMap<>();
        map.put("KEY", "VALUE");
        from("{{target.uri.activemq}}")
                .routeId(ROUTE_ID)
                .log(LoggingLevel.INFO, LOG, "RouteFromActiveMQ starting...")
                .bean("headerUtils", "addHeader")
                .bean("bodyUtils", "addText")
                .setHeader("Header2", simple("999"))
                .setHeader("Header4", constant("8888"))
                .bean("headerDisplayer", "displayHeaders")
                .bean("upperCaseConverter", "transformContent")
                .bean("bodyUtils", "addHeaderToBody")
                .to("file:/home/matjav/files/outbox_activemq");
    }
}

