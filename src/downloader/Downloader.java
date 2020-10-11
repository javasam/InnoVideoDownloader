package downloader;

import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.util.logging.Logger;

/**
 * Download класс для скачивания файлов из интернет
 */

public class Downloader {
    private static Logger log = Logger.getLogger(Downloader.class.getName());

    public void download(String link, String path) {
        try {
            URL url = new URL(link);
            ReadableByteChannel rbc = Channels.newChannel(url.openStream());
            FileOutputStream fos = new FileOutputStream(path);
            fos.getChannel().transferFrom(rbc, 0, Long.MAX_VALUE);
            fos.close();
            rbc.close();
        } catch (IOException e) {
            log.info("link " + link);
            log.info("path " + path);
            log.info("Error: " + e);
        }
    }
}
