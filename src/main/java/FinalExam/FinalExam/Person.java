/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package FinalExam.FinalExam;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;
import java.io.Serializable;

/**
 *
 * @author Zahwa Ladya Maharani_060
 */
@Entity
@Table(name = "Person")
@NamedQueries({
    @NamedQuery(name = "Person.findAll", query = "SELECT p FROM Person p"),
    @NamedQuery(name = "Person.findById", query = "SELECT p FROM Person p WHERE b.id = :id"),
    @NamedQuery(name = "Person.findByNk", query = "SELECT p FROM Person p WHERE b.Nk = :Nk"),
    @NamedQuery(name = "Person.findByNama", query = "SELECT p FROM Person p WHERE b.nama = :nama"),
    @NamedQuery(name = "Person.findByTgllahir", query = "SELECT p FROM Person p WHERE b.tgllahir = :tgllahir)"),
    @NamedQuery(name = "Person.findByphoto", query = "SELECT p FROM Person p WHERE p.photo = :photo)")
public class Person implements Serializable {


    static Person findPerson(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    @Id
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "nama")
    private String nama;
    @Column(name = "NK")
    private String NK;
    @Column(name = "tglllahir")
    private String tgllahir;
    @Column(name = "photo")
    private String photo;

    public Person() {
    }

    public Person(Integer id) {
        this.id = id;
    }

    public Person getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getTgllahir() {
        return ;
    }
    }
