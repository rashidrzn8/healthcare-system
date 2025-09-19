package com.pm.billingservice.grpc;

import billing.BillingResponse;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;
import billing.BillingServiceGrpc.BillingServiceImplBase;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@GrpcService
public class BillingGrpcService extends BillingServiceImplBase {
    private static final Logger log = LoggerFactory.getLogger(BillingGrpcService.class);

    @Override
    public void CreateBillingAccount(billing.BillingRequest billingRequest , StreamObserver<billing.BillingResponse> responseObserver){
        log.info("Create BillingAccount request received: {}",billingRequest.toString());

        //business logic below

        BillingResponse billingResponse = BillingResponse.newBuilder().setAccountId("12345").setStatus("active").build();
        responseObserver.onNext(billingResponse);
        responseObserver.onCompleted();
    }


}
