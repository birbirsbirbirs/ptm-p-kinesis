package co.pitam.ptmpk;

import co.pitam.ptmpk.model.Hero;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.function.Supplier;

@Slf4j
@Component
public class OrdersSource {
    private BlockingQueue<Hero> orderEvent = new LinkedBlockingQueue<>();

    @Bean
    public Supplier<Hero> produceOrder() {
        return () -> this.orderEvent.poll();
    }

    public void sendOrder(Hero hero) {
        this.orderEvent.offer(hero);
        log.info("Event sent: {}", hero);
    }
}
