/*
 * Author : Ketki Keni
 * Date : 30-11-2022
 * Created with : IntelliJ IDEA Community Edition
 */

package com.niit.jdp.model;

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
}
