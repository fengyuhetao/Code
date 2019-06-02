import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;

/**
 * 按行读取文件
 * @author HT
 * @version V1.0
 * @package PACKAGE_NAME
 * @date 2019-05-11 19:48
 */
public class FileEntity {
    private int id = 0;

    private String line = "";

    private BufferedReader bufferedReader;

    public FileEntity(BufferedReader bufferedReader) throws IOException {
        this.bufferedReader = bufferedReader;
        setLineId();
    }

    private void setLineId() throws IOException {
        line = bufferedReader.readLine();
        if(line != null) {
            try {
                id = Integer.parseInt(line.trim());
            } catch (NumberFormatException e) {
                id = 0;
            }
        }
    }

    public void close() {
        if(this.bufferedReader != null) {
            try {
                this.bufferedReader.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public FileEntity nextLine() {
        try {
            setLineId();
        } catch (IOException e) {

        }

        return this;
    }

    public int getId() {
        return id;
    }

    public String getLine() {
        return line;
    }
}
