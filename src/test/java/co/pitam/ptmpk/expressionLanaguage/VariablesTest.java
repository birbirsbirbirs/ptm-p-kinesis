package co.pitam.ptmpk.expressionLanaguage;

import org.junit.jupiter.api.Test;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.SimpleEvaluationContext;

import static org.assertj.core.api.Assertions.assertThat;

public class VariablesTest {
    static class WritableInventor{
        private String name;
        public String getName() {
            return name;
        }
        public void setName(String name) {
            this.name = name;
        }
    }


    @Test
    void variablesTest(){
        var writableInventor = new WritableInventor();
        writableInventor.setName("Nick");
        assertThat(writableInventor.getName()).isEqualTo("Nick");
        SpelExpressionParser springExpressionParser = new SpelExpressionParser();
        var context=SimpleEvaluationContext.forReadWriteDataBinding().build();
        context.setVariable("newName","Mike");
        springExpressionParser.parseExpression("name = #newName").getValue(context,writableInventor);
        assertThat(writableInventor.getName()).isEqualTo("Mike");
    }


}
