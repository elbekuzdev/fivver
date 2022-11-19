package com.example.main.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResMessage {
    private int code;
    private String message;
    private Object object;



    public static ResMessage getSuccess(int i, String success) {
        return new ResMessage(i,success,null);
    }
    public static ResMessage getSuccess(Object object) {
        return new ResMessage(0,"success", object);
    }
}