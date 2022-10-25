package lviv.lits;

public final class SqlQueries {
    public static final String CREATE_TABLE = """
        CREATE TABLE IF NOT EXISTS user (

        id int PRIMARY KEY AUTO_INCREMENT,
        first_name varchar(50),
        last_name varchar(50),
        age int)
         
         """;

    public static final String INSERT_USERS = """
        INSERT INTO user (first_name, last_name,age) VALUES
        ('john', 'snow',42),
        ('max', 'pax',18),
        ('tirion', 'lanister',30)
        """;

    public static final String UPDATE_USER_AGE = """
        UPDATE user SET age=? WHERE id =?
        """;

    public static final String SELECT_ALL_USERS = "SELECT * FROM user";


    private SqlQueries() {
    }
}
