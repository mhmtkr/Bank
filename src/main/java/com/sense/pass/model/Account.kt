package com.sense.pass.model

import org.hibernate.annotations.GenericGenerator
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity //Defines that a class can be mapped to a table
data class Account(

        @Id //Specifies the primary key of the entity
        @GeneratedValue(generator = "UUID") //Specifies the primary key generation strategy, which is "UUID" here
        @GenericGenerator(name = "UUID", strategy = org.hibernate.id.UUIDGenerator)


)
