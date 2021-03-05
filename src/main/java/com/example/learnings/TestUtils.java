package com.example.learnings;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;


public class TestUtils {

    private static final Logger LOGGER = LoggerFactory.getLogger(TestUtils.class);

    private ObjectMapper mapper;

    private static final TestUtils testUtils =new TestUtils();

    private TestUtils(){
        initMapper();
    }

    public static TestUtils getInstance() {
        return testUtils;
    }

    public void initMapper() {
        mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        mapper.configure(JsonParser.Feature.AUTO_CLOSE_SOURCE, true);
        mapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
    }



    public <T> T getObjectFromJsonFile(String file,Class<T> t){
        try {
            return mapper.readValue(new File(file),t);
        } catch (Exception e) {
            LOGGER.info("cannot read object from file {} ",file);
            LOGGER.info("error",e);
        }
        return null;
    }
}
