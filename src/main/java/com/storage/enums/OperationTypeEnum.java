package com.storage.enums;

public enum OperationTypeEnum {
    ADD(1), DISCARD(2);
    public int value;

    private OperationTypeEnum(int value){
        this.value = value;
    }
}
