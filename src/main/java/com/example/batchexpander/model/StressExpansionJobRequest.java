package com.example.batchexpander.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotBlank;

public class StressExpansionJobRequest extends BatchExpansionJobRequest {

    @NotBlank(message = "stress_run_id is required")
    @JsonProperty("stress_run_id")
    private final String stressRunId;


    public StressExpansionJobRequest(final @JsonProperty("stress_run_id") String stressRunId,
                                     final @JsonProperty("job_group_name") String jobGroupName,
                                     final @JsonProperty("job_type") String jobType) {
        super(jobGroupName, jobType);
        this.stressRunId = stressRunId;
    }

    public String getStressRunId() {
        return stressRunId;
    }

    @Override
    public String toString() {
        return "StressExpansionJobRequest{" +
                "stressRunId='" + stressRunId + '\'' +
                '}';
    }
}
