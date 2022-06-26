package com.triple.homework.review.model;

import lombok.*;
import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "REVIEW_HISTORY")
@Builder
public class ReviewHistoryEntity {

    @Id
    @Column(name = "SEQ")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int seq;

    @Column(name = "STATUS")
    private char status;

    @Column(name = "REVIEW_ID")
    private String reviewId;

    @Column(name = "USER_ID")
    private String userId;

    @Column(name = "BEFORE_PHOTO")
    private String beforePhoto;

    @Column(name = "AFTER_PHOTO")
    private String afterPhoto;

    @Column(name = "BEFORE_CONTENT")
    private String beforeContent;

    @Column(name = "AFTER_CONTENT")
    private String afterContent;

    @Column(name = "WRITE_DT")
    private Date writeDt;
}
