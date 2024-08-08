package service;

import persistence.TypeAnimalDAO_JDBC;

import java.lang.reflect.Type;

public class AnimalService {
    protected TypeAnimalDAO_JDBC typeAnimalDAO;

    public AnimalService(TypeAnimalDAO_JDBC typeAnimalDAO) {
        this.typeAnimalDAO = typeAnimalDAO;
    }

    public TypeAnimalDAO_JDBC getPrixTypeAnimalById() {
        return typeAnimalDAO;
    }
}
