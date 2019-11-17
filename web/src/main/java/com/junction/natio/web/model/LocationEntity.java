package com.junction.natio.web.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.junction.natio.core.model.EntityBase;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "location")
public class LocationEntity extends EntityBase {
    @Column(name = "lat")
    private String lat;
    @Column(name = "lng")
    private String lng;
    @Column(name = "pointInfo")
    private String pointInfo;
    @Column(name = "name")
    private String name;
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private UserEntity userId;

}
