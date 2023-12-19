package com.example.RestfullAPI.Service;

import com.example.RestfullAPI.IDModel.TitleID;
import com.example.RestfullAPI.Model.Title;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TitleService extends JpaRepository<Title, TitleID> {
    Title findByid(TitleID id);
}
