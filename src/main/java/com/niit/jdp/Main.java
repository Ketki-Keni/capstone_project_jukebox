package com.niit.jdp;

import com.niit.jdp.model.Song;
import com.niit.jdp.repository.SongRepository;
import com.niit.jdp.service.MusicPlayerService;

import java.sql.SQLException;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        try {
            SongRepository songRepository = new SongRepository();
            List<Song> allsongs = songRepository.displayAllSongs();
            ;
            for (Song song : allsongs) {
                System.out.println(song);
            }

            System.out.println("Song based on name");
            System.out.println(songRepository.displaySongByName("Liyue"));

        } catch (SQLException exception) {
            exception.printStackTrace();
        }

        MusicPlayerService musicPlayerService = new MusicPlayerService();
        //musicPlayerService.play("src/main/resources/songs/01-Genshin-Impact-Main-Theme.wav");
    }
}