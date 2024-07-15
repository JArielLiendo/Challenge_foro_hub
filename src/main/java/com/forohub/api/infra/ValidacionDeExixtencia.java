package com.forohub.api.infra;

public class ValidacionDeExixtencia extends RuntimeException {
    public ValidacionDeExixtencia(String s) {
        super(s);
    }
}
