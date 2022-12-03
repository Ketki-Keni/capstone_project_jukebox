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
    private String album;
    private String songPath;


    public Song() {
    }

    public Song(int serialNumber, String name, double duration, String genre, String artistName, String album) {
        this.serialNumber = serialNumber;
        this.name = name;
        this.duration = duration;
        this.genre = genre;
        this.artistName = artistName;
        this.album = album;
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

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public String getSongPath() {
        return songPath;
    }

    public void setSongPath(String songPath) {
        this.songPath = songPath;
    }


    @Override
    public String toString() {
        return String.format("%s\t%-25s\t%-10s\t%-20s\t%-20s\t%-10s", serialNumber, name, duration,
                genre, artistName, album);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Song song = (Song) o;
        return getSerialNumber() == song.getSerialNumber() && Double.compare(song.getDuration(), getDuration()) == 0 && Objects.equals(getName(), song.getName()) && Objects.equals(getGenre(), song.getGenre()) && Objects.equals(getArtistName(), song.getArtistName()) && Objects.equals(getAlbum(), song.getAlbum()) && Objects.equals(getSongPath(), song.getSongPath());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getSerialNumber(), getName(), getDuration(), getGenre(), getArtistName(), getAlbum(), getSongPath());
    }
}
