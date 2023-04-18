package br.com.souzasilva;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;

import java.util.List;

@Data
public class kml {

    @JsonProperty("Folder")
    private RootFolder folder;

    @Data
    public static class RootFolder {
        private String name;
        @JsonProperty("Document")
        private Document document;
    }

    @Data
    public static class Document {
        @JsonProperty("Folder")
        private Folder folder;
    }

    @Data
    public static class Folder {
        @JsonProperty("Placemark")
        private List<Placemark> placemark;
    }

    @Data
    public static class Placemark {
        private String name;
        @JsonProperty("Style")
        private Style style;
        @JsonProperty("Point")
        private Point point;
    }

    @Data
    public static class Style {
        @JsonProperty("IconStyle")
        private IconStyle iconStyle;
    }

    @Data
    public static class IconStyle {
        @JsonProperty("Icon")
        private Icon icon;
    }

    @Data
    public static class Icon {
        private String href;
    }

    @Data
    public static class Point {
        @JsonPropertyOrder("Point")
        private String point;
    }
}
