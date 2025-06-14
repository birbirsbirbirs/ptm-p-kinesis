package co.pitam.ptmpk.expressionLanaguage;

import org.junit.jupiter.api.Test;
import org.springframework.expression.spel.SpelEvaluationException;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.SimpleEvaluationContext;
import org.springframework.expression.spel.support.StandardEvaluationContext;

import static co.pitam.ptmpk.model.Spel.TELSA;
import static org.assertj.core.api.Assertions.assertThat;

public class EvaluationContextsTest {

    public static int add(int a, int b) {
        return a + b;
    }

    @Test
    void standardEvaluationContext() throws Exception {
        var method = getClass().getMethod("add", int.class, int.class);
        assertThat(method).isNotNull();

        var context = new StandardEvaluationContext();
        context.setVariable("x", 10);
        context.setVariable("y", 20);
        context.registerFunction("add", method);

        var parser = new SpelExpressionParser();
        assertThat(parser.parseExpression("#x + #y").getValue(context, Integer.class)).isEqualTo(30);
        assertThat(parser.parseExpression("#add(#x,#y)").getValue(context, Integer.class)).isEqualTo(30);
    }

    @Test
    void simpleEvaluationContextWithoutInstanceMethods(){
        var context= SimpleEvaluationContext.forReadOnlyDataBinding().withRootObject(TELSA);

        var parser=new SpelExpressionParser();

        assertThat(parser.parseExpression("#root.name").getValue(context.build(), String.class)).isEqualTo("Nikola Telsa");

        try {
            assertThat(parser.parseExpression("#root.toString()").getValue(context.build(),String.class)).isNotNull();

        }catch(SpelEvaluationException e){

        }

        assertThat(parser.parseExpression("#root.toString()").getValue(context.withInstanceMethods().build(),String.class)).isNotNull();

    }
}
