package com.example.batchexpander.service;

import com.example.batchexpander.model.BatchExpansionJobResponse;
import com.example.batchexpander.model.JobGroup;

public interface JobRequestHandler {

    BatchExpansionJobResponse createResponse();

    JobGroup getJobGroup();
}
