package org.springframework.samples.petclinic.proxy;

import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

@Component
public class CashPerf implements Payment {

    Payment cash = new Cash();

    @Override
    public void pay(int amount) {
        StopWatch sw = new StopWatch();
        sw.start();

        cash.pay(amount);

        sw.stop();
        System.out.println(sw.prettyPrint());
    }
}
