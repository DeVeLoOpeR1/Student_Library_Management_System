package com.example.demo.RequestDto;
//we do it just to take custom data input from the user
public class UpdateNameStudentDto {
    private int id;
    private String name;

    public UpdateNameStudentDto() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
