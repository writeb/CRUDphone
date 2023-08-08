package com.example.demo.changelogs;

import com.example.demo.modelSecond.Employee;
import io.mongock.api.annotations.ChangeUnit;
import io.mongock.api.annotations.Execution;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import java.time.LocalDate;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import static org.springframework.data.mongodb.core.query.Criteria.where;

@ChangeUnit(id = "setField", order = "1", author = "rauan")
public class Create {

    Logger logger = LoggerFactory.getLogger(Create.class);
    AtomicInteger successfulUserUpdatesCounter = new AtomicInteger();

    @Execution
    public void setFields(MongoTemplate mongoTemplate) {
        Query query = new Query(
                where("full_name").ne(null)
                        .andOperator(where("id").is(null),
                                where("birth_year").is(null),
                                where("created_at").is(null),
                                where("email").is(null),
                                where("first_phone").is(null),
                                where("password").is(null),
                                where("second_phone").is(null))
        );

        query.fields().include("_id", "full_name");

        long usersWithoutFields = mongoTemplate.count(query, Employee.class);
        query.limit(100);

        List<Employee> employees = mongoTemplate.find(query, Employee.class);
        while (employees != null && !employees.isEmpty()) {
            employees.forEach(employee -> {
                try {
                    Criteria criteria = where("_id").is(employee.getId());
                    setValuesForEmployee(employee);
                    Update update = new Update()
                            .set("id", employee.getId())
                            .set("birth_year", employee.getBirthYear())
                            .set("created_at", employee.getCreatedAt())
                            .set("email", employee.getEmail())
                            .set("first_phone", employee.getFirstPhone())
                            .set("password", employee.getPassword())
                            .set("second_phone", employee.getSecondPhone());
                    mongoTemplate.findAndModify(new Query(criteria), update, Employee.class);
                    successfulUserUpdatesCounter.getAndIncrement();
                } catch (Exception ex) {
                    logger.error(String.format("Failed to set fields for employee with ID: %s", employee.getId()), ex);
                }
            });

            employees = mongoTemplate.find(query, Employee.class);
        }

        logger.info("Fields set for {} employees out of {} total.", successfulUserUpdatesCounter, usersWithoutFields);
    }

    private void setValuesForEmployee(Employee employee) {
        employee.setId("employee_id_" + successfulUserUpdatesCounter.get());
        employee.setBirthYear(LocalDate.of(1990, 1, 1));
        employee.setCreatedAt(LocalDate.now());
        employee.setEmail("employee" + successfulUserUpdatesCounter.get() + "@example.com");
        employee.setFirstPhone("123-456-7890");
        employee.setPassword("qweqwe");
        employee.setSecondPhone("987-654-3210");
    }

}
