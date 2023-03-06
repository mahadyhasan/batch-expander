package com.example.batchexpander.web.rest;

import com.example.batchexpander.model.BatchExpansionJobRequest;
import com.example.batchexpander.model.JobGroup;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/jobs")
public class BatchExpansionController {

    private static final Logger log = LoggerFactory.getLogger(BatchExpansionController.class);

    @PostMapping(value = "/expandBatchJob", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> createBatchExpansionJob(@Valid @RequestBody BatchExpansionJobRequest request) {
        JobGroup jobGroup = JobGroup.fromString(request.getJobGroupName());


        // Return a response to the client
        return ResponseEntity.ok("Batch expansion job created successfully");
    }


}
