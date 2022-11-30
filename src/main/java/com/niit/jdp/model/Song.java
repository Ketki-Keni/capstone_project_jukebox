/*
 * Author : Ketki Keni
 * Date : 30-11-2022
 * Created with : IntelliJ IDEA Community Edition
 */

package com.niit.jdp.model;

import java.util.Objects;

public class Song {
    private int serialNumber;
    private String name;
    private double duration;
    private String genre;
    private String artistName;

    public Song() {
    }

    public Song(int serialNumber, String name, double duration, String genre, String artistName) {
        this.serialNumber = serialNumber;
        this.name = name;
        this.duration = duration;
        this.genre = genre;
        this.artistName = artistName;
    }

    public int getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(int serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getDuration() {
        return duration;
    }

    public void setDuration(double duration) {
        this.duration = duration;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getArtistName() {
        return artistName;
    }

    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }

    @Override
    public String toString() {
        return "Song{" +
                "serialNumber=" + serialNumber +
                ", name='" + name + '\'' +
                ", duration=" + duration +
                ", genre='" + genre + '\'' +
                ", artistName='" + artistName + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Song song = (Song) o;
        return getSerialNumber() == song.getSerialNumber() && Double.compare(song.getDuration(), getDuration()) == 0 && Objects.equals(getName(), song.getName()) && Objects.equals(getGenre(), song.getGenre()) && Objects.equals(getArtistName(), song.getArtistName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getSerialNumber(), getName(), getDuration(), getGenre(), getArtistName());
    }
}
