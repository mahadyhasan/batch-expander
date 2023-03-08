package com.example.batchexpander.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class StressExpansionJobRequest extends BatchExpansionJobRequest {

    public static final String STRESS_JOB_GROUP = JobGroup.STRESS.name();

    private final String stressRunId;

    public StressExpansionJobRequest(final String jobGroupName,
                                     final String jobType,
                                     final @JsonProperty("stress_run_id") String stressRunId) {
        super(jobGroupName, jobType);
        this.stressRunId = stressRunId;
    }

    @JsonProperty("stress_run_id")
    public String getStressRunId() {
        return stressRunId;
    }

    @Override
    public String toString() {
        return "StressExpansionJobRequest{" +
                "jobGroupName='" + super.getJobGroupName() + '\'' +
                "jobType='" + super.getJobType() + '\'' +
                "stressRunId='" + stressRunId + '\'' +
                '}';
    }
}
