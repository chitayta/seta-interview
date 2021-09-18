package com.seta.interview.algorithm.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor(staticName = "of")
public class Note {
    Integer value;
    Integer quantity;

    @Override
    public String toString() {
        return "Currency{" +
                "value=" + value +
                ", quantity=" + quantity +
                '}';
    }
}
