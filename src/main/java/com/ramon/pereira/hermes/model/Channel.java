package com.ramon.pereira.hermes.model;

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
@Table(name = "channels", schema = "hermes")
public class Channel implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    @Enumerated(EnumType.STRING)
    private enChannel name;

    @Column
    private Date createdAt;

    @ManyToMany(mappedBy = "channels")
    private List<Communication> communications;

    @PrePersist
    protected void prePersist() {
        createdAt = new Date();
    }
}
