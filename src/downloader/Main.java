package downloader;

import java.io.IOException;

/**
 * Класс main скачивания видео курсов Иннополиса
 */
public class Main {
    public static void main(String[] args) throws IOException {
        Reader reader = new Reader();
        Parser parser = new Parser();
        parser.downloader(
                reader.readerFromFile("C:/Downloads/Video/stc27.txt"),
                "C:/Downloads/Video/");
    }
}
