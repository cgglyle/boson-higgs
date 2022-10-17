package io.github.cgglyle.boson.higgs.model;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author Lyle
 * @since 2022/10/11
 */
@Data
@AllArgsConstructor
public class Token {
    private String token;
    private double randomNumber;
    private long expirationTime;
}
