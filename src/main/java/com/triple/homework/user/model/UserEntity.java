package com.triple.homework.user.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "REVIEW")
@Builder
public class UserEntity {

    @Id
    @Column(name = "USER_ID")
    private String userId;

    @Column(name = "POINT")
    private String point;

    @Column(name = "WRITE_DT")
    private Date writeDt;

    @Column(name = "MODIFY_DT")
    private Date modifyDt;
}
