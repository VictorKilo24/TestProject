package com.insert.exceptions;

import org.springframework.dao.EmptyResultDataAccessException;

public class NonExistentIdValueException extends EmptyResultDataAccessException {

    public NonExistentIdValueException(int expectedSize) {
        super(expectedSize);
    }
}
