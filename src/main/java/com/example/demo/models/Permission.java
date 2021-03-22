package com.example.demo.models;
import javax.persistence.*;
import java.util.Set;


@Entity
@Table(name = "permission")
public class Permission {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "users")
    private Users users;


    @ManyToMany(cascade = CascadeType.MERGE)
    @JoinTable(name = "permission_role", joinColumns = @JoinColumn(name = "permission_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles;

    @Column(name = "ajouter", nullable = true)
    private String ajouter;

    @Column(name = "modifier", nullable = true)
    private String modifier;

    @Column(name = "supprimer", nullable = true)
    private String supprimer;

    @Column(name = "afficher", nullable = true)
    private String afficher;

    @Column(name = "tout", nullable = true)
    private String tout;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "page")
    private Page page;



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    public String getAjouter() {
        return ajouter;
    }

    public void setAjouter(String ajouter) {
        this.ajouter = ajouter;
    }

    public String getModifier() {
        return modifier;
    }

    public void setModifier(String modifier) {
        this.modifier = modifier;
    }

    public String getSupprimer() {
        return supprimer;
    }

    public void setSupprimer(String supprimer) {
        this.supprimer = supprimer;
    }

    public String getAfficher() {
        return afficher;
    }

    public void setAfficher(String afficher) {
        this.afficher = afficher;
    }

    public String getTout() {
        return tout;
    }

    public void setTout(String tout) {
        this.tout = tout;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }


    public Page getPage() {
        return page;
    }

    public void setPage(Page page) {
        this.page = page;
    }
}