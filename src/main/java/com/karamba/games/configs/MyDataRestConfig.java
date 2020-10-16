package com.karamba.games.configs;

import com.karamba.games.entities.Product;
import com.karamba.games.entities.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.http.HttpMethod;

import javax.persistence.EntityManager;
import javax.persistence.metamodel.EntityType;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Configuration
public class MyDataRestConfig implements RepositoryRestConfigurer {

    private EntityManager entityManager;

    @Autowired
    public MyDataRestConfig(EntityManager theEntityManager) { entityManager = theEntityManager;}

    @Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config){
        HttpMethod[] unsupportedActions = {HttpMethod.DELETE};

        //Disable HTTP methods for Product: DELETE
        disableHttpMethods(Product.class, config, unsupportedActions);

        //Disable HTTP methods for Category: PUT, POST, DELETE
        disableHttpMethods(Category.class, config, unsupportedActions);

        //call helper method to expose entities ids
        exposeIds(config);
    }

    private void disableHttpMethods(Class theClass, RepositoryRestConfiguration config, HttpMethod[] unsupportedActions){
        config.getExposureConfiguration()
                .forDomainType(theClass)
                .withItemExposure((metdata, httpMethods) -> httpMethods.disable(unsupportedActions))
                .withCollectionExposure((metdata, httpMethods) -> httpMethods.disable(unsupportedActions));
    }

    private void exposeIds(RepositoryRestConfiguration config){
        //expose ids
        Set<EntityType<?>> entities = entityManager.getMetamodel().getEntities();

        List<Class> entityClasses = new ArrayList<>();

        for(EntityType tempEntityType: entities){
            entityClasses.add(tempEntityType.getJavaType());
        }

        Class[] domainTypes = entityClasses.toArray(new Class[0]);
        config.exposeIdsFor(domainTypes);

    }



}
