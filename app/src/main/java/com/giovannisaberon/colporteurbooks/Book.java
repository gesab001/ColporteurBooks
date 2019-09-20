package com.giovannisaberon.colporteurbooks;

    import java.io.Serializable;

public class Book implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    private String name;

    private String  bookCode;

    private boolean isSelected;

    public Book() {

    }

    public Book(String name, String  bookCode) {

        this.name = name;
        this. bookCode =  bookCode;

    }

    public Book(String name, String  bookCode, boolean isSelected) {

        this.name = name;
        this. bookCode =  bookCode;
        this.isSelected = isSelected;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmailId() {
        return  bookCode;
    }

    public void setEmailId(String  bookCode) {
        this. bookCode =  bookCode;
    }

    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean isSelected) {
        this.isSelected = isSelected;
    }

}

