package com.example.MyBookShopApp.repositories;

import com.example.MyBookShopApp.entities.TestEntity;
import com.example.MyBookShopApp.repositories.AbstractHibernateDao;
import org.springframework.stereotype.Repository;

@Repository
public class TestEntityDao extends AbstractHibernateDao<TestEntity> {
    public TestEntityDao(){
        super();
        setClazz(TestEntity.class);
    }
}
