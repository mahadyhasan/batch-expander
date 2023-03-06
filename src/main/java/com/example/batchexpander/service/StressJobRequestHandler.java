package com.example.batchexpander.service;

import com.example.batchexpander.model.BatchExpansionJobResponse;
import com.example.batchexpander.model.JobGroup;
import org.springframework.stereotype.Component;

@Component
public class StressJobRequestHandler implements JobRequestHandler {

    @Override
    public BatchExpansionJobResponse createResponse() {
        return null;
    }

    @Override
    public JobGroup getJobGroup() {
        return JobGroup.STRESS;
    }
}
