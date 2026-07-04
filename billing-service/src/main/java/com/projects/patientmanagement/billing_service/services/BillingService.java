package com.projects.patientmanagement.billing_service.services;


import com.patientmangement.billing.BillingServiceGrpc;
import com.patientmangement.billing.CreateBillingAccountRequest;
import com.patientmangement.billing.CreatedBillingAccountResponse;
import io.grpc.stub.StreamObserver;
import org.springframework.grpc.server.service.GrpcService;

@GrpcService
public class BillingService extends BillingServiceGrpc.BillingServiceImplBase {

    @Override
    public void createBillingAccount(CreateBillingAccountRequest request, StreamObserver<CreatedBillingAccountResponse> responseObserver) {
        final var response = CreatedBillingAccountResponse.newBuilder().setAccountId(request.getPatientId()).setStatus(request.getEmail()).build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}
