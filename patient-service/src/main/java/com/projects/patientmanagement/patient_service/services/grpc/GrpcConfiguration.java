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


    private static final Logger log = LoggerFactory.getLogger(GrpcConfiguration.class);

    // Inject the address property from environment/properties
    @Value("${spring.grpc.client.channels.billing-channel.address:NOT_FOUND}")
    private String billingChannelAddress;

    // Inject the negotiation type property
    @Value("${spring.grpc.client.channels.billing-channel.negotiation-type:NOT_FOUND}")
    private String negotiationType;

    @PostConstruct
    public void logGrpcDetails() {
        log.info("=========================================================");
        log.info("gRPC Client Initialization Details:");
        log.info("Target Channel Address: {}", billingChannelAddress);
        log.info("Negotiation Type:       {}", negotiationType);
        log.info("=========================================================");
    }



    @Bean
    public BillingServiceGrpc.BillingServiceBlockingStub billingServiceBlockingStub(GrpcChannelFactory grpcChannelFactory) {



        ManagedChannel channel = grpcChannelFactory.createChannel("billing-channel");
        return BillingServiceGrpc.newBlockingStub(channel);
    }

}
