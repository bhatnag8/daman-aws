package damanhealth.insuranceMS.entity;

import javax.persistence.*;

@Entity
@Table(name = "benefits")
public class Benefit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    // Benefit Name - String
    @Column(name = "name", nullable = false)
    private String name;

    // Benefit Description - String
    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "copay", nullable = false)
    private boolean copay;


    public Benefit(String name, String description, boolean copay) {
        this.name = name;
        this.description = description;
        this.copay = copay;
    }

    public Benefit() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isCopay() {
        return copay;
    }

    public void setCopay(boolean copay) {
        this.copay = copay;
    }


    public String getCopayString() {


        if (copay) {
            return "Yes";
        }

        return "No";

    }

    public String alteredName()
    {
        String withOrWithout = "";
        if (copay){
            withOrWithout = " with 10% ";
        } else {
            withOrWithout = " without ";
        }

        return name + withOrWithout + "Copay";
    }

}
