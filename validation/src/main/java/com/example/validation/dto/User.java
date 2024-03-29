package com.example.validation.dto;

import com.example.validation.annootation.YearMonth;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.boot.autoconfigure.web.format.DateTimeFormatters;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.sql.DatabaseMetaData;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class User {
    @NotBlank
    private String name;
    @Max(value = 90)
    private int age;

    @Email
    private String email;
    @JsonProperty("phone_number")
    @Pattern(regexp = "^\\d{2,3}-\\d{3,4}-\\d{4}$", message = "핸드폰 번호의 양식과 맞지 않습니다. 01x-xxx(x)-xxxx")
    private String phoneNumber;

    @YearMonth
    @JsonProperty("req")
    private String reqYerMonth; //YYYYMM
    @Valid
    private List<Car> cars;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    public String getReqYerMonth() {
        return reqYerMonth;
    }

    public void setReqYerMonth(String reqYerMonth) {
        this.reqYerMonth = reqYerMonth;
    }

    public List<Car> getCars() {
        return cars;
    }

    public void setCars(List<Car> cars) {
        this.cars = cars;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", reqYerMonth='" + reqYerMonth + '\'' +
                ", cars=" + cars +
                '}';
    }
}
