package org.rosemwal.lld.designpatterns.builder;

public class BuilderMain {

    public static void main(String[] args)  {

    String protocol = "https://";
    String hostName = "hostName";
    String port = "8080";

    UrlFormatter urlFormatter = new UrlFormatter();
    UrlFormatter urlFormatter1 = new UrlFormatter(protocol);
    UrlFormatter urlFormatter2 = new UrlFormatter(protocol, hostName, port);
    System.out.println("Without Builder " + urlFormatter2.toString());

    UrlFormatter.Builder builder = new UrlFormatter.Builder();
    builder.protocol("https://");
    builder.hostname("hostname");
    builder.port("port");

    UrlFormatter formatter = builder.build();
    System.out.println("Builder " + formatter.toString());

    }
}
