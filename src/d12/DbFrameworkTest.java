package d12;

import org.junit.jupiter.api.*;

import java.sql.Connection;
import java.util.Map;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

public class DbFrameworkTest {

    private static Connection conn;

    // 你的 DbUtils.main 示例里使用的是 tb_user；这里沿用它，避免“改表名/改数据库”
    private static final String TABLE = "tb_user";

    // 为避免和真实数据冲突，生成一个非常不容易重复的 name
    private String uniqueName;

    @BeforeAll
    static void beforeAll() {
        // 不改数据库配置：完全照搬 DbUtils 静态块里写死的连接参数
        conn = DbUtils.connectToDB(
                "com.mysql.cj.jdbc.Driver",
                "jdbc:mysql://localhost:3306/test?useSSL=false&serverTimezone=UTC&characterEncoding=UTF-8",
                "root",
                "root"
        );
        assertNotNull(conn, "数据库连接不应为 null");
    }

    @AfterAll
    static void afterAll() {
        if (conn != null) {
            DbUtils.connClose(conn);
        }
    }

    @BeforeEach
    void setUp() {
        uniqueName = "junit_" + UUID.randomUUID().toString().replace("-", "");
    }

    @AfterEach
    void tearDown() throws Exception {
        // 尽力清理：如果这条记录还存在就删掉
        if (DQL.existsByName(conn, TABLE, uniqueName)) {
            Map<Integer, QueryResult> res = DQL.queryByName(conn, TABLE, uniqueName);
            if (res != null && !res.isEmpty()) {
                Integer id = res.values().iterator().next().getId();
                DML.deleteById(conn, TABLE, id);
            }
        }
    }

    @Test
    void test_insert_query_exists_delete_flow() throws Exception {
        // 1) 插入
        DML.insertDB(conn, TABLE, uniqueName, "pw123");

        // 2) existsByName 应该为 true
        assertTrue(DQL.existsByName(conn, TABLE, uniqueName),
                "插入后 existsByName 应该返回 true");

        // 3) queryByName 应该查到（你的实现查不到会返回 null）
        Map<Integer, QueryResult> res = DQL.queryByName(conn, TABLE, uniqueName);
        assertNotNull(res, "插入后 queryByName 不应返回 null");
        assertFalse(res.isEmpty(), "插入后 queryByName 结果不应为空");

        QueryResult row = res.values().iterator().next();
        assertTrue(row.getId() > 0, "id 应为正数");
        assertEquals(uniqueName, row.getName(), "name 应与插入一致");
        assertEquals("pw123", row.getPassword(), "password 应与插入一致");
        assertNotNull(row.getTime(), "time 不应为 null");

        int id = row.getId();

        // 4) 删除
        DML.deleteById(conn, TABLE, id);

        // 5) 删除后应不存在
        assertFalse(DQL.existsByName(conn, TABLE, uniqueName),
                "删除后 existsByName 应该返回 false");
    }
}
