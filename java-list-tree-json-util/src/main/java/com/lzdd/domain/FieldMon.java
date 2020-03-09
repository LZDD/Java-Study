package com.lzdd.domain;

/**
 * @author Created by fei.tang@hand-china.com on 2018/1/31.
 * @description 内容交易平台
 */
public class FieldMon {

    private Long seqNum;

    private String fieldType;

    private String fieldName;

    private Object value;

    public FieldMon() {
        super();
    }


    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Long getSeqNum() {
        return seqNum;
    }

    public void setSeqNum(Long seqNum) {
        this.seqNum = seqNum;
    }

    public String getFieldType() {
        return fieldType;
    }

    public void setFieldType(String fieldType) {
        this.fieldType = fieldType;
    }

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    @Override
    public String toString() {
        return "FieldMon{" +
                "seqNum=" + seqNum +
                ", fieldType='" + fieldType + '\'' +
                ", fieldName='" + fieldName + '\'' +
                ", value='" + value + '\'' +
                '}';
    }
}
