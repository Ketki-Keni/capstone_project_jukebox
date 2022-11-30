/*
 * Author : Ketki Keni
 * Date : 30-11-2022
 * Created with : IntelliJ IDEA Community Edition
 */

package com.niit.jdp.repository;

import com.niit.jdp.service.DatabaseService;
import com.niit.jdp.service.MusicPlayerService;
import com.sun.jdi.connect.spi.Connection;

public class SongRepository {
    Connection connection;
    DatabaseService databaseService;
    MusicPlayerService musicPlayerService;

    public SongRepository() {
    }
}
