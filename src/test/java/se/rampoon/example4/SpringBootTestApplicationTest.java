package se.rampoon.example4;

import org.apache.camel.CamelContext;
import org.apache.camel.Exchange;
import org.apache.camel.builder.ExchangeBuilder;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import se.rampoon.example4.beans.BodyUtils;
import se.rampoon.example4.beans.HeaderDisplayer;
import se.rampoon.example4.beans.HeaderUtils;
import se.rampoon.example4.beans.UpperCaseConverter;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
@ActiveProfiles("artemismq")
public class SpringBootTestApplicationTest{
    private final String HEADER1_KEY = "Header1";
    private final String HEADER1_VALUE = "ThisIsHeader1";
    private final String LOVERCASE_TEXT = "example of lowercase text";

    @Autowired
    CamelContext camelContext;

    @Autowired
    SpringBootCamelActiveMQ springBootCamelActiveMQ;

    @Autowired
    BodyUtils bodyUtils;

    @Autowired
    HeaderDisplayer headerDisplayer;

    @Autowired
    HeaderUtils headerUtils;

    @Autowired
    UpperCaseConverter upperCaseConverter;

    /**
     * Test of DisplayHeaders
     */
    @Test
    public void testDisplayHeaders() {
        System.out.println("*********** Start UnitTest displayHeaders **********");
        headerDisplayer.displayHeaders(getExchange());
        assertTrue( true );
    }

    /**
     * Test of UpperCaseConverter
     */
    @Test
    public void testUpperCaseConverter() {
        System.out.println("*********** Start UnitTest testUpperCaseConverter **********");
        String shouldBeUpperCase = upperCaseConverter.transformContent(LOVERCASE_TEXT);
        assertTrue( shouldBeUpperCase.equals(LOVERCASE_TEXT.toUpperCase()));
    }

    /**
     * Test of BodyUtils.addHeaderToBody
     */
    @Test
    public void testAddHeaderToBody() {
        System.out.println("*********** Start UnitTest testAddHeaderToBody **********");

        Exchange exChange = getExchange();
        String body = bodyUtils.addHeaderToBody(exChange, HEADER1_VALUE);

        assertTrue(body.contains(HEADER1_VALUE));
    }

    /**
     * Test of HeaderUtils.addHeader
     */
    @Test
    public void testAddHeader() {
        System.out.println("*********** Start UnitTest testAddHeader **********");
        Exchange exChange = getExchange();
        headerUtils.addHeader(exChange);
        assertNotNull(exChange.getIn().getHeader(HEADER1_KEY));
    }

    private Exchange getExchange() {
        return ExchangeBuilder.anExchange(camelContext).build();
    }
}

