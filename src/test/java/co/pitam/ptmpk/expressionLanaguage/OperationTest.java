package co.pitam.ptmpk.expressionLanaguage;

import org.junit.jupiter.api.Test;
import org.springframework.expression.spel.standard.SpelExpressionParser;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class OperationTest {

    @Test
    void operators() {
        var expressionParser = new SpelExpressionParser();
        assertTrue(expressionParser.parseExpression(" 2 == 2").getValue(Boolean.class));
        assertTrue(expressionParser.parseExpression("'black' < 'block'").getValue(Boolean.class));
    }
}
