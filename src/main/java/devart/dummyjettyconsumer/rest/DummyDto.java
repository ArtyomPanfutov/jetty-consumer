package devart.dummyjettyconsumer.rest;

import lombok.*;

import java.io.Serializable;

@Data
@Builder
@Getter
@AllArgsConstructor
@EqualsAndHashCode
public class DummyDto implements Serializable {
    private final String string1;
    private final String string2;
    private final String string3;
    private final String string4;
    private final String string5;
    private final String string6;
    private final String string7;
    private final String string8;
    private final String string9;
}
