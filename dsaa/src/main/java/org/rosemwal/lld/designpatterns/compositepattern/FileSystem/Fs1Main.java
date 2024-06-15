package org.rosemwal.lld.designpatterns.compositepattern.FileSystem;

public class Fs1Main {

    public static void main(String[] args) {

        Directory movieDirectory = new Directory("Movies");

        FileSystem border = new File("Border");
        movieDirectory.add(border);

        Directory comedyMovieDirectory = new Directory("ComedyMovie");
        File hulchul = new File("Hulchul");
        comedyMovieDirectory.add(hulchul);
        movieDirectory.add(comedyMovieDirectory);

        movieDirectory.ls();
    }

}
