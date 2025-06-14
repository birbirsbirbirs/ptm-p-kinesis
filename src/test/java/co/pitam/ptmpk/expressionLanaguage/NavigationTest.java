package co.pitam.ptmpk.expressionLanaguage;

import co.pitam.ptmpk.model.Spel;
import org.junit.jupiter.api.Test;
import org.springframework.expression.spel.standard.SpelExpressionParser;

import static org.assertj.core.api.Assertions.assertThat;

public class NavigationTest {
    @Test
    void navigations(){
        var expressionParser=new SpelExpressionParser();
        var inventor=new Spel.Inventor(null,null,null,null);

        var name=expressionParser.parseExpression("name ?: 'Bob' ").getValue(inventor,String.class);
        assertThat(name).isEqualTo("Bob");

        var valueOrNull=expressionParser.parseExpression("inventionsArray ?. length").getValue(inventor,Integer.class);
        assertThat(valueOrNull).isNull();

    }
}
