package Hospital.Application.SpringbootBasedApplication.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="Patient")
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name="Name")
    private String name;
    @Column(name="Age")
    private int age;
    @Column(name="room_no")
    private int roomno;
    @Column(name = "doctor_name")
    private String doctorname;

    private int expenses;

    private Status status;



}
