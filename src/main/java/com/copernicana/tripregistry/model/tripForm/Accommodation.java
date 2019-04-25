package com.copernicana.tripregistry.model.tripForm;

import com.copernicana.tripregistry.model.Trip;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name="noclegi")
public class Accommodation implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Temporal(TemporalType.DATE)
    private Date dateFrom;
    @Temporal(TemporalType.DATE)
    private  Date dateTo;

//    odwolac sie do dostawcow
    private String hotelName;

    @Lob
    private String remarks;

    @ManyToOne
    @JoinColumn(name = "wycieczki_id")
    private Trip trip;

    public Accommodation(long id, Date dateFrom, Date dateTo, String hotelName, String remarks, Trip trip) {
        this.id = id;
        this.dateFrom = dateFrom;
        this.dateTo = dateTo;
        this.hotelName = hotelName;
        this.remarks = remarks;
        this.trip = trip;
    }

    public Accommodation() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getDateFrom() {
        return dateFrom;
    }

    public void setDateFrom(Date dateFrom) {
        this.dateFrom = dateFrom;
    }

    public Date getDateTo() {
        return dateTo;
    }

    public void setDateTo(Date dateTo) {
        this.dateTo = dateTo;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public Trip getTrip() {
        return trip;
    }

    public void setTrip(Trip trip) {
        this.trip = trip;
    }
}
