package bo.edu.uagrm.soe.practica2.ds;

import lombok.AllArgsConstructor;
import lombok.Data;
import javax.persistence.Entity;
import javax.persistence.Id;

//import javax.persistence.Entity;
//import javax.persistence.Id;

//@Entity
//@Data
//@AllArgsConstructor
//public class Customer {
//    @Id
//    @GeneratedValue(strategy = IDENTITY)
//    private Integer id;
//    @NotBlank
//    @Size(min = 2, max = 5, message = "Code must have length of 2 - 5 characters")
//    @Pattern(regexp = "[A-Za-z]*", message = "Code contains illegal characters")
//    private String code;
//    @NotBlank(message = "First name cannot be empty")
//    @Pattern(regexp = "[A-Za-z-']*", message = "First name contains illegal characters")
//    private String firstName;
//    @NotBlank(message = "Last name cannot be empty")
//    @Pattern(regexp = "[A-Za-z-']*", message = "Last name contains illegal characters")
//    private String lastName;
//    @NotBlank(message = "Address cannot be empty")
//    @Pattern(regexp = "[\\w .\\-/,]*", message = "Address contains illegal characters")
//    private String address;
//
//    @SuppressWarnings("unused")
//    public Customer() {
//    }


    @Entity
    @Data
    @AllArgsConstructor
    public class Usuario {
        @Id
        private Integer id;
        private String email;
        private String nombres;
        private String apellidos;
        private String descripcion;
        public Usuario() {}

    }
