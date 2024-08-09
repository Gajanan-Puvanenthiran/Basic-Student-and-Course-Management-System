package com.gajanan.Management.Sysytem.Util;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StandardResponse {

    private String message;

    private int code;

    private Object data;
}
