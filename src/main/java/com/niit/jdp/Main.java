package com.niit.jdp;

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
            System.out.println("Catalog of Songs");
            System.out.println("----------------");
            for (Song songs : allSongs) {
                System.out.println(songs);
            }
            String songName;
            int option;
            do {
                System.out.println("\n--------- \nMenu \n--------- \n1 - search for a song by genre \n2 - search for a song by Artist's name " +
                        "\n3 - search for a song by name and play \n4 - create playlist \n5 - select a playlist and add songs " +
                        "\n6 - View playlist \n7 - Exit \nSelect an option: ");
                option = scanner.nextInt();
                scanner.nextLine();
                switch (option) {
                    case 1:
                        System.out.println("Enter the genre:");
                        String genre = scanner.nextLine();
                        List<Song> songListByGenre = songRepository.displaySongsByGenre(genre);
                        for (Song songs : songListByGenre) {
                            System.out.println(songs);
                        }
                        System.out.println("Enter the song name to play the song:");
                        songName = scanner.nextLine();
                        System.out.println(songRepository.getSongByName(songName));
                        musicPlayerService.play(songRepository.getSongByName(songName).getSongPath());
                        System.out.println("Enter 1 - pause, 2 - resume, 3 - stop: ");
                        musicPlayerService.play(songRepository.getSongByName(songName).getSongPath());
                        break;
                    case 2:
                        System.out.println("Enter the name of the artist:");
                        String artistName = scanner.nextLine();
                        List<Song> songListByArtistName = songRepository.displaySongsByArtistName(artistName);
                        for (Song songs : songListByArtistName) {
                            System.out.println(songs);
                        }
                        System.out.println("Enter the song name to play the song:");
                        songName = scanner.nextLine();
                        System.out.println(songRepository.getSongByName(songName));
                        System.out.println("Enter 1 - pause, 2 - resume, 3 - stop: ");
                        musicPlayerService.play(songRepository.getSongByName(songName).getSongPath());
                        break;
                    case 3:
                        System.out.println("Enter the song name to play the song:");
                        songName = scanner.nextLine();
                        System.out.println(songRepository.getSongByName(songName));
                        System.out.println(songRepository.getSongByName(songName).getSongPath());
                        System.out.println("Enter 1 - pause, 2 - resume, 3 - stop: ");
                        musicPlayerService.play(songRepository.getSongByName(songName).getSongPath());
                        break;
                    case 4:
                        System.out.println("Enter the name of the playlist to be created: ");
                        String playlistName = scanner.nextLine();
                        Playlist playlist = playlistRepository.createPlaylist(playlistName);
                        System.out.println("Your playlist has been created with id: " + playlist.getPlaylistNumber());
                        break;
                    case 5:
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
                        System.out.println("Enter the playlist id to get songs from: ");
                        int playlistIdToGetSongsFrom = scanner.nextInt();
                        List<Song> songsFromPlaylist = playlistRepository.displayPlaylistSongs(playlistIdToGetSongsFrom);
                        for (Song songs : songsFromPlaylist) {
                            System.out.println(songs);
                        }
                        System.out.println("Enter the song id to play the song:");
                        int songId = scanner.nextInt();
                        System.out.println(songRepository.getSongBySerialNumber(songId));
                        System.out.println("Enter 1 - pause, 2 - resume, 3 - stop: ");
                        musicPlayerService.play(songRepository.getSongBySerialNumber(songId).getSongPath());
                        break;
                    case 7:
                        break;
                }
            } while (option <= 6 && option >= 1);
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }
}