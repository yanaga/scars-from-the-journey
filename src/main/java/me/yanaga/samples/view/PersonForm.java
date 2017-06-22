package me.yanaga.samples.view;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Ops;
import com.querydsl.core.types.Predicate;
import com.querydsl.core.types.dsl.Expressions;
import me.yanaga.querydsl.args.core.single.SingleStringArgument;
import me.yanaga.samples.domain.model.QPerson;

import java.io.Serializable;

public class PersonForm implements Serializable {

    private SingleStringArgument name = SingleStringArgument.of();

    private SingleStringArgument surname = SingleStringArgument.of();

    private PersonForm() {
    }

    public static PersonForm of() {
        return new PersonForm();
    }

    public Predicate toPredicate() {
        BooleanBuilder builder = new BooleanBuilder();
        name.append(builder, QPerson.person.name.stringValue());
        surname.append(builder, QPerson.person.surname.stringValue());
        return builder;
    }

    public SingleStringArgument getName() {
        return name;
    }

    public void setName(SingleStringArgument name) {
        this.name = name;
    }

    public SingleStringArgument getSurname() {
        return surname;
    }

    public void setSurname(SingleStringArgument surname) {
        this.surname = surname;
    }
}
