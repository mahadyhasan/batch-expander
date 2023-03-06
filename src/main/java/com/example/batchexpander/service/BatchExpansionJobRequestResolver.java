package com.example.batchexpander.service;

import com.example.batchexpander.model.BAUExpansionJobRequest;
import com.example.batchexpander.model.BatchExpansionJobRequest;
import com.example.batchexpander.model.JobGroup;
import com.example.batchexpander.model.StressExpansionJobRequest;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.core.MethodParameter;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Component;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import javax.servlet.http.HttpServletRequest;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class BatchExpansionJobRequestResolver implements HandlerMethodArgumentResolver {

    private static final String JOB_GROUP_NAME_PARAM = "job_group_name";
    private static final Map<JobGroup, Class<? extends BatchExpansionJobRequest>> JOB_REQUEST_CLASS_MAP;

    static {
        JOB_REQUEST_CLASS_MAP = new HashMap<>();
        JOB_REQUEST_CLASS_MAP.put(JobGroup.STRESS, StressExpansionJobRequest.class);
        JOB_REQUEST_CLASS_MAP.put(JobGroup.BAU, BAUExpansionJobRequest.class);
        // add more job group classes as needed
    }

    private final ObjectMapper objectMapper;
    private final List<HttpMessageConverter<?>> converters;

    public BatchExpansionJobRequestResolver(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
        this.converters = Arrays.asList(new MappingJackson2HttpMessageConverter(objectMapper));
    }

    @Override
    public boolean supportsParameter(final MethodParameter parameter) {
        return BatchExpansionJobRequest.class.isAssignableFrom(parameter.getParameterType());
    }

    @Override
    public Object resolveArgument(final MethodParameter parameter,
                                  final ModelAndViewContainer mavContainer,
                                  final NativeWebRequest webRequest,
                                  final WebDataBinderFactory binderFactory) throws Exception {

        String jobGroupName = webRequest.getParameter(JOB_GROUP_NAME_PARAM);

        if (jobGroupName == null) {
            throw new IllegalArgumentException("job_group_name parameter is required");
        }

        Class<? extends BatchExpansionJobRequest> jobRequestClass = JOB_REQUEST_CLASS_MAP.get(JobGroup.fromString(jobGroupName));
        if (jobRequestClass == null) {
            throw new IllegalArgumentException("Unsupported job_group_name: " + jobGroupName);
        }

        HttpServletRequest servletRequest = webRequest.getNativeRequest(HttpServletRequest.class);

        if (servletRequest == null) {
            throw new IllegalArgumentException("Could not get HttpServletRequest");
        }

        InputStream inputStream = servletRequest.getInputStream();
        String body = StreamUtils.copyToString(inputStream, StandardCharsets.UTF_8);

        BatchExpansionJobRequest jobRequest = objectMapper.readValue(body, jobRequestClass);

        // Run validations on the jobRequest object if necessary
        // ...

        return new BatchExpansionJobRequest(jobRequest.getJobGroupName(), jobRequest.getJobType());
    }

}
