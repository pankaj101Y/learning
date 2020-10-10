package com.example.learnings.validation.demo;



import com.example.learnings.validation.Book;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;

import static com.example.learnings.validation.Util.date;


public class Validation {

  public static void main(String[] args) {

    System.out.println("\n\n>>> Executing : " + Validation.class.toString() + " <<<\n");

    ValidatorFactory vf = javax.validation.Validation.buildDefaultValidatorFactory();
    Validator validator = vf.getValidator();
    Set<ConstraintViolation<Book>> violations;

    Book book = new Book("9781234567890", "H2G2", 12.5f, "Best IT Scifi Book", 247, date("01/01/2010"));

    violations = validator.validate(book);

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
