package com.portfolio.cv.service;

import com.portfolio.cv.entity.Skill;
import com.portfolio.cv.repository.SkillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SkillService {
    @Autowired private SkillRepository repo;

    public List<Skill> listAll(){
        return (List<Skill>) repo.findAll();
    }
}
