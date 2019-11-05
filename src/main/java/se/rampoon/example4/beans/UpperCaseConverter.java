package se.rampoon.example4.beans;

import org.springframework.stereotype.Component;

/**
 * Returns uppercase
 */
@Component
public class UpperCaseConverter {

        public String transformContent(String body) {
            String upperCaseContent = body.toUpperCase();
            return upperCaseContent;
        }
}
