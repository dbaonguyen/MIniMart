package utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class MinDateValidator implements ConstraintValidator<MinDate, Date> {

    private Date minValue;

    @Override
    public void initialize(MinDate annotation) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            this.minValue = dateFormat.parse(annotation.value());
        } catch (ParseException e) {
            throw new IllegalArgumentException("Invalid date format for MinDate validator", e);
        }
    }

    @Override
    public boolean isValid(Date value, ConstraintValidatorContext context) {
        if (value == null) {
            return true;
        }
        return value.compareTo(this.minValue) >= 0;
    }
}

