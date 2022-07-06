package com.webdev.actuator.health;

import org.springframework.boot.actuate.health.AbstractHealthIndicator;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.Status;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class myHealthIndicator extends AbstractHealthIndicator {


    @Override
    protected void doHealthCheck(Health.Builder builder) throws Exception {

        Map<String,Object> map = new HashMap<>();



        if (1==1) {
            builder.status(Status.UP);
            map.put("count", 1);
            map.put("ms", 300);
        }
        else {
            builder.status(Status.DOWN);
            map.put("err", "no response");
            map.put("ms", 3000);
        }
        builder.withDetail("code", 100)
                .withDetails(map);
    }
}
