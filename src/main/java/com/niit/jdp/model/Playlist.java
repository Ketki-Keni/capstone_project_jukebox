/*
 * Author : Ketki Keni
 * Date : 30-11-2022
 * Created with : IntelliJ IDEA Community Edition
 */

package com.niit.jdp.model;

import java.util.List;

public class Playlist {
    List<Song> songList;
    private int playlistNumber;
    private String name;

    public Playlist() {
    }

    public Playlist(List<Song> songList, int playlistNumber, String name) {
        this.songList = songList;
        this.playlistNumber = playlistNumber;
        this.name = name;
    }
}
