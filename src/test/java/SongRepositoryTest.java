/*
 * Author : Ketki Keni
 * Date : 02-12-2022
 * Created with : IntelliJ IDEA Community Edition
 */

import com.niit.jdp.model.Song;
import com.niit.jdp.repository.SongRepository;
import com.niit.jdp.service.DatabaseService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class SongRepositoryTest {
    SongRepository songRepository;
    DatabaseService databaseService;
    Connection connection;
    List<Song> songList;

    @Before
    public void setUp() throws SQLException {
        databaseService = new DatabaseService();
        connection = databaseService.getConnection();
        songRepository = new SongRepository();
    }

    @After
    public void tearDown() {
        databaseService = null;
        songRepository = null;
        connection = null;
    }

    @Test
    public void givenSongsDatabaseThenReturnNumberOfSongRecords() {
        songList = songRepository.displayAllSongs();
        assertEquals(9, songList.size());
    }

    @Test
    public void givenSongsDatabaseThenReturnSongRecords() {
        Song expected = new Song(1, "Genshin Impact Main Theme", 1.46, "game ost", "Yu-Peng Chen", "The Wind and the Star Traveler");
        songList = songRepository.displayAllSongs();
        assertEquals(expected, songList.get(0));
    }

    @Test
    public void givenGenreThenReturnSongRecordsByGenre() {
        List<Song> output = songRepository.displaySongsByGenre("game ost");
        assertEquals("game ost", output.get(0).getGenre());
    }

    @Test
    public void givenArtistNameThenReturnSongRecordsByArtistName() {
        List<Song> output = songRepository.displaySongsByArtistName("Skrillex");
        assertEquals("Skrillex", output.get(0).getArtistName());
    }

    @Test
    public void givenSongIdThenReturnSongRecordById() {
        Song actual = songRepository.getSongBySerialNumber(1);
        assertEquals(1, actual.getSerialNumber());
    }

    @Test
    public void givenSongNameThenReturnSongRecord() {
        Song actual = songRepository.getSongByName("Demons");
        assertEquals("Demons", actual.getName());
    }
}
