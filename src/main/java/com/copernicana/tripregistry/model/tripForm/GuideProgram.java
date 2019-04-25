package com.copernicana.tripregistry.model.tripForm;

import com.copernicana.tripregistry.model.Trip;
import com.copernicana.tripregistry.model.personalData.Guide;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "USLUGI_PRZEWODNICKIE")
public class GuideProgram implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    // NAZWA PROGRAMU - frywolny, etc.
    private String name;

    @Temporal(TemporalType.DATE)
    private Date date;

    private String hourFrom;
    private String hourTo;

    //nalewki, pierniki, etc.
    @Column
    @ElementCollection(targetClass = String.class, fetch = FetchType.EAGER)
    private Set<String> addition;

    @Column
    @ElementCollection(targetClass = String.class, fetch = FetchType.EAGER)
    private Set<String> language;

    @ManyToOne
    @JoinColumn(name = "wycieczki_id")
    private Trip trip;


    @ManyToMany
    @JoinTable(
            name = "PRZEWODNICY_ZWIEDZANIA",
            joinColumns = @JoinColumn(name = "ZWIEDZANIA_ID", referencedColumnName = "ID"),
            inverseJoinColumns = @JoinColumn(name = "PRZEWODNIK_ID", referencedColumnName = "ID"))
    private List<Guide> guides;


    public GuideProgram() {
    }

    public GuideProgram(long id, String name, Date date, String hourFrom, String hourTo, Set<String> addition, Set<String> language, Trip trip, List<Guide> guides) {
        this.id = id;
        this.name = name;
        this.date = date;
        this.hourFrom = hourFrom;
        this.hourTo = hourTo;
        this.addition = addition;
        this.language = language;
        this.trip = trip;
        this.guides = guides;
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

    public Set<String> getAddition() {
        return addition;
    }

    public void setAddition(Set<String> addition) {
        this.addition = addition;
    }

    public Set<String> getLanguage() {
        return language;
    }

    public void setLanguage(Set<String> language) {
        this.language = language;
    }

    public Trip getTrip() {
        return trip;
    }

    public void setTrip(Trip trip) {
        this.trip = trip;
    }

    public List<Guide> getGuides() {
        return guides;
    }

    public void setGuides(List<Guide> guides) {
        this.guides = guides;
    }

    @Override
    public String toString() {
        return "GuideProgram{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", date=" + date +
                ", hourFrom='" + hourFrom + '\'' +
                ", hourTo='" + hourTo + '\'' +
                ", addition=" + addition +
                ", language=" + language +
                ", trip=" + trip +
                ", guides=" + guides +
                '}';
    }
}


