package se.rampoon.example4.beans;

import org.apache.camel.Exchange;
import org.apache.camel.Header;
import org.springframework.stereotype.Component;

@Component
public class BodyUtils {

    /**
     * Adds a row
     * @param exchange
     * @return
     */
    public String addText(Exchange exchange) {
        return exchange.getIn().getBody() + " Adderad rad ";
    }

    /**
     * Adds content of Header1 to Body
     * @param exchange
     * @param myHeader
     * @return
     */
    public String addHeaderToBody(Exchange exchange, @Header("Header1") String myHeader) {
        return exchange.getIn().getBody() + myHeader;
    }
}
