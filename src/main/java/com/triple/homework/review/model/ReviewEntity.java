package com.triple.homework.review.model;

import lombok.*;
import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "REVIEW")
@Builder
public class ReviewEntity {

    @Id
    @Column(name = "REVIEW_ID")
    private String reviewId;

    @Column(name = "CONTENT")
    private String content;

    @Column(name = "PHOTO_ID_LIST")
    private String attachedPhotoIds;

    @Column(name = "USER_ID")
    private String userId;

    @Column(name = "PLACE_ID")
    private String placeId;

    @Column(name = "WRITE_DT")
    private Date writeDt;

    @Column(name = "MODIFY_DT")
    private Date modifyDt;

}
