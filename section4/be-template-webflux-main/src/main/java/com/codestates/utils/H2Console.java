package com.codestates.utils;

import lombok.extern.slf4j.Slf4j;
import org.h2.tools.Server;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.event.ContextClosedEvent;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
//@Profile("local")
public class H2Console {
    private Server webServer;

    @Value("${spring.r2dbc.port}")
    private String PORT;

    @EventListener(ContextRefreshedEvent.class)
    public void start() throws java.sql.SQLException {
        log.info("starting h2 console at port " + PORT);
        this.webServer = org.h2.tools.Server.createWebServer("-webPort", PORT, "-tcpAllowOthers").start();
    }

    @EventListener(ContextClosedEvent.class)
    public void stop() {
        log.info("stopping h2 console at port " + PORT);
        this.webServer.stop();
    }

}