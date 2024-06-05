package com.qsys.users.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;

@Entity
@Getter
@Setter
public class Users {

    private Integer id; //          int(11) NOT NULL AUTO_INCREMENT,
    private String email; //       varchar(255) NOT NULL,
    private String password; //    varchar(255) NOT NULL,
    private String userName; //   varchar(30) DEFAULT NULL,
    private String firstName; //  varchar(255) NOT NULL,
    private String lastName; //   varchar(255) NOT NULL,
    private Integer roleId; //     int(11) DEFAULT 0,
    private Integer locked; //      int(1) DEFAULT 0,
    private Integer enabled; //     int(1) DEFAULT 1,
    private Date createdAt; //  datetime(6) DEFAULT NULL,
    private Date updatedAt; //  datetime(6) DEFAULT NULL,
    private Integer updUsrId; //  int(11) DEFAULT 0,

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getId() {
        return this.id;
    }

}
