package com.example.system_demo.entity;

import lombok.Data;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Column;
import jakarta.persistence.Table;

@Entity
@Table(name = "author")
@Data
public class Author {

    @Id
    @Column(name = "id", length = 24)
    private String id; // 数据库中为varchar，因此这里使用String

    @Column(name = "name", length = 255)
    private String name;

    @Column(name = "org", columnDefinition = "TEXT")
    private String org;

    @Column(name = "normalized_name", length = 255)
    private String normalizedName;

    @Column(name = "last_known_aff_id", length = 255)
    private String lastKnownAffId;

    @Column(name = "position", columnDefinition = "TEXT")
    private String position;

    @Column(name = "n_pubs", length = 255)
    private String nPubs;

    @Column(name = "n_citation", length = 255)
    private String nCitation;

    @Column(name = "h_index", length = 255)
    private String hIndex;

    @Column(name = "tags", columnDefinition = "MEDIUMTEXT")
    private String tags;

    @Column(name = "pubs", columnDefinition = "MEDIUMTEXT")
    private String pubs;
}
