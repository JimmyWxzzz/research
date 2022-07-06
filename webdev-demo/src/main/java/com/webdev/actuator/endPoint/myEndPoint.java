package com.webdev.actuator.endPoint;


import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.boot.actuate.endpoint.annotation.WriteOperation;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.Map;

@Component
@Endpoint(id = "end")
public class myEndPoint {
    @ReadOperation
    public Map getDockerInfo() {
        return Collections.singletonMap("dockerInfo", "it started");
    }
    @WriteOperation
    public void stopDocker(){
        System.out.println("docker stopped");
    }
}
