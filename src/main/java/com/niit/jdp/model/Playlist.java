/*
 * Author : Ketki Keni
 * Date : 30-11-2022
 * Created with : IntelliJ IDEA Community Edition
 */

package com.niit.jdp.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Playlist {
    List<Song> songList;
    private int playlistNumber;
    private String name;
    private int serialNumber;

    public Playlist() {
    }

    public Playlist(List<Song> songList, int playlistNumber, String name, int serialNumber) {
        this.songList = new ArrayList<>();
        this.playlistNumber = playlistNumber;
        this.name = name;
        this.serialNumber = serialNumber;
    }

    public List<Song> getSongList() {
        return songList;
    }

    public void setSongList(List<Song> songList) {
        this.songList = songList;
    }

    public int getPlaylistNumber() {
        return playlistNumber;
    }

    public void setPlaylistNumber(int playlistNumber) {
        this.playlistNumber = playlistNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(int serialNumber) {
        this.serialNumber = serialNumber;
    }

    @Override
    public String toString() {
        return "Playlist{" +
                "songList=" + songList +
                ", playlistNumber=" + playlistNumber +
                ", name='" + name + '\'' +
                ", serialNumber=" + serialNumber +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Playlist playlist = (Playlist) o;
        return getPlaylistNumber() == playlist.getPlaylistNumber() && getSerialNumber() == playlist.getSerialNumber() && Objects.equals(getSongList(), playlist.getSongList()) && Objects.equals(getName(), playlist.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getSongList(), getPlaylistNumber(), getName(), getSerialNumber());
    }
}
