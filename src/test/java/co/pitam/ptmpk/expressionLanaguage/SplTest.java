package co.pitam.ptmpk.expressionLanaguage;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.expression.Expression;
import org.springframework.expression.spel.standard.SpelExpressionParser;

import java.util.List;
import java.util.Map;

import static co.pitam.ptmpk.model.Spel.TELSA;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SplTest {

    @Test
    void literalExpression() {
        var expressionParser = new SpelExpressionParser();
        Expression expression = expressionParser.parseExpression("'hello, world'.concat('!').bytes");
        var message = expression.getValue(byte[].class);
        Assertions.assertEquals(new String(message), "hello, world!");
    }

    @Test
    void arraysAndCollections() {
        var expressionParser = new SpelExpressionParser();

//        access
        var expression = expressionParser.parseExpression("inventionsArray[0].toUpperCase()");
        var result = expression.getValue(TELSA, String.class);
        Assertions.assertEquals(result, "induction motor".toUpperCase());

//        array literals
        var array = expressionParser.parseExpression("new int[] {1,2,3,4}").getValue(int[].class);
        Assertions.assertEquals(array.length, 4);

// list literals
        var numberedList=expressionParser.parseExpression("{0,1,2,3}").getValue(List.class);
        Assertions.assertNotNull(numberedList,"the numbered list is not null");
        assertTrue(!numberedList.isEmpty(),"the numbered list is not null");
        for (var i=0;i<4;i++) assertTrue(numberedList.contains(i));

// map literals
        var map=expressionParser.parseExpression("{name: 'Bob' } ").getValue(Map.class);
        assertTrue(map.containsKey("name") && map.get("name").equals("Bob"));

    }


}
