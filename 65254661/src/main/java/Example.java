import io.vavr.Tuple;
import io.vavr.Tuple2;
import io.vavr.match.annotation.Patterns;
import io.vavr.match.annotation.Unapply;
import lombok.AllArgsConstructor;
import lombok.Getter;

import static io.vavr.API.*;

public class Example {

    public static void main(String[] args) {
        Employee person = new Employee("Carl", "89696D8");

        String result = Match(person).of(
            Case(Example_DemoPatterns.$Employee($("Carl"), $()), (name, id) -> name + " " + id),
            Case($(), () -> "notfound")
        );
        System.out.println(result);
    }

    @Getter
    @AllArgsConstructor
    public static class Employee {
        private String name;
        private String id;
    }

    @Patterns
    public static class Demo {
        @Unapply
        static Tuple2<String, String> Employee(Employee Employee) {
            return Tuple.of(Employee.getName(), Employee.getId());
        }
    }
}
