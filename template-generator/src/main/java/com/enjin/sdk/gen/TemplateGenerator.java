package com.enjin.sdk.gen;

import com.squareup.javapoet.JavaFile;
import com.squareup.javapoet.TypeSpec;
import io.freefair.gradle.codegenerator.api.Generator;
import io.freefair.gradle.codegenerator.api.ProjectContext;
import io.freefair.gradle.codegenerator.api.annotations.CodeGenerator;

import javax.lang.model.element.Modifier;
import java.io.IOException;

@CodeGenerator
public class TemplateGenerator implements Generator {

    @Override
    public void generate(ProjectContext context) throws Exception {
        System.out.println("Compiling Templates");
        generateTemplateClass(context);
    }

    private void generateTemplateClass(ProjectContext context) {
        TypeSpec typeSpec = TypeSpec.classBuilder("TemplateConstants")
                                    .addModifiers(Modifier.PUBLIC, Modifier.FINAL)
                                    .build();
        JavaFile javaFile = JavaFile.builder("com.enjin.sdk.graphql", typeSpec)
                                    .build();

        try {
            javaFile.writeTo(context.getOutputDir());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
