package com.example.system_demo.entity;

import lombok.Data;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Column;
import jakarta.persistence.Table;

@Entity
@Data
public class Paper {
//
//    @Id
//    @Column(name = "id", length = 24)
//    private String id;
//
//    @Column(name = "title", length = 255)
//    private String title;
//
//    @Column(name = "abstract", columnDefinition = "TEXT")
//    private String abstractText;
//
//    @Column(name = "year", length = 4)
//    private int year;
//
//    @Column(name = "venue", length = 255)
//    private String venue;
//
//    @Column(name = "n_citation", length = 10)
//    private int nCitation;
//
//
//    @Column(name = "doc_type", length = 50)
//    private String docType;
//
//    @Column(name = "lang", length = 50)
//    private String lang;
//
//    @Column(name = "publisher", length = 255)
//    private String publisher;
//
//    @Column(name = "volume", length = 50)
//    private String volume;
//
//    @Column(name = "issue", length = 50)
//    private String issue;
//
//    @Column(name = "doi", length = 255)
//    private String doi;
//
//    @Column(name = "references", columnDefinition = "TEXT")
//    private String references;
//
//    @Column(name = "fos", columnDefinition = "TEXT")
//    private String fos;
//
//    @Column(name = "keywords", columnDefinition = "TEXT")
//    private String keywords;
//
//    @Column(name = "author_ids", columnDefinition = "TEXT")
//    private String authorIds;
@Id
@Column(name = "id", length = 24)
private String id;

    @Column(name = "title", length = 1000)
    private String title;

    @Column(name = "abstract", columnDefinition = "TEXT")
    private String abstractText;

    @Column(name = "year", length = 10)
    private int year;

    @Column(name = "venue", length = 255)
    private String venue;

    @Column(name = "n_citation", length = 10)
    private int nCitation;

    @Column(name = "doi", length = 500)
    private String doi;

    @Column(name = "references", columnDefinition = "TEXT")
    private String references;

    @Column(name = "authors", columnDefinition = "TEXT")  // 这里更改了名称和类型
    private String authors;

    @Column(name = "keywords", columnDefinition = "TEXT")
    private String keywords;
}
