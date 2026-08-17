package annotations;

import java.lang.reflect.Field;
import java.util.Optional;

/**
 * Processes @JsonNameAnnotation at runtime using reflection to serialize
 * any object into a JSON string.
 *
 * Key concepts:
 *   - Reflection allows inspecting class structure (fields, methods, annotations)
 *     at runtime without knowing the type at compile time.
 *   - field.setAccessible(true) bypasses Java's access control, allowing
 *     reflection to read private fields.
 *   - getDeclaredAnnotation() retrieves an annotation by type on a specific element.
 *   - Optional.ofNullable(...).map(...).orElse(...) handles the fallback when
 *     an annotation is absent — use the field/class name as default.
 *
 * This is the basis of how serialization libraries (Jackson, Gson) work internally.
 */
public class JsonNameProcessor {

    /**
     * Serializes an object to a JSON string using @JsonNameAnnotation for key names.
     * Falls back to the class/field name when the annotation is absent.
     *
     * @param object the object to serialize
     * @return a JSON string representation
     * @throws IllegalAccessException if field access fails (should not happen with setAccessible)
     */
    public static String toJson(Object object) throws IllegalAccessException {
        StringBuilder sb = new StringBuilder();

        Class<?> clazz = object.getClass();

        // Check if the class itself has @JsonNameAnnotation
        JsonNameAnnotation jsonClassName = clazz.getDeclaredAnnotation(JsonNameAnnotation.class);

        sb.append("{\n")
          .append("\t\"")
          // Use annotation value if present, otherwise fall back to simple class name
          .append(Optional.ofNullable(jsonClassName)
                  .map(JsonNameAnnotation::value)
                  .orElse(clazz.getSimpleName()))
          .append("\": {\n");

        Field[] fields = clazz.getDeclaredFields();
        for (int i = 0; i < fields.length; i++) {
            // Allow reflection to access private fields
            fields[i].setAccessible(true);

            JsonNameAnnotation jsonFieldName = fields[i].getDeclaredAnnotation(JsonNameAnnotation.class);

            sb.append("\t\t\"")
              // Use annotation value if present, otherwise fall back to field name
              .append(Optional.ofNullable(jsonFieldName)
                      .map(JsonNameAnnotation::value)
                      .orElse(fields[i].getName()))
              .append("\": ")
              // Wrap String and non-primitive types in quotes
              .append(isQuoted(fields[i]) ? "\"" : "")
              .append(fields[i].get(object))
              .append(isQuoted(fields[i]) ? "\"" : "")
              // No trailing comma after the last field
              .append(i != fields.length - 1 ? ",\n" : "\n");
        }

        sb.append("\t}\n").append("}");
        return sb.toString();
    }

    /** Returns true if the field value should be wrapped in JSON quotes. */
    private static boolean isQuoted(Field field) {
        return field.getType() == String.class || !field.getType().isPrimitive();
    }
}
