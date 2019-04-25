package com.copernicana.tripregistry.model.tripForm;

import com.copernicana.tripregistry.model.Trip;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "ATRAKCJE")
public class Attraction implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

//    Todo -provider?
    private String name;
    private String attractionDetails;

    @Temporal(TemporalType.DATE)
    private Date date;
    private String hourFrom;
    private String hourTo;

    @ManyToOne
    @JoinColumn(name = "wycieczki_id")
    private Trip trip;


    @Lob
    private String remarks;


    public Attraction(long id, Date date, String hourFrom, String hourTo, String name, Trip trip, String remarks) {
    }

    public Attraction() {
    }

    public String getAttractionDetails() {
        return attractionDetails;
    }

    public void setAttractionDetails(String attractionDetails) {
        this.attractionDetails = attractionDetails;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getHourFrom() {
        return hourFrom;
    }

    public void setHourFrom(String hourFrom) {
        this.hourFrom = hourFrom;
    }

    public String getHourTo() {
        return hourTo;
    }

    public void setHourTo(String hourTo) {
        this.hourTo = hourTo;
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
