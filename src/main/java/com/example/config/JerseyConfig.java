package com.example.config;

import com.example.controller.AuthController;
import org.glassfish.jersey.server.ResourceConfig;

public class JerseyConfig extends ResourceConfig {
    public JerseyConfig() {
        register(AuthController.class);
    }
}
