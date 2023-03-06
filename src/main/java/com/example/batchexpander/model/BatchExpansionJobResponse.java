package com.example.batchexpander.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;
import java.util.Map;

public class BatchExpansionJobResponse {

    private final Map<String, Map<String, Object>> jobs;
    private final Map<String, List<String>> dependencies;

    @JsonCreator
    public BatchExpansionJobResponse(final @JsonProperty("jobs") Map<String, Map<String, Object>> jobs,
                                     final @JsonProperty("dependency_graph") Map<String, List<String>> dependencies) {
        this.jobs = jobs;
        this.dependencies = dependencies;
    }

    public Map<String, Map<String, Object>> getJobs() {
        return jobs;
    }

    public Map<String, List<String>> getDependencies() {
        return dependencies;
    }

    @Override
    public String toString() {
        return "BatchExpansionJobResponse{" +
                "jobs=" + jobs +
                ", dependencies=" + dependencies +
                '}';
    }
}
