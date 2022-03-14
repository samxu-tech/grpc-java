package com.tutorial.grpc;

import io.grpc.*;
public class App {
    public static void main(String []args) throws Exception {
        Server server = ServerBuilder.forPort(8082).addService(new RecommendControllerImpl()).build();
        server.start();
        System.out.println("Server Start on 8082 port");
        server.awaitTermination();
    }

}
