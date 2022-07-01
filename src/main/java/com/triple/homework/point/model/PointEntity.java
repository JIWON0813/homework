package com.triple.homework.point.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "POINT")
@Builder
public class PointEntity {

    @Id
    @Column(name = "PLACE_ID")
    private String placeId;

    @Column(name = "USER_ID")
    private String userId;

    @Column(name = "WRITE_DT")
    private Date writeDt;


}
