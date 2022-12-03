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
}
