package com.github.dugasz1.szoftverteszteles.web.it;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class TestUtil {
    public static void executeSQLFile (Connection connection, String pathToFile) throws IOException, SQLException {
        File file = new File(pathToFile);
        String sqlCmd = fileToString(file);

        Statement statement = connection.createStatement();
        statement.execute(sqlCmd);
    }

    private static String fileToString(File file) throws IOException {
        byte[] bytes = Files.readAllBytes(Paths.get(file.getAbsolutePath()));

        return new String(bytes, StandardCharsets.UTF_8);
    }
}
