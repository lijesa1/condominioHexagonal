package com.codigo.mssalazaramoroto.domain.aggregates.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class BaseResponse<T> {
    private Integer code;
    private String message;
    private T entidad;
}
