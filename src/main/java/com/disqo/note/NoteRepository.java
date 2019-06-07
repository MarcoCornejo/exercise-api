package com.disqo.note;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.security.access.prepost.PreAuthorize;

public interface NoteRepository extends CrudRepository<Note, Long> {
    @Override
    @PreAuthorize("@NoteRepository.findOne(#id)?.owner?.email == authentication.name")
    void deleteById(@Param("id") Long id);

    @Override
    @PreAuthorize("#note.owner?.email == authentication.name")
    void delete(@Param("note") Note entity);
}
