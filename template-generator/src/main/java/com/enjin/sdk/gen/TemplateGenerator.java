package com.enjin.sdk.gen;

import com.squareup.javapoet.CodeBlock;
import com.squareup.javapoet.FieldSpec;
import com.squareup.javapoet.JavaFile;
import com.squareup.javapoet.ParameterizedTypeName;
import com.squareup.javapoet.TypeSpec;
import io.freefair.gradle.codegenerator.api.Generator;
import io.freefair.gradle.codegenerator.api.ProjectContext;
import io.freefair.gradle.codegenerator.api.annotations.CodeGenerator;
import lombok.SneakyThrows;

import javax.lang.model.element.Modifier;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@CodeGenerator
public class TemplateGenerator implements Generator {

    @Override
    public void generate(ProjectContext context) throws Exception {
        File resourcesDir = new File(context.getRootDir(), "src/main/resources");
        TemplateLoader templateLoader = new TemplateLoader(resourcesDir);

        templateLoader.load();

        generateTemplateClass(context, templateLoader);
    }

    @SneakyThrows
    private void generateTemplateClass(ProjectContext context, TemplateLoader templateLoader) {
        TypeSpec.Builder typeSpec = TypeSpec.classBuilder("TemplateConstants")
                                            .addModifiers(Modifier.PUBLIC, Modifier.FINAL);

        ParameterizedTypeName typeName = ParameterizedTypeName.get(Map.class, String.class, String.class);
        typeSpec.addField(FieldSpec.builder(typeName,
                                            "TEMPLATES",
                                            Modifier.PUBLIC,
                                            Modifier.STATIC,
                                            Modifier.FINAL)
                                   .build());

        // Builds the statements used to put the template namespace and compiled contents into the templates map
        CodeBlock.Builder staticBlockBuilder = CodeBlock.builder()
                                                        .addStatement("$T<$T, $T> map = new $T<>()",
                                                                      Map.class,
                                                                      String.class,
                                                                      String.class,
                                                                      HashMap.class);

        for (Template template : templateLoader.getOperations().values()) {
            String key   = template.getNamespace();
            String value = template.compile().replace("\n", " ");
            staticBlockBuilder.addStatement("$L.put($S, $S)", "map", key, value);

            File dir = new File(context.getOutputDir(), "../../../gql/compiled-templates/");
            dir.mkdirs();
            File file = new File(dir, template.getName() + ".gql");
            file.delete();
            file.createNewFile();
            try (FileWriter fw = new FileWriter(file)){
                try (BufferedWriter bw = new BufferedWriter(fw)) {
                    bw.write(template.compile());
                }
            }
        }

        typeSpec.addStaticBlock(staticBlockBuilder.addStatement("$L = $T.unmodifiableMap($L)",
                                                                "TEMPLATES",
                                                                Collections.class,
                                                                "map")
                                                  .build());

        JavaFile javaFile = JavaFile.builder("com.enjin.sdk.graphql", typeSpec.build())
                                    .indent("    ")
                                    .build();

        try {
            javaFile.writeTo(context.getOutputDir());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
