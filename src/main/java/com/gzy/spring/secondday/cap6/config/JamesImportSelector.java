package com.gzy.spring.secondday.cap6.config;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

public class JamesImportSelector implements ImportSelector {
    @Override
    public String[] selectImports(AnnotationMetadata annotationMetadata) {
        return new String[]{"com.gzy.spring.secondday.cap6.bean.Fish","com.gzy.spring.secondday.cap6.bean.Tiger"};
    }
}
