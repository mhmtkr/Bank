package com.sense.pass.dto;

import com.sense.pass.model.Customer;
import org.springframework.stereotype.Component;

@Component
public class CustomerDtoConverter {

    public AccountCustomerDto convertToAccountCustomer(Customer from){
        if(from == null){
            return new AccountCustomerDto(id:"", name:"",surname:"");
        }else
        return new AccountCustomerDto(from.getId(), from.getName(), from.getSurname());
    }

}
