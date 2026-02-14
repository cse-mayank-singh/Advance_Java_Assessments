package com.example;
import jakarta.persistence.*;
import java.time.LocalDate;
public class App {
    public static void main(String[] args) {
        EntityManagerFactory emf =
                Persistence.createEntityManagerFactory("employeePU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Employee emp = new Employee("John", "john@example.com");
        IDCard card = new IDCard("IDC101", LocalDate.now());
        emp.setIdCard(card);
        em.persist(emp);
        em.getTransaction().commit();
        System.out.println("Employee Created Successfully\n");
        Employee fetchedEmp = em.find(Employee.class, emp.getId());
        System.out.println("Employee Details:");
        System.out.println("ID: " + fetchedEmp.getId());
        System.out.println("Name: " + fetchedEmp.getName());
        System.out.println("Email: " + fetchedEmp.getEmail());
        System.out.println("\nID Card Details:");
        System.out.println("Card Number: " + fetchedEmp.getIdCard().getCardNumber());
        System.out.println("Issue Date: " + fetchedEmp.getIdCard().getIssueDate());
        IDCard fetchedCard = em.find(IDCard.class, card.getId());
        System.out.println("\nAssociated Employee From IDCard:");
        System.out.println("Employee Name: " + fetchedCard.getEmployee().getName());
        em.close();
        emf.close();
    }
}
