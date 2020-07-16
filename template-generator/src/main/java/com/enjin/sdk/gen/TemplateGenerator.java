package com.enjin.sdk.gen;

import com.squareup.javapoet.FieldSpec;
import com.squareup.javapoet.JavaFile;
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

        for (Map.Entry<String, Template> entry : templateLoader.getOperations().entrySet()) {
            String fieldName = entry.getKey()
                                    .replace("Mutation", "")
                                    .replace("Query", "");
            String fieldValue = entry.getValue().compile().replace("\n", " ");
            FieldSpec spec = FieldSpec.builder(String.class,
                                               fieldName,
                                               Modifier.STATIC,
                                               Modifier.FINAL,
                                               Modifier.PUBLIC)
                                      .initializer("$S", fieldValue)
                                      .build();
            typeSpec.addField(spec);

            File dir = new File(context.getOutputDir(), "../../../gql/compiled-templates/");
            dir.mkdirs();
            File file = new File(dir, fieldName + ".gql");
            file.delete();
            file.createNewFile();
            try (FileWriter fw = new FileWriter(file)){
                try (BufferedWriter bw = new BufferedWriter(fw)) {
                    bw.write(entry.getValue().compile());
                }
            }
        }

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
