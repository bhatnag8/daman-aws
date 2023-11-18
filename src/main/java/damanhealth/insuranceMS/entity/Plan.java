package damanhealth.insuranceMS.entity;

import javax.persistence.*;

@Entity
@Table(name = "plans")
public class Plan {

    // Insurance Plan ID - integer value
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    // Insurance Plan Name - String
    @Column(name = "name", nullable = false)
    private String name;

    // Insurance Plan Description - String
    @Column(name = "description", nullable = false)
    private String description;

    // Insurance Plan Premium - double
    @Column(name = "premium", nullable = false)
    private double premium;

    // Insurance Plan Active - boolean
    @Column(name = "active", nullable = false)
    private boolean active;

    // Insurance Plan Benefit - Benefit Object
    @OneToOne
    private Benefit benefit;


    public Plan() {

    }

    public Plan(String name, String description, double premium, boolean active, Benefit benefit) {
        this.name = name;
        this.description = description;
        this.premium = premium;
        this.active = active;
        this.benefit = benefit;
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

    public double getPremium() {
        return premium;
    }

    public void setPremium(double premium) {
        this.premium = premium;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public Benefit getBenefit() {
        return benefit;
    }

    public void setBenefit(Benefit benefit) {
        this.benefit = benefit;
    }



    public String getActiveString() {

        if (active) {
            return "Active";
        }
        return "Inactive";
    }

    public void changeToActive() {
        active = true;
    }

    public void changeToInactive() {
        active = false;
    }







}
