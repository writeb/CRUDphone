package com.example.demo.api;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PaginationFilter {
    private int limit;
    private int offset;
}
