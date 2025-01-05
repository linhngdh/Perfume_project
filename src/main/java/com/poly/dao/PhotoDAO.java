package com.poly.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.poly.entity.Photo;


public interface PhotoDAO extends JpaRepository<Photo, Integer>{


}
