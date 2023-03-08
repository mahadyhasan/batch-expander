package com.example.batchexpander.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import javax.validation.constraints.NotBlank;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, visible = true, property = "job_group_name")
@JsonSubTypes({
        @JsonSubTypes.Type(value = StressExpansionJobRequest.class, name = "STRESS"),
        @JsonSubTypes.Type(value = BAUExpansionJobRequest.class, name = "BAU")
})
public abstract class BatchExpansionJobRequest {

    @NotBlank(message = "job_group_name is required")
    protected final String jobGroupName;

    @NotBlank(message = "jobType is required")
    protected final String jobType;

    protected BatchExpansionJobRequest(final @JsonProperty("job_group_name") String jobGroupName,
                                       final @JsonProperty("job_type") String jobType) {
        this.jobGroupName = jobGroupName;
        this.jobType = jobType;
    }

    @JsonProperty("job_group_name")
    public String getJobGroupName() {
        return jobGroupName;
    }

    @JsonProperty("job_type")
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
