package com.graphaware.nlp.processor;

import java.util.Map;

public class ModelInfo {

    private final String modelId;

    private final ModelFileInfo modelFileInfo;

    private final String algorithm;

    private final Map<String, Object> parameters;

    public ModelInfo(String modelId, ModelFileInfo modelFileInfo, String algorithm, Map<String, Object> parameters) {
        this.modelId = modelId;
        this.modelFileInfo = modelFileInfo;
        this.algorithm = algorithm;
        this.parameters = parameters;
    }

    public String getModelId() {
        return modelId;
    }

    public ModelFileInfo getModelFileInfo() {
        return modelFileInfo;
    }

    public String getAlgorithm() {
        return algorithm;
    }

    public Map<String, Object> getParameters() {
        return parameters;
    }
}
