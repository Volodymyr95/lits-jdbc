package lviv.lits;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import static lviv.lits.SqlQueries.*;

public class Main {

    public static void main(String[] args)  {

        try (var connection = DriverManager.getConnection(JDBCConstants.URL, JDBCConstants.USERNAME, JDBCConstants.PASSWORD)) {
            var statement = connection.createStatement();

                     statement.execute(CREATE_TABLE);
                     statement.execute(INSERT_USERS);

            var prepareStatement = connection.prepareStatement(UPDATE_USER_AGE);
            prepareStatement.setInt(1, 18);
            prepareStatement.setInt(2, 1);

            prepareStatement.execute();

            ResultSet resultSet = statement.executeQuery(SELECT_ALL_USERS);

            var users = new ArrayList<>();

            while (resultSet.next()) {
                User user = new User();
                user.setId(resultSet.getInt(1));
                user.setFirstName(resultSet.getString(2));
                user.setLastName(resultSet.getString(3));
                user.setAge(resultSet.getInt("age"));

                users.add(user);
            }

            users.forEach(System.out::println);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
