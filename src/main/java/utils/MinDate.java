package utils;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = MinDateValidator.class)
@Documented
public @interface MinDate {

    String message() default "Ngày tạo phải lớn hơn 1930-01-01";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    String value() default "1930-01-01";
}
