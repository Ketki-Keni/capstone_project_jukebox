package com.niit.jdp;

import com.niit.jdp.exception.GenreNotFoundException;
import com.niit.jdp.exception.SongNotFoundException;
import com.niit.jdp.model.Playlist;
import com.niit.jdp.model.Song;
import com.niit.jdp.repository.PlaylistRepository;
import com.niit.jdp.repository.SongRepository;
import com.niit.jdp.service.MusicPlayerService;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);
            PlaylistRepository playlistRepository = new PlaylistRepository();
            SongRepository songRepository = new SongRepository();
            MusicPlayerService musicPlayerService = new MusicPlayerService();
            List<Song> allSongs = songRepository.displayAllSongs();
            System.out.println("-------------------------------\nCatalog of Songs in the Jukebox\n-------------------------------");
            System.out.println();
            System.out.println("------------------------------------------------------------------------------------------------------------------------------");
            System.out.println(String.format("%s\t%-25s\t%s\t%-20s\t%-20s\t%-10s", "ID", "Name", "Duration",
                    "Genre", "Artist Name", "Album"));
            System.out.println("------------------------------------------------------------------------------------------------------------------------------");
            allSongs.forEach(System.out::println);
            String songName;
            int option;

            do {
                System.out.println("\n----------------------------- \n\t\t\tMenu \n-----------------------------" +
                        "\n1 - Search for a song by genre \n2 - Search for a song by Artist's name " +
                        "\n3 - Search for a song by name and play " +
                        "\n4 - Create playlist \n5 - Select a playlist and add songs " +
                        "\n6 - View playlist and select a song to play  \n7 - Exit");
                System.out.print("Select an option: ");
                option = scanner.nextInt();
                scanner.nextLine();
                switch (option) {
                    case 1:
                        //Search for a song by genre
                        System.out.print("Enter the genre: ");
                        String genre = scanner.next();
                        List<Song> songListByGenre = songRepository.displaySongsByGenre(genre);
                        for (Song songs : songListByGenre) {
                            System.out.println(songs);
                        }
                        System.out.print("Enter the song name to play the song: ");
                        songName = scanner.next();
                        System.out.println(songRepository.getSongByName(songName));
                        musicPlayerService.play(songRepository.getSongByName(songName).getSongPath());
                        System.out.print("Enter 1 - pause, 2 - resume, 3 - stop: ");
                        musicPlayerService.play(songRepository.getSongByName(songName).getSongPath());
                        break;
                    case 2:
                        //Search for a song by Artist's name
                        System.out.print("Enter the name of the artist: ");
                        String artistName = scanner.next();
                        List<Song> songListByArtistName = songRepository.displaySongsByArtistName(artistName);
                        for (Song songs : songListByArtistName) {
                            System.out.println(songs);
                        }
                        System.out.print("Enter the song name to play the song: ");
                        songName = scanner.next();
                        System.out.println(songRepository.getSongByName(songName));

                        musicPlayerService.play(songRepository.getSongByName(songName).getSongPath());
                        break;
                    case 3:
                        //Search for a song by name and play
                        System.out.println("Enter the song name to play the song:");
                        songName = scanner.next();
                        System.out.println(songRepository.getSongByName(songName));
                        System.out.println(songRepository.getSongByName(songName).getSongPath());
                        System.out.println("Enter 1 - pause, 2 - resume, 3 - stop: ");
                        musicPlayerService.play(songRepository.getSongByName(songName).getSongPath());
                        break;
                    case 4:
                        //Create playlist
                        System.out.println("Enter the name of the playlist to be created: ");
                        String playlistName = scanner.next();
                        Playlist playlist = playlistRepository.createPlaylist(playlistName);
                        System.out.println("Your playlist has been created with id: " + playlist.getPlaylistNumber());
                        break;
                    case 5:
                        //Select a playlist and add songs
                        System.out.println(playlistRepository.displayAllPlaylists());
                        System.out.println("Enter the playlist id to add songs to the Playlist: ");
                        int playlistId = scanner.nextInt();
                        scanner.nextLine();
                        System.out.println("Enter the song ids to add to the playlist separated by comma: ");
                        String songIds = scanner.nextLine();
                        boolean songsAdded = playlistRepository.addSong(playlistId, songIds);
                        if (songsAdded) {
                            System.out.println("Songs added to the playlist");
                        } else {
                            System.out.println("Something went wrong");
                        }
                        break;
                    case 6:
                        //View playlist and select a song from the playlist to play
                        System.out.println(playlistRepository.displayAllPlaylists());
                        System.out.print("Enter the playlist id to view songs from the playlist: ");
                        int playlistIdToGetSongsFrom = scanner.nextInt();
                        List<Song> songsFromPlaylist = playlistRepository.displayPlaylistSongs(playlistIdToGetSongsFrom);
                        for (Song songs : songsFromPlaylist) {
                            System.out.println(songs);
                        }
                        System.out.print("Enter the song id to play the song: ");
                        int songId = scanner.nextInt();
                        System.out.println(songRepository.getSongBySerialNumber(songId));
                        System.out.println("Enter 1 - pause, 2 - resume, 3 - stop: ");
                        musicPlayerService.play(songRepository.getSongBySerialNumber(songId).getSongPath());
                        break;
                    case 7:
                        break;
                }
            } while (option <= 6 && option >= 1);
        } catch (SQLException | SongNotFoundException | GenreNotFoundException exception) {
            exception.printStackTrace();
        }

    }
}