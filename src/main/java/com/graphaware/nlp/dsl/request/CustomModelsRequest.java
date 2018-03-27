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

import org.neo4j.logging.Log;
import com.graphaware.common.log.LoggerFactory;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CustomModelsRequest extends AbstractProcedureRequest {

    private static final Log LOG = LoggerFactory.getLogger(TextRankRequest.class);
    private final static String PARAMETER_TEXT_PROCESSOR = "textProcessor";
    private final static String PARAMETER_ALG = "alg";
    private final static String PARAMETER_MODEL_ID = "modelId";
    private final static String PARAMETER_INPUT_FILE = "file";
    private final static String PARAMETER_LANG = "lang";
    private final static String PARAMETER_TRAINING_PARAMS = "trainingParameters";
    private final static String PARAMETER_WORKDIR = "workdir";
    private static final String DEFAULT_LANG = "en";

    private String textProcessor;
    private String alg;
    private String modelId;
    private String inputFile;
    private String language;
    private String fs;
    private Map<String, Object> trainingParameters = new HashMap<>();

    public static CustomModelsRequest fromMap(Map<String, Object> request) {
        return mapper.convertValue(request, CustomModelsRequest.class);
    }

    @Override
    public List<String> validMapKeys() {
        return Arrays.asList(PARAMETER_ALG, PARAMETER_INPUT_FILE, PARAMETER_LANG, PARAMETER_TEXT_PROCESSOR, PARAMETER_MODEL_ID, PARAMETER_TRAINING_PARAMS, PARAMETER_WORKDIR);
    }

    @Override
    public List<String> mandatoryKeys() {
        return Arrays.asList(PARAMETER_WORKDIR, PARAMETER_MODEL_ID, PARAMETER_INPUT_FILE, PARAMETER_ALG, PARAMETER_TEXT_PROCESSOR);
    }

    public String getTextProcessor() {
        return textProcessor;
    }

    public String getAlg() {
        return alg;
    }

    public String getModelID() {
        return modelId;
    }

    public String getInputFile() {
        return inputFile;
    }

    public String getLanguage() {
        return null == language ? DEFAULT_LANG : language;
    }

    public String getFs() {
        return fs;
    }

    public Map<String, Object> getTrainingParameters() {
        return trainingParameters;
    }
}
