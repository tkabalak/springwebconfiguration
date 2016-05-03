package com.exercises.spring.springproject04.config;

public enum Status {
    GIVEN(0),
    RECEIVE(1);

    private int val;

    Status(int val) {
        this.val = val;
    }

    public int getVal() {
        return val;
    }

    public static boolean compare(Status status, int val) {
        return status.getVal() == val;
    }
}
