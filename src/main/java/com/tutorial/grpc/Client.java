package com.tutorial.grpc;

import io.grpc.*;
import recommend.Recommend;
import recommend.RecommendControllerGrpc;

import java.util.List;

public class Client {
    private Recommend.GetRecommendPostsIdResult result;

    public Client() {
    }
    public static void main(String []args) {
        Client cl = new Client();
        System.out.println(cl.hello());
    }

    public String hello() {
        final ManagedChannel channel = ManagedChannelBuilder.forTarget("localhost:8082")
                .usePlaintext(true)
                .build();

        RecommendControllerGrpc.RecommendControllerBlockingStub stub = RecommendControllerGrpc.newBlockingStub(channel);
        Recommend.GetRecommendPostsIdInput input = Recommend.GetRecommendPostsIdInput.newBuilder().setNumber(10).setOffset(10).setUserId(123456).build();

        Recommend.GetRecommendPostsIdResult result = stub.getRecommendPostsId(input);

        //System.out.println(result);
        //System.out.println(result.getPostIdListList().toString());
        channel.shutdown();
        return result.getPostIdListList().toString();
    }


}
