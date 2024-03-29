package com.package1.MiniProject.config;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.boot.actuate.endpoint.annotation.Selector;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Component
@Endpoint(id = "features")
public class FeatureEndPoint {
    private final Map<String, Feature> featureMap=new ConcurrentHashMap<>();

    public FeatureEndPoint(){
        featureMap.put("Department", new Feature(true));
        featureMap.put("User", new Feature(false));
        featureMap.put("Authentication", new Feature(false));
    }

    //EndPoints
    @ReadOperation
    public Map<String, Feature> features(){
        return featureMap;
    }
    @ReadOperation
    public Feature feature(@Selector String featureName){
        return  featureMap.get(featureName);
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    private class Feature {

        private boolean isEnabled;
    }
}
