package com.projects.patientmanagement.patient_service.services.grpc;

import com.patientmangement.billing.BillingServiceGrpc;
import io.grpc.ManagedChannel;
import jakarta.annotation.PostConstruct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.grpc.client.GrpcChannelFactory;

@Configuration
public class GrpcConfiguration {

    @Bean
    public BillingServiceGrpc.BillingServiceBlockingStub billingServiceBlockingStub(GrpcChannelFactory grpcChannelFactory) {
        ManagedChannel channel = grpcChannelFactory.createChannel("billing-channel");
        return BillingServiceGrpc.newBlockingStub(channel);
    }



}
