package com.wzt.restfulapi.util;

import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;

import java.beans.FeatureDescriptor;
import java.util.stream.Stream;

public class Util {

    public static String[] getNullPropertyNames(Object source){
        final BeanWrapper wrapper = new BeanWrapperImpl(source);
        return Stream.of(wrapper.getPropertyDescriptors())
                .map(FeatureDescriptor::getName)
                .filter(property->wrapper.getPropertyValue(property) == null)
                .toArray(String[]::new);
    }
}
