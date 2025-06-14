package co.pitam.ptmpk.expressionLanaguage;

import org.junit.jupiter.api.Test;
import org.springframework.expression.spel.standard.SpelExpressionParser;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class TypesTest {

    @Test
    void types() {
        var ep = new SpelExpressionParser();
        var result =
                ep.parseExpression("T(java.math.RoundingMode).CEILING < T(java.math.RoundingMode).FLOOR")
                        .getValue(Boolean.class);
        assertTrue(result);
    }
}
