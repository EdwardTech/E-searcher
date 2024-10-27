package com.edtech.wsearcherapi.utils;

import com.edtech.wsearcherapi.model.dto.RequestProfile;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;

import java.beans.PropertyDescriptor;
import java.util.HashSet;
import java.util.Set;

public class ProfileUtils {

    public static String[] getNullPropertyNames(RequestProfile profile) {
        final BeanWrapper source = new BeanWrapperImpl(profile);
        PropertyDescriptor[] pds = source.getPropertyDescriptors();
        Set<String> emptyNames = new HashSet<>();

        for (PropertyDescriptor pd  : pds) {
            Object propertyValue = source.getPropertyValue(pd.getName());
            if (propertyValue == null) {
                emptyNames.add(pd.getName());
            }
        }

        String[] result = new String[emptyNames.size()];
        return emptyNames.toArray(result);
    }
}
