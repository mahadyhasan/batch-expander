package com.example.batchexpander.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;
import java.util.Map;

public class BatchExpansionJobResponse {

    private Map<String, Map<String, Object>> jobs;
    private Map<String, List<String>> dependencies;

    public BatchExpansionJobResponse() {
    }

    @JsonCreator
    public BatchExpansionJobResponse(final @JsonProperty("jobs") Map<String, Map<String, Object>> jobs,
                                     final @JsonProperty("dependency_graph") Map<String, List<String>> dependencies) {
        this.jobs = jobs;
        this.dependencies = dependencies;
    }

    public Map<String, Map<String, Object>> getJobs() {
        return jobs;
    }

    public void setJobs(Map<String, Map<String, Object>> jobs) {
        this.jobs = jobs;
    }

    public Map<String, List<String>> getDependencies() {
        return dependencies;
    }

    public void setDependencies(Map<String, List<String>> dependencies) {
        this.dependencies = dependencies;
    }

    @Override
    public String toString() {
        return "BatchExpansionJobResponse{" +
                "jobs=" + jobs +
                ", dependencies=" + dependencies +
                '}';
    }
}
