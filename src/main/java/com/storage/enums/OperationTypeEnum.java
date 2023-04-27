package com.storage.enums;

import java.util.Arrays;

public enum OperationTypeEnum {
    ADD(1), DISCARD(2);
    public int value;

    OperationTypeEnum(int value){
        this.value = value;
    }

    OperationTypeEnum(){}

    public int getValue() {
        return value;
    }

}
