package com.atmaram.cj.core;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedAnnotationTypes;
import javax.annotation.processing.SupportedSourceVersion;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.PackageElement;
import javax.lang.model.element.TypeElement;
import javax.lang.model.util.ElementFilter;
import javax.tools.JavaFileObject;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;
@SupportedAnnotationTypes("com.atmaram.cj.core.Command")
@SupportedSourceVersion(SourceVersion.RELEASE_7)
public class CommandAnnotationProcessor extends AbstractProcessor {
    @Override
    public boolean process(Set<? extends TypeElement> set, RoundEnvironment roundEnvironment) {
        var annotedElements=roundEnvironment.getElementsAnnotatedWith(Command.class);
        var annotedMethods=ElementFilter.methodsIn(annotedElements);
        String sPackage="com.atmaram.cj.core";
        List<String> commands=new ArrayList<>();
        for (var annotedMethod:annotedMethods
             ) {
            String name=annotedMethod.getAnnotation(Command.class).name();

            String add="commandRegistry.add(new CommandRegistryEntry(\""+name+"\",\""+((TypeElement)annotedMethod.getEnclosingElement()).getQualifiedName().toString()+"\",\""+annotedMethod.getSimpleName().toString()+"\"));";
            ((TypeElement)annotedMethod.getEnclosingElement()).getQualifiedName();
//            try {
//                sPackage = ((PackageElement) annotedMethod.getEnclosingElement().getEnclosingElement()).getQualifiedName().toString();
//            }catch (Exception ex){
//
//            }
            commands.add(add);
        }
        StringBuilder builder=new StringBuilder();
        builder
                .append("package "+sPackage+";")
                .append("import com.atmaram.cj.core.*;")
                .append("public class Main {")
                .append("public static CommandRegistry commandRegistry=new CommandRegistry();")
                .append("public static void main(String[] args){")
                .append(String.join(" ",commands))
                .append("Executor.runProgram(commandRegistry);")
                .append("}")
                .append("}");

        try{
            JavaFileObject javaFileObject=processingEnv.getFiler().createSourceFile(sPackage+".Main");
            Writer writer=javaFileObject.openWriter();
            writer.write(builder.toString());
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;

    }
}
