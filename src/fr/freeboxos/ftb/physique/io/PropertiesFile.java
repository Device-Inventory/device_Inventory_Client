/*
 * Copyright (C) 2020 alan
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package fr.freeboxos.ftb.physique.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Properties;

/**
 *
 * @author alan
 */
public class PropertiesFile {

    private final static String NOM_DU_FICHIER = "server.properties";

    public void createFile() throws IOException {
        File file = new File(NOM_DU_FICHIER);
        if (file.createNewFile()) {
            System.out.println("server.properties File created in project root directory");
            String fileData = "server.url=http://127.0.0.1:9999";
            try (FileOutputStream fos = new FileOutputStream(file)) {
                fos.write(fileData.getBytes());
                fos.flush();
            }
        } else {
            System.out.println("File file.txt already exists in the project root directory");
        }
    }

    public void setUrl(String url) {
        FileInputStream in = null;
        String resultat = null;
        try {
            Properties prop = new Properties();
            in = new FileInputStream(NOM_DU_FICHIER);
            OutputStream outputStream = new FileOutputStream("server.properties");
            prop.load(in);
            in.close();
            prop.setProperty("server.url", url);
            prop.store(outputStream, "");
        } catch (IOException e) {
            System.err.println(e.getMessage() + "\nusing default url : " + resultat);
        } finally {
            try {
                if (in != null) {
                    in.close();
                }
            } catch (IOException e) {
                System.err.println(e.getMessage());
            }
        }
    }

    public String getUrl() {
        FileInputStream in = null;
        String resultat = null;
        try {
            Properties prop = new Properties();
            in = new FileInputStream(NOM_DU_FICHIER);
            prop.load(in);
            in.close();
            resultat = prop.getProperty("server.url");
        } catch (IOException e) {
            System.err.println(e.getMessage() + "\nusing default url : " + resultat);
        } finally {
            try {
                if (in != null) {
                    in.close();
                }
            } catch (IOException e) {
                System.err.println(e.getMessage());
            }
        }
        return resultat;
    }
}
