package com.graphaware.nlp.util;

import org.junit.Test;

public class DirectoryUtilsTest {

    @Test
    public void testOutputFileConversionForModel() {
        String in = "/Users/ikwattro/dev/_graphs/manning/import/sentiment_tweets.train";
        System.out.println(DirectoryUtils.getFileOutputNameBasedOnSourceFilePathAndOutputName(in, "component-en"));
    }
}
