package io.github.cocodx.first.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author amazfit
 * @date 2022-07-15 上午5:38
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    private String userName;
    private String password;
    private String email;
}
