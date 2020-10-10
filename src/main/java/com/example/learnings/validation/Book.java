package com.example.learnings.validation;

import javax.validation.constraints.*;
import java.util.Date;

/**
 * @author Antonio Goncalves
 *         http://www.antoniogoncalves.org
 *         --
 */
public class Book {

  // ======================================
  // =             Attributes             =
  // ======================================

  @Pattern(regexp = "^(97(8|9))?\\d{9}(\\d|X)$")
  private String isbn;
  @NotNull
  private String title;
  @NotNull
  @Min(2)
  private Float price;
  @Size(min = 10, max = 2000)
  private String description;
  private Integer nbOfPage;
  @Past
  private Date dateOfPublication;

  // ======================================
  // =            Constructors            =
  // ======================================

  public Book() {
  }

  public Book(String isbn, String title, Float price, String description, Integer nbOfPage, Date dateOfPublication) {
    this.title = title;
    this.price = price;
    this.description = description;
    this.isbn = isbn;
    this.nbOfPage = nbOfPage;
    this.dateOfPublication = dateOfPublication;
  }

  // ======================================
  // =          Getters & Setters         =
  // ======================================

  public String getIsbn() {
    return isbn;
  }

  public void setIsbn(String isbn) {
    this.isbn = isbn;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public Float getPrice() {
    return price;
  }

  public void setPrice(Float price) {
    this.price = price;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public Integer getNbOfPage() {
    return nbOfPage;
  }

  public void setNbOfPage(Integer nbOfPage) {
    this.nbOfPage = nbOfPage;
  }

  public Date getDateOfPublication() {
    return dateOfPublication;
  }

  public void setDateOfPublication(Date dateOfPublication) {
    this.dateOfPublication = dateOfPublication;
  }

// ======================================
  // =         hash, equals, toString     =
  // ======================================

  @Override
  public String toString() {
    final StringBuilder sb = new StringBuilder();
    sb.append("Book");
    sb.append(", title='").append(title).append('\'');
    sb.append(", price=").append(price);
    sb.append(", description='").append(description).append('\'');
    sb.append(", isbn='").append(isbn).append('\'');
    sb.append(", nbOfPage=").append(nbOfPage);
    sb.append(", dateOfPublication=").append(dateOfPublication);
    sb.append('}');
    return sb.toString();
  }
}