module features.java {
    exports com.fibanez.features.annotation;
    exports com.fibanez.features.generic;
    exports com.fibanez.features.lambda;
    exports com.fibanez.features.lambda.funtionalInterface;
    exports com.fibanez.features.reflection;
    exports com.fibanez.features.thread;
    exports com.fibanez.features.thread.exception;

    requires java.compiler;
    provides javax.annotation.processing.Processor with com.fibanez.features.annotation.VersionProcessor;
}