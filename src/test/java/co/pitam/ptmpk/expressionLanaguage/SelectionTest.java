package co.pitam.ptmpk.expressionLanaguage;

import org.junit.jupiter.api.Test;
import org.springframework.expression.spel.standard.SpelExpressionParser;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class SelectionTest {

    @Test
    void selection() {
        record Cat(String type){

        }

        var expressionParser=new SpelExpressionParser();
        var values= List.of(new Cat("Leopard"),new Cat("Tiger"),new Cat("Lion"),new Cat("Tiger"));

        var fewerValues=expressionParser.parseExpression("#root.?[ type == 'Tiger' ]").getValue(values,List.class);
        assertThat(fewerValues.size()).isEqualTo(2);

    }
}
