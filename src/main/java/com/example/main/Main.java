package com.example.main;

import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.jetty.JettyHttpContainerFactory;
import org.glassfish.jersey.jackson.JacksonFeature;

import java.net.URI;

public class Main {
    public static void main(String[] args) {
        ResourceConfig config = new ResourceConfig();
        config.packages("com.example.controller"); 
        config.register(JacksonFeature.class); 
        URI baseUri = URI.create("http://localhost:8080/");
        JettyHttpContainerFactory.createServer(baseUri, config);
    }
}
