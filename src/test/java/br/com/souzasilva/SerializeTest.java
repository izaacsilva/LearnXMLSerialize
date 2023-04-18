package br.com.souzasilva;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class SerializeTest {
    @Test
    void whenJavaSerializedToXmlStr_thenCorrect() throws JsonProcessingException {
        XmlMapper xmlMapper = new XmlMapper();
        String xml = xmlMapper.writeValueAsString(new SampleBean());
        assertNotNull(xml);
        System.out.println(xml);
    }

    @Test
    void whenJavaGotFromXmlStr_thenCorrect() throws IOException {
        XmlMapper xmlMapper = new XmlMapper();
        SampleBean value
                = xmlMapper.readValue("<SimpleBean><x>1</x><y>2</y></SimpleBean>", SampleBean.class);
        assertTrue(value.getX() == 1 && value.getY() == 2);
    }

    @Test
    void whenJavaSerializedToXmlFile_thenCorrect() throws IOException {
        XmlMapper xmlMapper = new XmlMapper();
        xmlMapper.writeValue(new File("simple_bean.xml"), new SampleBean());
        File file = new File("simple_bean.xml");
        assertNotNull(file);
    }

    @Test
    void whenJavaGotFromXmlFile_thenCorrect() throws IOException {
        File file = new File("simple_bean.xml");
        XmlMapper xmlMapper = new XmlMapper();
        SampleBean value = xmlMapper.readValue(file, SampleBean.class);
        assertTrue(value.getX() == 1 && value.getY() == 2);
    }

    @Test
    void whenJavaGotFromKmlFileFerrorivas_thenCorrect() throws IOException {
        File file = new File("Ferrovias.kml");
        XmlMapper xmlMapper = new XmlMapper();
        kml value = xmlMapper.readValue(file, kml.class);
        assertEquals("Ferrovias", value.getFolder().getName());
    }
}
