package com.jovine.nafa.entity.Pojo;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
@Data
public class GroupRequest {
    private String groupLetter;
    private String state;
    private List<String> teamName;
}
