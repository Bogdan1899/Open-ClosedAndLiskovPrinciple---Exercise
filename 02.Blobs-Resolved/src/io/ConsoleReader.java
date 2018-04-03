package io;

import io.interfaces.Reader;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleReader implements Reader{

    private BufferedReader bufferedReader;

    public ConsoleReader() {
        this.setBufferedReader();
    }

    public BufferedReader getBufferedReader() {
        return bufferedReader;
    }

    private void setBufferedReader() {
        this.bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    }

    @Override
    public String read() throws IOException {
        return this.bufferedReader.readLine();
    }
}
