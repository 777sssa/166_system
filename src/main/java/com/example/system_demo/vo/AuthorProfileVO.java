package com.example.system_demo.vo;

import lombok.Data;

@Data
public class AuthorProfileVO {
    // Author table attributes
    private String authorId; // id (char 24)
    private String authorName; // name (varchar 255)
    private String authorOrg; // org (text)
    private String normalizedName; // normalized_name (varchar 255)
    private String lastKnownAffId; // last_known_aff_id (varchar 255)
    private String position; // position (text)
    private String nPubs; // n_pubs (varchar 255)
    private String nCitation; // n_citation (varchar 255)
    private String hIndex; // h_index (varchar 255)
    private String tags; // tags (mediumtext)
    private String pubs; // pubs (mediumtext)
    // Author_profile table attributes
    private String email; // email (varchar 255)
    private String phone; // phone (varchar 50)
    private String gender; // gender (varchar 10)
    private String picture; // picture (varchar 255)
    private String homepage; // homepage (text)
    private String pos; // pos (text)
    private String biography; // biography (text)
    private String education; // education (text)
    private String interests; // interests (text)
    private String profileOrg; // org (text)
}
