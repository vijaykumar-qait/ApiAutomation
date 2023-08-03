package Core.Entities;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Param {
    private String key;
    private String value;

    public Param(String key, String value) {
        this.key = key;
        this.value = value;
    }
}
