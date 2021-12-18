package ru.netology.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;
import java.util.Collections;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Issue {
    private int id;
    private String title;
    private String author;
    private int date;
    private boolean open;
    private Set<String> label;
    private Set<String> assignee;


}
