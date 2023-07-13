package kits.edu.finalproject.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ResponeDTO<D> {
    private String message;
    private D data;
    private String error;
    private String error_code;
}
