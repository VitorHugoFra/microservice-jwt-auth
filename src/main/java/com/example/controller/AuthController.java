package com.example.controller;

import com.example.domain.LoginRequest;
import com.example.service.UserService;
import com.example.util.JwtUtil;

import javax.json.Json;
import javax.json.JsonObject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/auth")
public class AuthController {
    private UserService userService = new UserService();

    @POST
    @Path("/login")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response login(LoginRequest request) {
        String username = request.getUsername();
        String password = request.getPassword();

        if (userService.authenticate(username, password) != null) {
            String token = JwtUtil.generateToken(username);
            JsonObject jsonResponse = Json.createObjectBuilder()
                    .add("token", token)
                    .build();
            return Response.ok(jsonResponse).build();
        } else {
            return Response.status(Response.Status.UNAUTHORIZED).build();
        }
    }
}
