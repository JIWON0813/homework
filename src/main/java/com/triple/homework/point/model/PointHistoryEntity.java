package com.triple.homework.point.model;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "POINT_HISTORY")
@Builder
public class PointHistoryEntity {

    @Id
    @Column(name = "SEQ")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int seq;

    @Column(name = "STATUS")
    private char status;

    @Column(name = "USER_ID")
    private String userId;

    @Column(name = "BEFORE_POINT")
    private int beforePoint;

    @Column(name = "AFTER_POINT")
    private int afterPoint;

    @Column(name = "WRITE_DT")
    private Date writeDt;


}
