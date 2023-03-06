package com.example.batchexpander.model;

public enum JobGroup {

    STRESS("STRESS"),
    BAU("BAU"),
    BACK_TESTING("BACK_TESTING"),
    UNKNOWN("Unknown");

    final String jobGroupName;

    JobGroup(String jobGroupName) {
        this.jobGroupName = jobGroupName;
    }

    public static JobGroup fromString(String value) {
        for (JobGroup jobGroup : values()) {
            if (jobGroup.name().equalsIgnoreCase(value)) {
                return jobGroup;
            }
        }
        return null; // Or throw an exception, depending on your use case
    }

}
