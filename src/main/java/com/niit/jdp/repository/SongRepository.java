/*
 * Author : Ketki Keni
 * Date : 30-11-2022
 * Created with : IntelliJ IDEA Community Edition
 */

package com.niit.jdp.repository;

import com.niit.jdp.model.Song;
import com.niit.jdp.service.DatabaseService;
import com.niit.jdp.service.MusicPlayerService;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SongRepository {
    Connection connection;
    DatabaseService databaseService;
    MusicPlayerService musicPlayerService;

    public SongRepository() throws SQLException {
        databaseService = new DatabaseService();
        connection = databaseService.getConnection();
    }

    public List<Song> displayAllSongs() {
        List<Song> songList = new ArrayList<>();
        String selectQuery = "SELECT * FROM `jukebox`.`song`;";

        try (Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(selectQuery);
            while (resultSet.next()) {
                int serialNumber = resultSet.getInt("serial_number");
                String name = resultSet.getString("name");
                double duration = resultSet.getDouble("duration");
                String genre = resultSet.getString("genre");
                String artistName = resultSet.getString("artist_name");
                Song song = new Song(serialNumber, name, duration, genre, artistName);
                songList.add(song);
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
        }

        return songList;
    }

    public Song displaySongByName(String name) {
        String selectQuery = "SELECT * FROM `jukebox`.`song` where (`name` = ?);";
        Song song = null;
        try (PreparedStatement preparedStatement = connection.prepareStatement(selectQuery)) {
            preparedStatement.setString(1, name);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int serialNumber = resultSet.getInt("serial_number");
                String songName = resultSet.getString("name");
                double duration = resultSet.getDouble("duration");
                String genre = resultSet.getString("genre");
                String artistName = resultSet.getString("artist_name");
                song = new Song(serialNumber, songName, duration, genre, artistName);
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return song;
    }

    public List<Song> displaySongsByGenre() {
        return null;
    }

    public List<Song> displaySongsByArtistName() {
        return null;
    }
}
