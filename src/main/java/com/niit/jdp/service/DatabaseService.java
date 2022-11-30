/*
 * Author : Ketki Keni
 * Date : 30-11-2022
 * Created with : IntelliJ IDEA Community Edition
 */

package com.niit.jdp.service;

import java.sql.Connection;

public class DatabaseService {
    private static final String URL = "jdbc:mysql://localhost:3306/jukebox";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "Kets@8452037892";
    Connection connection;

    public DatabaseService() {
        connection = null;
    }

}
