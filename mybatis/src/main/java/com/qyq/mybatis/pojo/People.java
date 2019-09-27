package com.qyq.mybatis.pojo;

public class People {

    private Integer id;

    private String name;

    private String sex;

    private String idress;

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

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getIdress() {
        return idress;
    }

    public void setIdress(String idress) {
        this.idress = idress;
    }

    @Override
    public String toString() {
        return "People{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", idress='" + idress + '\'' +
                '}';
    }
}
