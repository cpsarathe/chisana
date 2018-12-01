package com.cp.chisana.utils;

public enum ResponseEnum {

    VALIDATION_FAILURE(422, "validation failure"),
    SUCCESS(200, "success"),
    INTERNAL_SERVER_ERROR(500, "internal server error") ,
    BAD_REQUEST_ERROR(400, "bad request"),
    FORBIDDEN(403,"forbidden"),
    NO_DATA_FOUND_ERROR(404,"no data found");
    Integer id;
    String name;

    private ResponseEnum(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "{\"id\":\"" + this.id + "\",\"name\":\"" + this.name + "\"}";
    }
}
