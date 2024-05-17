package co.pitam.ptmpk.controller;

import co.pitam.ptmpk.OrdersSource;
import co.pitam.ptmpk.mode.Hero;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class HeroController {
    private final OrdersSource ordersSource;

    @PostMapping
    public void publishHero(@RequestBody Hero hero) {
        ordersSource.sendOrder(hero);
    }
}
