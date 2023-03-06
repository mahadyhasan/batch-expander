package com.example.batchexpander.service;

import com.example.batchexpander.model.BatchExpansionJobResponse;
import com.example.batchexpander.model.JobGroup;

public class DefaultJobRequestHandler implements JobRequestHandler {

    @Override
    public BatchExpansionJobResponse createResponse() {
        return null;
    }

    @Override
    public JobGroup getJobGroup() {
        return JobGroup.UNKNOWN;
    }

}
