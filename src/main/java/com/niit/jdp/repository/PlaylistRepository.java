/*
 * Author : Ketki Keni
 * Date : 30-11-2022
 * Created with : IntelliJ IDEA Community Edition
 */

package com.niit.jdp.repository;

import com.niit.jdp.model.Song;
import com.niit.jdp.service.DatabaseService;
import com.niit.jdp.service.MusicPlayerService;
import com.sun.jdi.connect.spi.Connection;

import java.util.List;

public class PlaylistRepository {
    Connection connection;
    DatabaseService databaseService;
    MusicPlayerService musicPlayerService;

    public PlaylistRepository() {
    }

    public List<Song> displayPlaylistSongs() {
        return null;
    }

    public boolean addSong() {
        return false;
    }

    public void createPlaylist() {

    }
}
