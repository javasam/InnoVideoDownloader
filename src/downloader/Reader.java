package downloader;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Logger;

/**
 * Reader читает файл построчно и пишет в коллекцию
 * файл должен содержать ссылки вида https://video.innopolis.university/vod/STC/STC27/STC27_vebinar_23_07.10.2020.mp4/embed.html
 */

public class Reader {
    private final static Logger log = Logger.getLogger(Reader.class.getName());

    /**
     * readerFromFile считывает построчно и возвращает коллекцию строк
     *
     * @param pathToFile путь до файла
     * @return ArrayList<String>
     * @throws IOException файл не найден
     */
    public List<String> readerFromFile(String pathToFile) throws IOException {
        List<String> stringGeneralList = new ArrayList<>();
        try (Scanner input = new Scanner(new File(pathToFile))) {
            log.info("Start Scanner");
            while (input.hasNext()) {
                stringGeneralList.add(input.nextLine());
            }
        }
        log.info("ready list from file: " + pathToFile);
        return stringGeneralList;
    }
}


