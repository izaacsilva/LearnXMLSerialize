package br.com.souzasilva;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlText;
import lombok.Data;

import java.util.List;

@Data
public class kml {

    @JsonProperty("Folder")
    @JsonIgnoreProperties(ignoreUnknown = true)
    private RootFolder folder;

    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class RootFolder {
        @JsonProperty("name")
        private String name;
        @JsonProperty("Document")
        private Document document;
    }

    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Document {
        @JsonProperty("Folder")
        private Folder folder;
    }

    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Folder {
        @JacksonXmlProperty(localName = "id")
        private String id;
        @JsonProperty("name")
        private String name;
        @JacksonXmlElementWrapper(useWrapping = false)
        @JacksonXmlProperty(localName = "Placemark")
        private List<Placemark> placemark;
    }

    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Placemark {
        @JsonProperty("name")
        private String name;
        @JsonProperty("ExtendedData")
        private ExtendedData extendedData;
        @JsonProperty("Point")
        private Point point;
        @JsonProperty("LineString")
        private LineString lineString;
    }

    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class ExtendedData {
        @JacksonXmlProperty(localName = "SchemaData")
        private SchemaData schemaData;
    }

    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class SchemaData {
        @JacksonXmlElementWrapper(useWrapping = false)
        @JacksonXmlProperty(localName = "SimpleData")
        private List<SimpleData> simpleDatas;
    }

    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class SimpleData {
        @JacksonXmlProperty(isAttribute = true, localName = "name")
        private String name;
        @JacksonXmlText
        private String value;
    }

    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Point {
        @JsonPropertyOrder("Point")
        private String point;
    }

    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class LineString {
        @JsonPropertyOrder("coordinates")
        private String coordinates;
    }
}
