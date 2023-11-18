package damanhealth.insuranceMS.entity;

import javax.persistence.*;

@Entity
@Table(name = "copays")
public class Copay {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    // Copay Name - String
    @Column(name = "name", nullable = false)
    private String name;

    // Copay Description - String
    @Column(name = "description", nullable = false)
    private String description;

    public Copay(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public Copay() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
