package org.rosemwal.java.interview.serdeserialize;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;

import java.io.Serializable;

@Builder
@Getter
@Data
public class Person implements Serializable {

    String name;
    String religion;
}
