package com.khb.wicketturotial.lessonfive;

import java.io.Serializable;
import java.util.Objects;

public class NameVO implements Serializable {
    private static final long serialVersionUID = -2181202680075215289L;

    private String title;
    private String firstName;
    private String lastName;

    public NameVO() {
    }

    public NameVO(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public NameVO(String title, String firstName, String lastName) {
        this.title = title;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NameVO nameVO = (NameVO) o;
        return Objects.equals(title, nameVO.title) && Objects.equals(firstName, nameVO.firstName) && Objects.equals(lastName, nameVO.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, firstName, lastName);
    }

    @Override
    public String toString() {
        return "NameVO{" +
                "title='" + title + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
