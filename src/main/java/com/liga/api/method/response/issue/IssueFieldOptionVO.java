package com.liga.api.method.response.issue;


public class IssueFieldOptionVO {

    /**
     * 选项值
     */
    private Object value;

    /**
     * 选项名称
     */
    private String name;

    private Object extendValue;

    private String icon;


    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Object getExtendValue() {
        return extendValue;
    }

    public void setExtendValue(Object extendValue) {
        this.extendValue = extendValue;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }
}
