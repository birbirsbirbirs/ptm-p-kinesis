package co.pitam.ptmpk.expressionLanaguage;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.expression.spel.standard.SpelExpressionParser;

public class MethodTest {
    @Test
    void mthods() {
        var expressionParser = new SpelExpressionParser();
        Assertions.assertEquals(expressionParser
                .parseExpression("'abc'.substring(1,3)").getValue(String.class), "bc");
    }
}
