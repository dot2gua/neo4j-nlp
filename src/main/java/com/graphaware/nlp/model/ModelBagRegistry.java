/*
 * Copyright (c) 2013-2018 GraphAware
 *
 * This file is part of the GraphAware Framework.
 *
 * GraphAware Framework is free software: you can redistribute it and/or modify it under the terms of
 * the GNU General Public License as published by the Free Software Foundation, either
 * version 3 of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY;
 * without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
 * See the GNU General Public License for more details. You should have received a copy of
 * the GNU General Public License along with this program.  If not, see
 * <http://www.gnu.org/licenses/>.
 */
package com.graphaware.nlp.model;

import com.graphaware.common.log.LoggerFactory;
import com.graphaware.nlp.annotation.NLPModuleExtension;
import com.graphaware.nlp.dsl.request.ModelBagRequest;
import com.graphaware.nlp.extension.AbstractExtension;
import org.neo4j.logging.Log;

import java.util.HashMap;
import java.util.Map;

@NLPModuleExtension(name = "fs.input.registry")
public class ModelBagRegistry extends AbstractExtension {

    private static final Map<String, ModelBag> modelBags = new HashMap<>();
    private static final Log LOG = LoggerFactory.getLogger(ModelBagRegistry.class);

    public void register(ModelBagRequest modelBagRequest) {
        register(modelBagRequest.getName(), modelBagRequest.getRootPath());
    }

    public void register(String modelName, String rootPath) {
        checkNameValid(modelName);
        modelBags.put(modelName, new DefaultModelBag(modelName, rootPath));
        LOG.info("Registered new modelBag " + modelName);
    }

    public ModelBag get(String name) {
        if (!modelBags.containsKey(name)) {
            throw new RuntimeException("Invalid Model Bag " + name);
        }

        return modelBags.get(name);
    }

    public void remove(String modelName) {
        if (modelBags.containsKey(modelName)) {
            modelBags.remove(modelName);
            LOG.info("Removed model bag " + modelName);
        }
    }

    public Map<String, ModelBag> all() {
        return modelBags;
    }

    private void checkNameValid(String name) {
        if (modelBags.containsKey(name)) {
            throw new IllegalArgumentException("ModelBag " + name + " already exist.");
        }
    }

}
