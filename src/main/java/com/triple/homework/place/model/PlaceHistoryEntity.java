package com.triple.homework.place.model;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "PLACE_HISTORY")
@Builder
public class PlaceHistoryEntity {

    @Id
    @Column(name = "SEQ")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int seq;

    @Column(name = "STATUS")
    private char status;

    @Column(name = "PLACE_ID")
    private String placeId;

    @Column(name = "USER_ID")
    private String userId;

    @Column(name = "WRITE_DT")
    private Date writeDt;


}
