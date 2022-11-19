package com.khb.wicketturotial.lessonfour;

import java.io.Serializable;
import java.util.Objects;

public class PetVO implements Serializable {
    private static final long serialVersionUID = 6648533431531762884L;

    private String name;
    private String species;

    public PetVO() {
    }

    public PetVO(String name, String species) {
        this.name = name;
        this.species = species;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PetVO petVO = (PetVO) o;
        return Objects.equals(name, petVO.name) && Objects.equals(species, petVO.species);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, species);
    }

    @Override
    public String toString() {
        return "PetVO{" +
                "name='" + name + '\'' +
                ", species='" + species + '\'' +
                '}';
    }
}
