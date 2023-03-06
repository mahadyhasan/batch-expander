package com.example.batchexpander.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotBlank;

public class BatchExpansionJobRequest {

    @NotBlank(message = "job_group_name is required")
    @JsonProperty("job_group_name")
    private final String jobGroupName;

    @NotBlank(message = "jobType is required")
    private final String jobType;

    public BatchExpansionJobRequest(final @JsonProperty("job_group_name") String jobGroupName,
                                    final @JsonProperty("job_type") String jobType) {
        this.jobGroupName = jobGroupName;
        this.jobType = jobType;
    }

    public String getJobGroupName() {
        return jobGroupName;
    }

    public String getJobType() {
        return jobType;
    }

    @Override
    public String toString() {
        return "BatchExpansionJobRequest{" +
                "jobGroupName='" + jobGroupName + '\'' +
                ", jobType='" + jobType + '\'' +
                '}';
    }
}
