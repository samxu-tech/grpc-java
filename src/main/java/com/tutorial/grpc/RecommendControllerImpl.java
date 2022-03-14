package com.tutorial.grpc;
import io.grpc.stub.StreamObserver;
import recommend.Recommend;
import recommend.RecommendControllerGrpc;

import java.util.ArrayList;
import java.util.List;

public class RecommendControllerImpl extends RecommendControllerGrpc.RecommendControllerImplBase {
    public void getRecommendPostsId(recommend.Recommend.GetRecommendPostsIdInput request,
                                    io.grpc.stub.StreamObserver<recommend.Recommend.GetRecommendPostsIdResult> responseObserver){
        System.out.println(request);
        List<Integer> resultList=new ArrayList<Integer>();
        resultList.add(request.getUserId());
        resultList.add(request.getOffset());
        resultList.add(request.getNumber());
        Recommend.GetRecommendPostsIdResult result=Recommend.GetRecommendPostsIdResult.newBuilder().addAllPostIdList(resultList).build();

        responseObserver.onNext(result);

        // When you are done, you must call onCompleted.
        responseObserver.onCompleted();


    }
}
