package org.example.repository;

import org.example.repository.entity.ResultEntity;

public interface RepoInterf {
    Double saveResult(ResultEntity entity);
    ResultEntity getResultById(Integer id);
}
