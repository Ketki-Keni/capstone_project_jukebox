/*
 * Author : Ketki Keni
 * Date : 03-12-2022
 * Created with : IntelliJ IDEA Community Edition
 */

import com.niit.jdp.model.Playlist;
import com.niit.jdp.model.Song;
import com.niit.jdp.repository.PlaylistRepository;
import com.niit.jdp.service.DatabaseService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class PlaylistRepositoryTest {
    PlaylistRepository playlistRepository;
    DatabaseService databaseService;
    Connection connection;

    @Before
    public void setUp() throws SQLException {
        databaseService = new DatabaseService();
        connection = databaseService.getConnection();
        playlistRepository = new PlaylistRepository();
    }

    @After
    public void tearDown() {
        databaseService = null;
        playlistRepository = null;
        connection = null;
    }

    @Test
    public void givenPlaylistDatabaseThenReturnSongRecordsFromPlaylist() throws SQLException {
        List<Song> playlists = playlistRepository.displayPlaylistSongs(11);
        assertEquals(6, playlists.get(0).getSerialNumber());
    }

    @Test
    public void givenPlaylistNameThenCreatePlaylist() throws SQLException {
        Playlist playlist = playlistRepository.createPlaylist("Rock");
        assertEquals("Rock", playlist.getName());
    }

    @Test
    public void givenSongIdsThenAddSongsToPlaylist() throws SQLException {
        boolean addSong = playlistRepository.addSong(11, "2,3");
        assertEquals(true, addSong);
    }
}
