package com.lzdd.domain;

import java.util.List;

/**
 * @author Created by fei.tang@hand-china.com on 2018/1/31.
 * @description 内容交易平台
 */
public class StepMon {


    private Long stepNum;

    private String title;

    private List<FieldMon> fields;

    public Long getStepNum() {
        return stepNum;
    }

    public void setStepNum(Long stepNum) {
        this.stepNum = stepNum;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<FieldMon> getFields() {
        return fields;
    }

    public void setFields(List<FieldMon> fields) {
        this.fields = fields;
    }


    public StepMon() {
    }

    @Override
    public String toString() {
        return "StepMon{" +
                "stepNum='" + stepNum + '\'' +
                ", title='" + title + '\'' +
                ", fields=" + fields +
                '}';
    }
}
