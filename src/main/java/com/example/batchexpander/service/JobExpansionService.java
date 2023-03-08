package com.example.batchexpander.service;

import com.example.batchexpander.model.BatchExpansionJobRequest;
import com.example.batchexpander.model.BatchExpansionJobResponse;
import org.springframework.stereotype.Service;

@Service
public class JobExpansionService {

    private final JobRequestHandlerFactory jobRequestHandlerFactory;

    public JobExpansionService(JobRequestHandlerFactory jobRequestHandlerFactory) {
        this.jobRequestHandlerFactory = jobRequestHandlerFactory;
    }

    public BatchExpansionJobResponse process(BatchExpansionJobRequest batchExpansionJobRequest) {
        JobRequestHandler requestHandler = jobRequestHandlerFactory.getHandler(batchExpansionJobRequest);
        BatchExpansionJobResponse jobResponse = requestHandler.createResponse();
        return jobResponse;
    }
}
