package downloader;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class Parser {

    /**
     * Метод cutTheString принимает строку вида:
     * https://video.innopolis.university/vod/STC/STC27/STC27_vebinar_23_07.10.2020.mp4/embed.html
     * на выходе получаем:
     * https://video.innopolis.university/vod/STC/STC27/STC27_vebinar_23_07.10.2020.mp4
     *
     * @param string входная строка
     * @return выходная строка
     */
    public static String cutTheString(String string) {
        String resultString = string.substring(0, string.length() - 10);
        return resultString;
    }

    /**
     * downloader формирует ссылки и качает в папку сегменты
     *
     * @param generalList принимает коллекцию ссылок вида:
     *                    https://video.university.innopolis.ru/vod/2018/STC12/01_17.08.2018.mp4
     *                    и дополняет до полной:
     *                    https://video.university.innopolis.ru/vod/2018/STC12/01_17.08.2018.mp4/tracks-v1a1/segment1.ts
     */
    public void downloader(List<String> generalList, String pathToDownloadDir) throws IOException {
        Downloader downloader = new Downloader();
        String fullLink;
        String pathToSaveFile;
        String stringToSavePathToTxtFile;
        String folderName;
        String fullPath;
        for (String partLink : generalList) {
            partLink = Parser.cutTheString(partLink);
            folderName = partLink.substring(partLink.length() - 18, partLink.length() - 5);
            fullPath = pathToDownloadDir + folderName + "/";
            new File(fullPath).mkdir();
            File file = new File(fullPath + "list.txt");
            FileWriter fileWriter = new FileWriter(file);
            for (int i = 1; i < 3; i++) {
                pathToSaveFile = fullPath + "segment" + i + ".ts";
                fullLink = partLink + "tracks-v1a1/segment" + i + ".ts";
                stringToSavePathToTxtFile = "file " + pathToDownloadDir + folderName + "/" + "segment" + i + ".ts'";
                downloader.download(fullLink, pathToSaveFile);
                fileWriter.write(stringToSavePathToTxtFile + "\n");
                fileWriter.flush();
            }
            System.out.println("Files saved to dir: " + fullPath);
        }
    }
}
