package CustomAnnotation;

import java.time.LocalDateTime;
@JsonName(value = "person")
public class Person {
    private String name ;

    @JsonName("date_of_birth")
    private LocalDateTime dateOfBirth;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDateTime dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public static void main(String[] args) throws IllegalAccessException {
        Person person = new Person(); // Tao doi tuong super man
        person.setDateOfBirth(LocalDateTime.now());
        person.setName("loda");

        String json =JsonNameProcessor.toJson(person);
        System.out.println(json);
    }
// OUTPUT:
/*
{
	"super_man": {
		"name": "loda",
		"date_of_birth": "2019-04-03T21:07:23.983"
	}
}
*/
}
