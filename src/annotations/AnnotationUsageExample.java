package annotations;

import java.time.LocalDateTime;

/**
 * Demonstrates using a custom annotation and processing it via reflection.
 *
 * Key concepts:
 *   - @JsonNameAnnotation on the class renames the root JSON key.
 *   - @JsonNameAnnotation on a field renames that specific JSON key.
 *   - Fields without the annotation keep their Java field name as the JSON key.
 *   - JsonNameProcessor inspects these annotations at runtime and builds the JSON.
 *
 * Expected output:
 *   {
 *       "person": {
 *           "name": "Tony Stark",
 *           "date_of_birth": "2000-01-01T00:00"
 *       }
 *   }
 */
@JsonNameAnnotation("person")
public class AnnotationUsageExample {

    // No annotation → field name "name" is used as-is in JSON
    private String name;

    // Annotation → JSON key will be "date_of_birth" instead of "dateOfBirth"
    @JsonNameAnnotation("date_of_birth")
    private LocalDateTime dateOfBirth;

    public AnnotationUsageExample(String name, LocalDateTime dateOfBirth) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
    }

    public static void main(String[] args) throws IllegalAccessException {
        AnnotationUsageExample person = new AnnotationUsageExample(
                "Tony Stark",
                LocalDateTime.of(2000, 1, 1, 0, 0)
        );

        String json = JsonNameProcessor.toJson(person);
        System.out.println(json);
    }
}
