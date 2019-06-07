package com.disqo.note;

import com.disqo.core.BaseEntity;

import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
public class Note extends BaseEntity {
    @NotBlank
    @Size(max = 50)
    private String title;

    @Size(max = 1000)
    private String note;

    protected Note(){
        super();
    }

    public Note(@NotBlank @Size(max = 50) String title, @Size(max = 1000) String note) {
        this();
        this.title = title;
        this.note = note;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
