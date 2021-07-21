package com.muyi.manager.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
@AllArgsConstructor
public class Student {
    private String id;
    private String userName;
    private String souce;
}
