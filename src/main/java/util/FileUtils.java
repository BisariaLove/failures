package util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by lovebisaria on 02/09/17.
 */
public class FileUtils {

    public static String getFileContentsAsString(String fileName) throws Exception{
        StringBuffer buffer  = new StringBuffer();
        String current = "";
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(fileName));
            while ((current = br.readLine()) != null) {
                buffer.append(current);
            }
        }
        finally {
            if (br != null) {
                br.close();
            }
        }

        return buffer.toString();
    }

    public static List<String> getFileContentsAsList(String fileName) throws Exception{
        List<String> contents = new ArrayList();
        String current = "";
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(fileName));
            while ((current = br.readLine()) != null) {
                contents.add(current);
            }
        }
        finally {
            if (br != null) {
                br.close();
            }
        }

        return contents;
    }


    public static List<String> getResourceFileContentsAsList(String fileName) throws Exception {

        String filePath = getTestFilePath(fileName);
        return getFileContentsAsList(filePath);

    }

    public static String getTestFilePath(String relativeFileName) {
        String absolutePath = new File(".").getAbsolutePath();
        int last = absolutePath.length() - 1;
        absolutePath = absolutePath.substring(0, last);
        String filePath = "src/main/resources/";
        String finalFilePath = absolutePath + filePath + relativeFileName;

        return finalFilePath;
    }
}
