package com.example.batchexpander.web.rest;

import com.example.batchexpander.model.BatchExpansionJobRequest;
import com.example.batchexpander.model.BatchExpansionJobResponse;
import com.example.batchexpander.service.JobExpansionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
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

    private final JobExpansionService jobExpansionService;

    public BatchExpansionController(JobExpansionService jobExpansionService) {
        this.jobExpansionService = jobExpansionService;
    }


    @PostMapping(value = "/expandBatchJob", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BatchExpansionJobResponse> createBatchExpansionJob(@Valid @RequestBody BatchExpansionJobRequest batchExpansionJobRequest) {

        BatchExpansionJobResponse batchExpansionJobResponse = jobExpansionService.process(batchExpansionJobRequest);

        // Return a response to the client
        return ResponseEntity.status(HttpStatus.OK)
                             .body(batchExpansionJobResponse);
    }


}
