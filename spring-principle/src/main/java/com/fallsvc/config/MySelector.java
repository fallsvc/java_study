package com.fallsvc.config;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @auther falls_vc
 * description:
 * @date 2025/4/19  14:38
 */
public class MySelector implements ImportSelector {

    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        return new String[]{"com.fallsvc.config.Config","com.fallsvc.config.Config2"};
    }
}
