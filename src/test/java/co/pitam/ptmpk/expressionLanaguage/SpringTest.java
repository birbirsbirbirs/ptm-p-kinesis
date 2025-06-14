package co.pitam.ptmpk.expressionLanaguage;

import co.pitam.ptmpk.model.Spel;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.expression.BeanFactoryResolver;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

import java.util.Collection;
import java.util.Set;

import static co.pitam.ptmpk.model.Spel.TELSA;
import static org.assertj.core.api.Assertions.assertThat;

public class SpringTest {

    static class InventoryRegistry{
        public Collection<Spel.Inventor> getInventors(){
            return Set.of(TELSA);
        }
    }

    @Configuration
    static class SimpleConfig{
        @Bean
        InventoryRegistry registry(){
            return new InventoryRegistry();
        }
    }

    @Test
    void beans(){
        var applicationContext= new AnnotationConfigApplicationContext(SimpleConfig.class);
        var expressionParser=new SpelExpressionParser();
        var sec = new StandardEvaluationContext();

        sec.setBeanResolver(new BeanFactoryResolver(applicationContext));
        var collectionOfInventors=expressionParser.parseExpression("@registry.inventors").getValue(sec, Collection.class);
        assertThat(collectionOfInventors).isNotEmpty();

    }

    @Configuration
    static class SpelConfiguration{
        private final Collection<Spel.Inventor> inventors;

        SpelConfiguration( @Value("#{ @registry.inventors }") Collection<Spel.Inventor> inventors){
            System.out.println("the inventions are [" + inventors + "]");
            this.inventors=inventors;
        }
    }

    @Test
    void spring(){
        var applicationContext=new AnnotationConfigApplicationContext(SimpleConfig.class,SpelConfiguration.class);
        applicationContext.start();
        assertThat(applicationContext.getBean(SpelConfiguration.class).inventors).isEqualTo(applicationContext.getBean(InventoryRegistry.class).getInventors());
    }

}
