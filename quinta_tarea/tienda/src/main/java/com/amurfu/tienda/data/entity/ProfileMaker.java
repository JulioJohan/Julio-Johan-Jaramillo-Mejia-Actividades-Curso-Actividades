package com.amurfu.tienda.data.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "profile_maker")
public class ProfileMaker {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_profile_maker",nullable = false)
    private Integer idProfileMarker;

    @Column(name = "profile_maker", length = 200,nullable = false)
    private String nameProfile;

    @Column(name = "description", length = 500, nullable = false)
    private String description;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_at",nullable = false)
    private Date createdAt;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_user",nullable = false)
    private User user;

    @PrePersist
    private void createdAtPre(){
        createdAt = new Date();
    }


}
