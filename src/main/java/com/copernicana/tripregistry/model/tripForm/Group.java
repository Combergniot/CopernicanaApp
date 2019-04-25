package com.copernicana.tripregistry.model.tripForm;

import com.copernicana.tripregistry.model.Trip;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "grupy")
public class Group implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private int adultsNo;
    private int childrenNo;
    private int staffNo;

    private String groupType;

    @OneToOne
    @JoinColumn(name="wycieczki_id")
    private Trip trip;

    @Lob
    private String remarks;


    public Group() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getAdultsNo() {
        return adultsNo;
    }

    public void setAdultsNo(int adultsNo) {
        this.adultsNo = adultsNo;
    }

    public int getChildrenNo() {
        return childrenNo;
    }

    public void setChildrenNo(int childrenNo) {
        this.childrenNo = childrenNo;
    }

    public int getStaffNo() {
        return staffNo;
    }

    public void setStaffNo(int staffNo) {
        this.staffNo = staffNo;
    }

    public String getGroupType() {
        return groupType;
    }

    public void setGroupType(String groupType) {
        this.groupType = groupType;
    }

    public Trip getTrip() {
        return trip;
    }

    public void setTrip(Trip trip) {
        this.trip = trip;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
}
