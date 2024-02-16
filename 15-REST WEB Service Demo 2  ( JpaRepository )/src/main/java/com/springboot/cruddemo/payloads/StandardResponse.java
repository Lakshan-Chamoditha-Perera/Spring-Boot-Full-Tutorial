package com.springboot.cruddemo.payloads;

import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class StandardResponse {
    private Object data;
    private Integer status;
    private Long timeStamp;
}
