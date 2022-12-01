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
        String selectQuery = "SELECT * FROM `jukebox`.`playlist`";

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

    public Playlist createPlaylist(String playlistName) {
        Playlist playlist = new Playlist();
        String insertQuery = "INSERT INTO `jukebox`.`playlist` (`name`) VALUES (?);";
        try (PreparedStatement preparedStatement = connection.prepareStatement(insertQuery, Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setString(1, playlistName);
            int result = preparedStatement.executeUpdate();
            if (result > 0) {
                ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
                if (generatedKeys.next()) {
                    playlist.setPlaylistNumber(generatedKeys.getInt(1));
                    playlist.setName(playlistName);
                }
            }

        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return playlist;
    }

    public boolean addSong(int playlistId, String songIds) throws SQLException {
        String updateQuery = "update `music_player`.`playlist` set `song_id` = ? where `Playlist_number` = ?;";
        PreparedStatement statement = connection.prepareStatement(updateQuery);
        statement.setString(1, songIds);
        statement.setInt(2, playlistId);
        int result = statement.executeUpdate();
        return result > 0;
    }
}
