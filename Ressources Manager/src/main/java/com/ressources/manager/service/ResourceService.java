package com.ressources.manager.service;

import com.ressources.manager.feignClient.Task;
import com.ressources.manager.feignClient.TaskClient;
import com.ressources.manager.model.Resource;
import com.ressources.manager.repository.ResourceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Service
public class ResourceService {

    @Autowired
    private ResourceRepository resourceRepository;
    @Autowired
    private TaskClient taskClient;


    public List<Resource> getAllResources() {
        return resourceRepository.findAll();
    }

    public Resource getResourceById(Long id) {
        return resourceRepository.findById(id).get();
    }

    public Resource createResource(Resource resource) {
        if (taskClient.getTaskById(resource.getTaskId()) != null) {
            return resourceRepository.save(resource);
        }
        throw new RuntimeException("Task not found");
    }

    public Resource updateResource(Long id,Resource resource) {
        Resource resource1=resourceRepository.findById(id).get();
        resource1.setResourceName(resource.getResourceName());
        resource1.setResourceType(resource.getResourceType());
        resource1.setResourceQuantity(resource.getResourceQuantity());
        resource1.setResourceProvider(resource.getResourceProvider());
        return resourceRepository.save(resource1);
    }

    public void deleteResource(Long id) {
        resourceRepository.deleteById(id);
    }

}
