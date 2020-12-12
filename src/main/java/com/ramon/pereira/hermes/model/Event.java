package com.ramon.pereira.hermes.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "events", schema = "hermes")
public class Event implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    @Enumerated(EnumType.STRING)
    private enEvent name;

    @Column
    private Date createdAt;

    @ManyToMany(mappedBy = "events")
    private List<Communication> communications;

    @PrePersist
    protected void prePersist() {
        createdAt = new Date();
    }
}
