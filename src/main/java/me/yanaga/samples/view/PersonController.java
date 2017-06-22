package me.yanaga.samples.view;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Ops;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.core.types.dsl.Expressions;
import com.querydsl.jpa.impl.JPAQuery;
import me.yanaga.samples.domain.model.Person;
import me.yanaga.samples.domain.model.PersonRepository;
import me.yanaga.samples.domain.model.QPerson;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.io.Serializable;
import java.util.List;

@Named
@SessionScoped
public class PersonController implements Serializable {

    private PersonForm form = PersonForm.of();

    @PersistenceContext
    private EntityManager entityManager;

    public List<Person> findAll() {
        JPAQuery<Person> query = new JPAQuery<Person>(entityManager).from(QPerson.person);
        return query.where(form.toPredicate()).fetch();
    }

    public PersonForm getForm() {
        return form;
    }
}
