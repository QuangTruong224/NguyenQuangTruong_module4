package com.codegym.repository;

import com.codegym.model.Music;

import java.util.List;

public interface MusicRepository {
    List<Music> findAll();

    void  save(Music music);

    Music findById(int id);

    void update( Music music);

    void remove(Music music);
}
