package com.example.batchexpander.service;

import com.example.batchexpander.model.BatchExpansionJobRequest;
import com.example.batchexpander.model.JobGroup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class JobRequestHandlerFactory {

    private final Map<JobGroup, JobRequestHandler> handlerMap;

    @Autowired
    public JobRequestHandlerFactory(List<JobRequestHandler> handlers) {
        handlerMap = handlers.stream()
                             .collect(Collectors.toMap(
                                     JobRequestHandler::getJobGroup,
                                     Function.identity()
                             ));
    }

    public JobRequestHandler getHandler(BatchExpansionJobRequest request) {
        JobGroup jobGroup = JobGroup.fromString(request.getJobGroupName());
        return handlerMap.getOrDefault(jobGroup, new DefaultJobRequestHandler());
    }
}