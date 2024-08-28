package com.ressources.manager.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "resource")
public class Resource {

    @Id
    @GeneratedValue
    private Long resourceId;
    private String resourceName;
    private String resourceType;
    private String resourceQuantity;
    private String resourceProvider;
    private Long taskId;

}
