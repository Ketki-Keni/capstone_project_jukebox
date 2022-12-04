/*
 * Author : Ketki Keni
 * Date : 30-11-2022
 * Created with : IntelliJ IDEA Community Edition
 */

package com.niit.jdp.repository;

import com.niit.jdp.exception.ArtistNameNotFoundException;
import com.niit.jdp.exception.GenreNotFoundException;
import com.niit.jdp.exception.SongNotFoundException;
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
        musicPlayerService = new MusicPlayerService();
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
                String album = resultSet.getString("album");
                Song song = new Song(serialNumber, name, duration, genre, artistName, album);
                songList.add(song);
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return songList;
    }

    public Song getSongBySerialNumber(int serialNumber) throws SongNotFoundException {
        String selectQuery = "SELECT * FROM `jukebox`.`song` where (`serial_number` = ?);";
        Song song = null;
        if (serialNumber <= 0) {
            throw new SongNotFoundException("Id not available! Please enter correct Id.");
        }
        try (PreparedStatement preparedStatement = connection.prepareStatement(selectQuery)) {
            preparedStatement.setInt(1, serialNumber);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int serialNumber1 = resultSet.getInt("serial_number");
                String songName = resultSet.getString("name");
                double duration = resultSet.getDouble("duration");
                String genre = resultSet.getString("genre");
                String artistName = resultSet.getString("artist_name");
                String album = resultSet.getString("album");
                String songPath = resultSet.getString("song_path");
                song = new Song(serialNumber1, songName, duration, genre, artistName, album);
                song.setSongPath(songPath);
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return song;
    }

    public Song getSongByName(String name) throws SongNotFoundException {
        if (name.equals(null) || name.isEmpty()) {
            throw new SongNotFoundException("Song not found! Please enter correct song name.");
        }
        String selectQuery = "SELECT * FROM `jukebox`.`song` where (`name` = ?);";
        Song song = null;
        boolean nameAvailable = song.getName().equals(name);
        if (!nameAvailable) {
            throw new SongNotFoundException("Song not found! Please enter correct song name.");
        }
        try (PreparedStatement preparedStatement = connection.prepareStatement(selectQuery)) {
            preparedStatement.setString(1, name);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int serialNumber = resultSet.getInt("serial_number");
                String songName = resultSet.getString("name");
                double duration = resultSet.getDouble("duration");
                String genre = resultSet.getString("genre");
                String artistName = resultSet.getString("artist_name");
                String album = resultSet.getString("album");
                String songPath = resultSet.getString("song_path");
                song = new Song(serialNumber, songName, duration, genre, artistName, album);
                song.setSongPath(songPath);
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return song;

    }

    public List<Song> displaySongsByGenre(String genre) throws GenreNotFoundException {
        List<Song> songList = new ArrayList<>();
        String selectQuery = "SELECT * FROM `jukebox`.`song` where (`genre` = ?);";
        boolean genreAvailable = songList.contains(genre);
        if (genre == null || genre.isEmpty()) {
            throw new GenreNotFoundException("Genre not available! Please enter correct genre.");
        }
        if (!genreAvailable) {
            throw new GenreNotFoundException("Genre not available! Please enter correct genre.");
        }
        try (PreparedStatement preparedStatement = connection.prepareStatement(selectQuery)) {
            preparedStatement.setString(1, genre);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int serialNumber = resultSet.getInt("serial_number");
                String name = resultSet.getString("name");
                double duration = resultSet.getDouble("duration");
                String songGenre = resultSet.getString("genre");
                String artistName = resultSet.getString("artist_name");
                String album = resultSet.getString("album");
                Song song = new Song(serialNumber, name, duration, songGenre, artistName, album);
                songList.add(song);
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return songList;
    }

    public List<Song> displaySongsByArtistName(String artistName) throws ArtistNameNotFoundException {
        List<Song> songList = new ArrayList<>();
        String selectQuery = "SELECT * FROM `jukebox`.`song` where (`artist_name` = ?);";
        if (artistName == null || artistName.isEmpty()) {
            throw new ArtistNameNotFoundException("Artist's name not found! Please enter correct Artist name.");
        }
        boolean artistAvailable = songList.contains(artistName);
        if (!artistAvailable) {
            throw new ArtistNameNotFoundException("Artist's name not found! Please enter correct Artist name.");
        }
        try (PreparedStatement preparedStatement = connection.prepareStatement(selectQuery)) {
            preparedStatement.setString(1, artistName);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int serialNumber = resultSet.getInt("serial_number");
                String name = resultSet.getString("name");
                double duration = resultSet.getDouble("duration");
                String songGenre = resultSet.getString("genre");
                String artistName1 = resultSet.getString("artist_name");
                String album = resultSet.getString("album");
                Song song = new Song(serialNumber, name, duration, songGenre, artistName1, album);
                songList.add(song);
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return songList;
    }
}
