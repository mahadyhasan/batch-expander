package com.example.batchexpander.service;

import com.example.batchexpander.model.BatchExpansionJobResponse;
import com.example.batchexpander.model.JobGroup;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class StressJobRequestHandler implements JobRequestHandler {

    @Override
    public BatchExpansionJobResponse createResponse() {
        final String executionId = "d5981061-176a-4e2b-adce-b7c46195c42d";
        final String runId = "f8f551c7-d8a4-4468-8158-c1afbdeb7e36";

        BatchExpansionJobResponse response = new BatchExpansionJobResponse();
        Map<String, Map<String, Object>> jobs = new HashMap<>();
        Map<String, List<String>> dependencies = new HashMap<>();

        // Create and add job payloads to the jobs map
        for (int i = 1; i <= 3; i++) {
            String jobId = "P0000022151_QC" + i + "-CST6";
            Map<String, Object> jobParams = new HashMap<>();

            jobParams.put("executionId", executionId);
            jobParams.put("runId", runId);
            Map<String, String> feedContextParams = new HashMap<>();
            feedContextParams.put("feedName", "SCENARIO_HUB");
            feedContextParams.put("reRun", "true");
            jobParams.put("feedContextParams", feedContextParams);
            jobs.put(jobId, jobParams);
        }

        // Set dependencies for jobs
        dependencies.put("P0000022151_QC1-CST6", null);
        dependencies.put("P0000022151_QC2-CST6", null);
        dependencies.put("P0000022151_QC3-CST6", Arrays.asList("P0000022151_QC1-CST6", "P0000022151_QC2-CST6"));

        response.setJobs(jobs);
        response.setDependencies(dependencies);

        return response;
    }

    @Override
    public JobGroup getJobGroup() {
        return JobGroup.STRESS;
    }
}
