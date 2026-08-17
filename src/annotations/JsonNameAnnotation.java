package annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Custom annotation that maps a Java class or field to a JSON key name.
 *
 * Key concepts:
 *   - @interface declares a custom annotation type.
 *   - @Retention(RUNTIME) means the annotation is preserved in the bytecode
 *     and available via reflection at runtime. Without this, the annotation
 *     would be discarded after compilation.
 *   - @Target restricts where this annotation can be placed:
 *       TYPE    → on class/interface/enum declarations
 *       FIELD   → on field declarations
 *       METHOD  → on method declarations
 *   - value() is the single element — callers write @JsonName("myName").
 *     No default is provided, so callers MUST supply a value.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.FIELD, ElementType.METHOD})
public @interface JsonNameAnnotation {
    String value();
}
