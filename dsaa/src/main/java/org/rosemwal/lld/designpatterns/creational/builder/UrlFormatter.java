package org.rosemwal.lld.designpatterns.creational.builder;

import lombok.ToString;

@ToString
public class UrlFormatter {

    private String protocol;
    private String hostname;
    private String port;
    private String pathParam;
    private String queryParam;

    public UrlFormatter()   {

    }

    /*
    Old Technique
     */
    public UrlFormatter(String protocol)    {
        this.protocol = protocol;
    }

    public UrlFormatter(String protocol, String hostname)   {
        this.protocol = protocol;
        this.hostname = hostname;
    }

    public UrlFormatter(String protocol, String hostname, String port)  {
        this.protocol = protocol;
        this.hostname = hostname;
        this.port = port;
    }
    /*
    Old Technique
     */

    public static class Builder   {

        private String protocol;
        private String hostname;
        private String port;
        private String pathParam;
        private String queryParam;

        public Builder protocol(String protocol) {
            this.protocol = protocol;
            return this;
        }

        public Builder hostname(String hostname) {
            this.hostname = hostname;
            return this;
        }

        public Builder port(String port) {
            this.port = port;
            return this;
        }

        public UrlFormatter build() {
            return new UrlFormatter(this);
        }
    }

    private UrlFormatter(Builder builder)   {
        this.protocol = builder.protocol;
        this.hostname = builder.hostname;
        this.port = builder.port;
        this.pathParam = builder.pathParam;
        this.queryParam = builder.queryParam;
    }
}
