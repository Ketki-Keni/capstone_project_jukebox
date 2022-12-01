/*
 * Author : Ketki Keni
 * Date : 30-11-2022
 * Created with : IntelliJ IDEA Community Edition
 */

package com.niit.jdp.repository;

import com.niit.jdp.model.Playlist;
import com.niit.jdp.model.Song;
import com.niit.jdp.service.DatabaseService;
import com.niit.jdp.service.MusicPlayerService;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PlaylistRepository {
    Connection connection;
    DatabaseService databaseService;
    MusicPlayerService musicPlayerService;

    public PlaylistRepository() throws SQLException {
        databaseService = new DatabaseService();
        connection = databaseService.getConnection();
        musicPlayerService = new MusicPlayerService();
    }

    public List<Song> displayPlaylistSongs() {
        List<Song> songList = new ArrayList<>();
        String selectQuery = "SELECT * FROM `jukebox`.`song` INNER JOIN `jukebox`.`playlist` ON `song`.`serial_number` = `playlist`.`serial_number`;";

        try (Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(selectQuery);
            while (resultSet.next()) {
                int serialNumber = resultSet.getInt("serial_number");
                String name = resultSet.getString("name");
                double duration = resultSet.getDouble("duration");
                String genre = resultSet.getString("genre");
                String artistName = resultSet.getString("artist_name");
                String album = resultSet.getString("album");
                Song song = new Song(serialNumber, name, duration, genre, artistName, album);
                songList.add(song);
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return songList;
    }

    public boolean addSong() {
        return false;
    }

    public boolean createPlaylist(Playlist playlist) {
        int numberOfRowsAffected = 0;
        String insertQuery = "INSERT INTO `jukebox`.`playlist` VALUES (?, ?, ?);";
        try (PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {
            preparedStatement.setInt(1, playlist.getPlaylistNumber());
            preparedStatement.setString(2, playlist.getName());
            numberOfRowsAffected = preparedStatement.executeUpdate();

        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return numberOfRowsAffected > 0;
    }
}
