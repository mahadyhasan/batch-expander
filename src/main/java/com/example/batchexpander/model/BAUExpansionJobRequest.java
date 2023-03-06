package com.example.batchexpander.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotBlank;

public class BAUExpansionJobRequest extends BatchExpansionJobRequest {

    @NotBlank(message = "application_id is required")
    @JsonProperty("application_id")
    private final String applicationId;


    public BAUExpansionJobRequest(final @JsonProperty("application_id") String applicationId,
                                  final @JsonProperty("job_group_name") String jobGroupName,
                                  final @JsonProperty("job_type") String jobType) {
        super(jobGroupName, jobType);
        this.applicationId = applicationId;
    }

    public String getApplicationId() {
        return applicationId;
    }

    @Override
    public String toString() {
        return "BAUExpansionJobRequest{" +
                "applicationId='" + applicationId + '\'' +
                '}';
    }
}
