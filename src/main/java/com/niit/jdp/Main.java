package com.niit.jdp;

import com.niit.jdp.model.Song;
import com.niit.jdp.repository.SongRepository;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try {
            SongRepository songRepository = new SongRepository();
            List<Song> allSongs = songRepository.displayAllSongs();

            for (Song song : allSongs) {
                System.out.println(song);
            }
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter the song name:");
            String songName = scanner.nextLine();
            System.out.println(songRepository.displaySongByName(songName));

        } catch (SQLException exception) {
            exception.printStackTrace();
        }

    }
}