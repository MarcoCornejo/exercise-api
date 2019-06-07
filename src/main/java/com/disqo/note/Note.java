package com.disqo.note;

import com.disqo.core.BaseEntity;
import com.disqo.user.User;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
public class Note extends BaseEntity {
    @NotBlank
    @Size(max = 50)
    private String title;

    @Size(max = 1000)
    private String note;

    @ManyToOne
    private User owner;

    protected Note(){
        super();
    }

    public Note(@NotBlank @Size(max = 50) String title, @Size(max = 1000) String note) {
        this();
        this.title = title;
        this.note = note;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
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
