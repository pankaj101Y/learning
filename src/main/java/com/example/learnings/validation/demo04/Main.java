package com.example.learnings.validation.demo04;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;


public class Main {

  public static void main(String[] args) {

    System.out.println("\n\n>>> Executing : " + Main.class.toString() + " <<<\n");

    ValidatorFactory vf = Validation.buildDefaultValidatorFactory();
    Validator validator = vf.getValidator();
    Set<ConstraintViolation<ServerConnection>> violations;

    ServerConnection connection = new ServerConnection("https://www.cdbookstore.com/book/123",
            "https://www.cdbookstore.com:443/book/1234",
            "ftp://ftp.cdbookstore.com:21");

    violations = validator.validate(connection);

    if (violations.size() > 0) {
      for (ConstraintViolation violation : violations) {
        System.out.println("### " + violation.getRootBeanClass().getSimpleName() +
                "." + violation.getPropertyPath() +
                " - Invalid Value = " + violation.getInvalidValue() +
                " - Error Msg = " + violation.getMessage());

      }
    }
  }
}
