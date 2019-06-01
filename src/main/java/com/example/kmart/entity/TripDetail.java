package com.example.kmart.entity;

import com.example.kmart.enums.Status;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;

import javax.persistence.*;
import java.util.Date;

@ApiOperation(value = "trip",
        notes = "Contains information about trips")
@Entity
public class TripDetail {

    @ApiModelProperty(notes = "Primary key of trip detail.", name = "id", required = true)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ApiModelProperty(notes = "Client Id", name = "clientId", required = true)
    private long clientId;

    @ApiModelProperty(notes = "Status of the trip.", name = "driverId", required = true)
    private long driverId;

    @ApiModelProperty(notes = "Place where the cab is booked from.", name = "regionId", required = true)
    private long regionId;

    @ApiModelProperty(notes = "Status of the trip.", name = "status", required = true)
    @Enumerated(EnumType.STRING)
    private Status status;

    @ApiModelProperty(notes = "Date on which cab is requested for booking.", name = "requestAt", required = true)
    @Temporal(TemporalType.DATE)
    private Date requestAt;

    @ApiModelProperty(notes = "Foreign Key of User Detail.", name = "userDetail", required = true)
    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserDetail userDetail;

    public TripDetail() {
    }

    public TripDetail(long id, long clientId, long driverId, long regionId, Status status, Date requestAt, UserDetail userDetail) {
        this.id = id;
        this.clientId = clientId;
        this.driverId = driverId;
        this.regionId = regionId;
        this.status = status;
        this.requestAt = requestAt;
        this.userDetail = userDetail;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getClientId() {
        return clientId;
    }

    public void setClientId(long clientId) {
        this.clientId = clientId;
    }

    public long getDriverId() {
        return driverId;
    }

    public void setDriverId(long driverId) {
        this.driverId = driverId;
    }

    public long getRegionId() {
        return regionId;
    }

    public void setRegionId(long regionId) {
        this.regionId = regionId;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Date getRequestAt() {
        return requestAt;
    }

    public void setRequestAt(Date requestAt) {
        this.requestAt = requestAt;
    }

    @Override
    public String toString() {
        return "TripDetail [id=" + id + ", clientId=" + clientId + ", driverId=" + driverId + ", regionId="
                + regionId + ", status=" + status + ", requestAt=" + requestAt + "]";
    }


}

