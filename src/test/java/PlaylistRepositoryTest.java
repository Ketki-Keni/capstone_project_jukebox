/*
 * Author : Ketki Keni
 * Date : 03-12-2022
 * Created with : IntelliJ IDEA Community Edition
 */

import com.niit.jdp.repository.SongRepository;
import com.niit.jdp.service.DatabaseService;
import org.junit.Before;

import java.sql.Connection;
import java.sql.SQLException;

public class PlaylistRepositoryTest {
    SongRepository songRepository;
    DatabaseService databaseService;
    Connection connection;

    @Before
    public void setUp() throws SQLException {
        databaseService = new DatabaseService();
        connection = databaseService.getConnection();
        songRepository = new SongRepository();
    }
}
