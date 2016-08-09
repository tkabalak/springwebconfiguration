package com.exercises.spring.springproject04.config;

public enum Status {
    GIVEN(new Short("0"))
    ,RECEIVE(new Short("1"))
    ,DURING(new Short("2"))
    ,DONE(new Short("3"));

    private Short val;

    Status(Short val) {
        this.val = val;
    }

    public Short getVal() {
        return val;
    }

    public static boolean compare(Status status, short val) {
        return status.getVal() == val;
    }
}
