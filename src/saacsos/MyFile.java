package saacsos;

import java.io.*;

public class MyFile {
    private String directory;
    private String filename;
    private StringBuilder content;

    public MyFile(String directory, String filename) {
        this.directory = directory;
        this.filename = directory + File.separator + filename;
        content = new StringBuilder();
        read();
    }

    public void setContent(String content) {
        this.content = new StringBuilder(content);
    }

    public void append(String content) {
        this.content.append(content);
    }

    public void appendWithNewLine(String content) {
        append(content);
        append(System.lineSeparator());
    }

    public void read() {
        try {
            File file = new File(directory);
            if (!file.exists()) file.mkdirs();
            BufferedReader reader = new BufferedReader(new FileReader(filename));
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line);
                content.append(System.lineSeparator());
            }
            reader.close();
        } catch (FileNotFoundException e) {
            System.out.println("File " + filename + " not found");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getContent() {
        return content.toString();
    }

    public void save() {
        try {
            File file = new File(directory);
            if (!file.exists()) file.mkdirs();
            BufferedWriter writer = new BufferedWriter(new FileWriter(filename));
            writer.write(getContent());
            writer.close();
        } catch (IOException e) {
            System.out.println("File " + filename + " not found");
            e.printStackTrace();
        }

    }
}
