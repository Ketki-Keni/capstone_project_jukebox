/*
 * Author : Ketki Keni
 * Date : 30-11-2022
 * Created with : IntelliJ IDEA Community Edition
 */

package com.niit.jdp.model;

import java.util.List;
import java.util.Objects;

public class Playlist {
    List<Song> songList;
    private int playlistNumber;
    private String name;

    public Playlist() {
    }

    public Playlist(int playlistNumber, String name) {
        this.playlistNumber = playlistNumber;
        this.name = name;
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

    @Override
    public String toString() {
        return String.format("%s\t%-10s", playlistNumber, name);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Playlist playlist = (Playlist) o;
        return getPlaylistNumber() == playlist.getPlaylistNumber() && Objects.equals(getName(), playlist.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getPlaylistNumber(), getName());
    }
}
