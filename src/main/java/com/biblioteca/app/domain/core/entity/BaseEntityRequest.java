package com.biblioteca.app.domain.core.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BaseEntityRequest {
    private String id;

    public static BaseEntityRequest of(String id) {
        return new BaseEntityRequest(id);
    }
}
