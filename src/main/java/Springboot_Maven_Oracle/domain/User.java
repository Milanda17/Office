package Springboot_Maven_Oracle.domain;

import javax.persistence.*;
import javax.validation.constraints.*;


@Entity // This tells Hibernate to make a table out of this class
@Table(name = "user_table")
    public class User {

        @Id
        @GeneratedValue(strategy=GenerationType.AUTO)

        @Column(name = "user_id")
        private Integer id;

    @NotNull
    @Size(min=2, max=30)
    @Column(name = "first_name")
        private String firstname;

    @NotNull
    @Size(min=2, max=30)
    @Column(name = "last_name")
        private String lastname;
    @NotNull
    @Min(18)
    @Column(name = "age")
        private Integer age;


    @NotEmpty
    @Email
    @Column(name = "email")
        private String email;


        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getFirstname() {
            return firstname;
        }

        public void setFirstname(String firstname) {
            this.firstname = firstname;
        }

        public String getLastname() {
            return lastname;
        }

        public void setLastname(String lastname) {
            this.lastname = lastname;
        }

        public Integer getAge() {
            return age;
        }

        public void setAge(Integer age) {
            this.age = age;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }


    }
