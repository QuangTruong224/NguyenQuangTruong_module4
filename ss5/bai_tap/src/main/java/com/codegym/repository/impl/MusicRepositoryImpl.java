package com.codegym.repository.impl;

import com.codegym.model.Music;
import com.codegym.repository.BaseRepository;
import com.codegym.repository.MusicRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.List;
@Repository
public class MusicRepositoryImpl implements MusicRepository{
    @Override
    public List<Music> findAll() {
        TypedQuery<Music> musicTypedQuery = BaseRepository.entityManager.createQuery("select s from Music s", Music.class);
        return musicTypedQuery.getResultList();
    }

    @Override
    public void save(Music music) {
        EntityTransaction entityTransaction = BaseRepository.entityManager.getTransaction();

        entityTransaction.begin();
        BaseRepository.entityManager.persist(music);
        entityTransaction.commit();
    }


    @Override
    public Music findById(int id) {
        return BaseRepository.entityManager.find(Music.class,id);
    }


    @Override
    public void update( Music music) {
        EntityTransaction entityTransaction = BaseRepository.entityManager.getTransaction();

        entityTransaction.begin();
        BaseRepository.entityManager.merge(music);
        entityTransaction.commit();
    }

    @Override
    public void remove(Music music) {
        EntityTransaction entityTransaction = BaseRepository.entityManager.getTransaction();
        entityTransaction.begin();
        BaseRepository.entityManager.remove(music);
        entityTransaction.commit();
    }
}
