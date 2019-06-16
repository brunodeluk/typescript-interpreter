package lexer.input;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileInput implements Input {

    private FileInputStream fs;
    private char data;

    public FileInput(String filename) throws FileNotFoundException {
        this.fs = new FileInputStream(new File(filename));
    }

    @Override
    public void consume() {
        try {
            this.data = (char) fs.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public char next() {
        return this.data;
    }

    @Override
    public boolean hasNext() {
        try {
            if (this.fs.available() >= 0) {
                return true;
            }

            this.fs.close();
            return false;

        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
}
