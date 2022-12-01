package com.niit.jdp;

import com.niit.jdp.service.MusicPlayerService;

public class Main {
    public static void main(String[] args) {
        MusicPlayerService musicPlayerService = new MusicPlayerService();
        musicPlayerService.play("src/main/resources/songs/01-Genshin-Impact-Main-Theme.wav");
    }
}