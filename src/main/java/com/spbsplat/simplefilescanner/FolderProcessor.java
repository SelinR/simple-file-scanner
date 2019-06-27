package com.spbsplat.simplefilescanner;

import java.io.File;
import java.util.List;
import java.util.Scanner;

public class FolderProcesser {
    private FileScanner fileScanner;
    private KMPSearch kmpSearch;
    private List<Integer> resultList;
    private File file;

    public FolderProcesser(String filePath) {
        this.file = new File(filePath);
        this.kmpSearch = new KMPSearch();
        this.fileScanner = new FileScanner();
    }


    public void processFilesFromFolder(String pathname)
    {
        Scanner scanner = new Scanner(System.in);
        File[] folderEntries = folder.listFiles();
        if (folderEntries != null) {
            for (File entry : folderEntries)
            {
                if (entry.isDirectory())
                {
                    processFilesFromFolder(entry);
                }
                resultList = kmpSearch.performKMPSearch(fileScanner.scanFile(entry.getPath()), scanner.nextLine());
            }
        }

        System.out.println(resultList);
    }
}
