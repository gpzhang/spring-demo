package com.demo.spring.bean;

/**
 * @author haishen
 * @date 2018/6/17
 * <p>
 * 自定义标签管理bean
 */
public class People {

    private String id;
    private String name;
    private Integer age;

    public People() {
        System.out.println("实例化People");
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "id:" + this.getId() + ",name:" + this.getName();
    }
}
