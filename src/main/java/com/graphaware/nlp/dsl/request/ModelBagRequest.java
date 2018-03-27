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
package com.graphaware.nlp.dsl.request;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class ModelBagRequest extends AbstractProcedureRequest {

    private String name;

    private String rootPath;

    public static ModelBagRequest fromMap(Map<String, Object> map) {
        return mapper.convertValue(map, ModelBagRequest.class);
    }

    @Override
    public List<String> validMapKeys() {
        return Arrays.asList("rootPath","name");
    }

    public String getName() {
        return name;
    }

    public String getRootPath() {
        return rootPath;
    }
}
