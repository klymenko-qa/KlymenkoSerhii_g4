package api.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

@JsonIgnoreProperties(ignoreUnknown = true)
@Getter
@Setter
@ToString
@Accessors(chain = true)
public class Human {

    @JsonProperty("name")
    public String name;

    @JsonProperty("height")
    public String height;

    @JsonProperty("mass")
    public String mass;

    @JsonProperty("hair_color")
    public String hair_color;

    @JsonProperty("eye_color")
    public String eye_color;

    public String birth_year;

    @JsonProperty("gender")
    public String gender;
}