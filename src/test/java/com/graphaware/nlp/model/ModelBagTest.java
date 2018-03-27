package com.graphaware.nlp.model;

import com.graphaware.nlp.NLPIntegrationTest;
import org.junit.Test;

import java.util.Collections;
import java.util.Map;

import static org.junit.Assert.*;

public class ModelBagTest extends NLPIntegrationTest {

    @Test
    public void testRegisteringResourcesPath() {
        String rPath = getClass().getClassLoader().getResource("").getPath();
        executeInTransaction("CALL ga.nlp.workdir.register({name:'test',rootPath: {path} })", Collections.singletonMap("path", rPath), emptyConsumer());
        executeInTransaction("CALL ga.nlp.workdir.list()", (result -> {
            assertTrue(result.hasNext());
            Map<String, Object> record = result.next();
            assertEquals("test", record.get("name"));
            assertEquals(rPath, record.get("rootPath"));
        }));
    }

    @Test
    public void testFileNameResolver() {
        String rPath = getClass().getClassLoader().getResource("").getPath();
        ModelBagRegistry registry = (ModelBagRegistry) getNLPManager().getExtension(ModelBagRegistry.class);
        registry.register("test2", rPath);
        ModelBag modelBag = registry.get("test2");
        assertEquals(rPath + "train.txt", modelBag.resolveFilePath("train.txt"));
    }
}
