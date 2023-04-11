package com.sparta.group2.model;

import com.sparta.group2.model.sql.ConnectionProvider;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.function.Executable;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import java.sql.*;
import java.util.Properties;

@DisplayName("Connection provider checks:")
public class SQLConnectionProviderChecks {

    private static java.sql.Connection connection;
    private static Properties properties;
    @BeforeEach
    void setup(){
        Properties properties = new Properties();
    }

    @AfterEach
    void windDown(){
        ConnectionProvider.closeConnection();
    }


    @Nested
    @DisplayName("Connection creation checks:")
    public class ConnectionCreationChecks {
        @Test
        @DisplayName("Check that opening a connection does not throw an SQL error")
        void checkThatOpeningAConnectionDoesNotThrowAnSqlError() {
            //Arrange
            //Act
            //Assert
            assertDoesNotThrow(() -> ConnectionProvider.getConnection());
        }
        @Test
        @DisplayName("Check that connection will not run if connection is already open")
        void checkThatConnectionWillNotRunIfConnectionIsAlreadyOpen() {
            //Arrange
            Connection connection = ConnectionProvider.getConnection();
            //Act
            //Assert
            assertTrue(connection == ConnectionProvider.getConnection());
        }
    }
    @Nested
    @DisplayName("Checking login data:")
    public class ConnectionLoginChecks {
        @Test
        @DisplayName("Check url input is not empty")
        void checkUrlInputIsNotEmpty() {
            //Arrange
            String url = "";
            //Act
            Connection connection = ConnectionProvider.getConnection(url, "username", "password");
            //Assert
            assertEquals(null, connection);
        }
        @Test
        @DisplayName("Check url input is not null")
        void checkUrlInputIsNotNull() {
            //Arrange
            String url = null;
            //Act
            Connection connection = ConnectionProvider.getConnection(url, "username", "password");
            //Assert
            assertEquals(null, connection);
        }
        @Test
        @DisplayName("Check username input is not empty")
        void checkUsernameInputIsNotEmpty() {
            //Arrange
            String username = "";
            //Act
            Connection connection = ConnectionProvider.getConnection("url", username, "password");
            //Assert
            assertEquals(null, connection);
        }
        @Test
        @DisplayName("Check username input is not null")
        void checkUsernameInputIsNotNull() {
            //Arrange
            String username = null;
            //Act
            Connection connection = ConnectionProvider.getConnection("url", username, "password");
            //Assert
            assertEquals(null, connection);
        }
        @Test
        @DisplayName("Check password input is not empty")
        void checkPasswordInputIsNotEmpty() {
            //Arrange
            String password = "";
            //Act
            Connection connection = ConnectionProvider.getConnection("url", "username", password);
            //Assert
            assertEquals(null, connection);
        }
        @Test
        @DisplayName("Check password input is not null")
        void checkPasswordInputIsNotNull() {
            //Arrange
            String password = null;
            //Act
            Connection connection = ConnectionProvider.getConnection("url", "username", password);
            //Assert
            assertEquals(null, connection);
        }
    }
    @Nested
    @DisplayName("Connection closing checks:")
    public class ConnectionClosingChecks {
        @Test
        @DisplayName("Check that closing a connection does not throw an SQL error")
        void checkThatClosingAConnectionDoesNotThrowAnSqlError() {
            //Arrange
            ConnectionProvider.getConnection();
            //Act
            //Assert
            assertDoesNotThrow(() -> ConnectionProvider.closeConnection());
        }
        @Test
        @DisplayName("Check that close connection will not throw an exception if the connection is null")
        void checkThatCloseConnectionWillNotThrowAnExceptionIfTheConnectionIsNull() {
            //Arrange
            //Act
            //Assert
            assertDoesNotThrow(() -> ConnectionProvider.closeConnection());
        }
    }
}
