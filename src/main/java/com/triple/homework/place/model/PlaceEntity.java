package com.triple.homework.place.model;

import javax.persistence.Entity;

import lombok.*;
import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "PLACE")
@Builder
public class PlaceEntity {

    @Id
    @Column(name = "PLACE_ID")
    private String placeId;

    @Column(name = "USER_ID")
    private String userId;

    @Column(name = "REVIEW_ID")
    private String reviewId;

    @Column(name = "WRITE_DT")
    private Date writeDt;


}
