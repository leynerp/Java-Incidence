package init.incidence.comun.validation;

import init.incidence.comun.validation.annotation.CondicionalField;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanWrapperImpl;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Arrays;

@Slf4j
public class ConditionalFieldValidation implements ConstraintValidator<CondicionalField, Object> {

    private String selected;
    private String[] required;
    private String message;
    private String[] values;

    @Override
    public void initialize(CondicionalField requiredIfChecked) {
        selected = requiredIfChecked.selected();
        required = requiredIfChecked.required();
        message = requiredIfChecked.message();
        values = requiredIfChecked.values();
    }

    @Override
    public boolean isValid(Object objectToValidate, ConstraintValidatorContext context) {
        Boolean valid = true;
            Object actualValue = new BeanWrapperImpl(objectToValidate).getPropertyValue(selected);
            if (Arrays.asList(values).contains(actualValue)) {
                for (String propName : required) {
                    Object requiredValue = new BeanWrapperImpl(objectToValidate).getPropertyValue(propName);
                    valid = requiredValue != null && requiredValue != "";
                    System.out.println("value: " + "" + requiredValue);
                    if (!valid) {
                        context.disableDefaultConstraintViolation();
                        context.buildConstraintViolationWithTemplate(message).addPropertyNode(propName).addConstraintViolation();
                    }
                }
            }
        return valid;
    }
}

