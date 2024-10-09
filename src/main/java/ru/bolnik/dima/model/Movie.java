package ru.bolnik.dima.model;

import javax.persistence.*;

@Entity
@Table(name = "Movie")
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "movie_id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "year_of_production")
    private int year;

    @ManyToOne
    @JoinColumn(name = "director_id", referencedColumnName = "director_id")
    private Director director;

    public Movie() {}

    public Movie(String name, int year, Director director) {
        this.name = name;
        this.year = year;
        this.director = director;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public Director getDirector() {
        return director;
    }

    public void setDirector(Director director) {
        this.director = director;
    }

    @Override
    public String toString() {
        return "Movie{" +
               "name='" + name + '\'' +
               ", year=" + year +
               '}';
    }
}
