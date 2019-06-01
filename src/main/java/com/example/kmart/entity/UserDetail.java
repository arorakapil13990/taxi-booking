package com.example.kmart.entity;

import com.example.kmart.enums.Role;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;

import javax.persistence.*;
import java.util.List;

@ApiOperation(value = "userDetail",
        notes = "Contains information about users.")
@Entity
public class UserDetail {

    @ApiModelProperty(notes = "Primary key of User Detail.", name = "userDetail", required = true)
    @Id
    private long userId;

    @ApiModelProperty(notes = "Validation for banned clients", name = "banned", required = true)
    private String banned;

    @ApiModelProperty(notes = "User as client , driver or partner.", name = "role", required = true)
    @Enumerated(EnumType.STRING)
    private Role role;

    @ApiModelProperty(notes = "Trip information", name = "tripDetail", required = true)
    @OneToMany(mappedBy = "userDetail")
    private List<TripDetail> tripDetail;

    public UserDetail() {
    }

    public UserDetail(long userId, String banned, Role role, List<TripDetail> tripDetail) {
        this.userId = userId;
        this.banned = banned;
        this.role = role;
        this.tripDetail = tripDetail;
    }

    public List<TripDetail> getTripDetail() {
        return tripDetail;
    }

    public void setTripDetail(List<TripDetail> tripDetail) {
        this.tripDetail = tripDetail;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getBanned() {
        return banned;
    }

    public void setBanned(String banned) {
        this.banned = banned;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "UserDetail [userId=" + userId + ", banned=" + banned + ", role=" + role + ", tripDetail="
                + tripDetail + "]";
    }

}
