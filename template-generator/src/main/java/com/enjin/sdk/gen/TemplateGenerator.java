package com.enjin.sdk.gen;

import io.freefair.gradle.codegenerator.api.Generator;
import io.freefair.gradle.codegenerator.api.ProjectContext;
import io.freefair.gradle.codegenerator.api.annotations.CodeGenerator;

@CodeGenerator
public class TemplateGenerator implements Generator {

    @Override
    public void generate(ProjectContext context) throws Exception {
        System.out.println("Hello World");
    }

}
