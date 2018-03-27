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
package com.graphaware.nlp.dsl.procedure;

import com.graphaware.nlp.dsl.AbstractDSL;
import com.graphaware.nlp.dsl.request.ModelBagRequest;
import com.graphaware.nlp.dsl.result.ModelBagResult;
import com.graphaware.nlp.dsl.result.SingleResult;
import com.graphaware.nlp.model.ModelBagRegistry;
import org.neo4j.procedure.Name;
import org.neo4j.procedure.Procedure;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public class ModelBagProcedure extends AbstractDSL {

    @Procedure(name = "ga.nlp.workdir.register")
    public Stream<SingleResult> register(@Name("request") Map<String, Object> request) {
        ModelBagRequest modelBagRequest = ModelBagRequest.fromMap(request);
        ModelBagRegistry registry = (ModelBagRegistry) getNLPManager().getExtension(ModelBagRegistry.class);
        registry.register(modelBagRequest);

        return Stream.of(SingleResult.success());
    }

    @Procedure(name = "ga.nlp.workdir.remove")
    public Stream<SingleResult> remove(@Name("name") String name) {
        ModelBagRegistry registry = (ModelBagRegistry) getNLPManager().getExtension(ModelBagRegistry.class);
        registry.remove(name);

        return Stream.of(SingleResult.success());
    }

    @Procedure(name = "ga.nlp.workdir.list")
    public Stream<ModelBagResult> list() {
        ModelBagRegistry registry = (ModelBagRegistry) getNLPManager().getExtension(ModelBagRegistry.class);
        List<ModelBagResult> results = new ArrayList<>();
        registry.all().forEach( (s, model) -> {
            try {
                results.add(new ModelBagResult(s, model.rootPath()));
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });

        return results.stream();
    }

}
