package org.rosemwal.lld.designpatterns.compositepattern.FileSystem;

import java.util.LinkedList;
import java.util.List;

public class Directory implements FileSystem {

    String directoryName;
    List<FileSystem> fileSystemList;

    Directory(String directoryName) {
        this.directoryName = directoryName;
        fileSystemList = new LinkedList<>();
    }

    public void add(FileSystem fs)   {
        this.fileSystemList.add(fs);
    }

    @Override
    public void ls() {

        System.out.println("Directory "+ directoryName);

        for (FileSystem fs : fileSystemList)    {
            fs.ls();
        }

    }
}
