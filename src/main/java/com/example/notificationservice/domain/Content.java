package com.example.notificationservice.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@EqualsAndHashCode
public class Content {

    private String emailTo;
    private String subject;
    private String content;
    private String pathToAttachment;

}
