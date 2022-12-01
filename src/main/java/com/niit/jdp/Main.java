package com.niit.jdp;

import com.niit.jdp.repository.SongRepository;
import com.niit.jdp.service.MusicPlayerService;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        MusicPlayerService musicPlayerService = new MusicPlayerService();
        musicPlayerService.play("src/main/resources/songs/01-Genshin-Impact-Main-Theme.wav");

        try {
            SongRepository songRepository = new SongRepository();
            songRepository.displayAllSongs();
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }
}