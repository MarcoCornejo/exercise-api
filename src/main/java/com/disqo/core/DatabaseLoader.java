package com.disqo.core;

import com.disqo.note.Note;
import com.disqo.note.NoteRepository;
import com.disqo.user.User;
import com.disqo.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

@Component
public class DatabaseLoader implements ApplicationRunner {
    private final UserRepository users;
    private final NoteRepository notes;

    @Autowired
    public DatabaseLoader(UserRepository users, NoteRepository notes){
        this.users = users;
        this.notes = notes;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        List<User> accounts = Arrays.asList(
                new User("alejandroc_89@hotmail.com", "password", new String[]{"ROLE_USER"}),
                new User("test@hotmail.com", "password", new String[]{"ROLE_USER"}),
                new User("testEmail@hotmail.com", "password", new String[]{"ROLE_USER"})
        );
        users.saveAll(accounts);

        String[] templates = {
                "This is the first note",
                "Don't forget to read the first note!",
                "Remember to perform a checklist",
                "I hope this test works",
                "Seriously... this better work.",
                "I mean it should work... right? This entire loading should work... Why wouldn't it??... Please do"
        };
        String[] titles = {
                "VERY IMPORTANT",
                "Hope",
                "Remember this",
                "REMEMBER",
                "To Do"
        };

        List<Note> lotsOfNotes = new ArrayList<>();
        IntStream.range(0,25)
                .forEach(i -> {
                    String template = templates[i % templates.length];
                    String title = titles[i % titles.length];
                    Note note = new Note(title, template);
                    note.setOwner(accounts.get(i % accounts.size()));
                    lotsOfNotes.add(note);
                });
        notes.saveAll(lotsOfNotes);
    }
}
