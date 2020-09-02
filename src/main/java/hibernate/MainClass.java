package hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;
import java.util.Scanner;


public class MainClass {

    public static void main(String[] args) {

        int product_Id = 2;
        int user_id = 1;

        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Users.class)
                .addAnnotatedClass(Product.class)
                .addAnnotatedClass(Sales.class)
                .buildSessionFactory();
        Session session = null;
//        READ
        session = factory.getCurrentSession();
        session.beginTransaction();
        Product product = session.get(Product.class, product_Id);
        List sales = session.createQuery("select name from Sales where productId = :productId").setParameter("productId", product_Id).getResultList();
        System.out.println("Продукт " + product.getProductName() + " купили:");
        System.out.println(sales);

        Users users = session.get(Users.class, user_id);
        List sales1 = session.createQuery("select productname from Sales where userId = :userId").setParameter("userId", user_id).getResultList();
        System.out.println("Клиент " + users.getName() + " купил:");
        System.out.println(sales1);
        session.getTransaction().commit();

//        DELETE
        Scanner in = new Scanner(System.in);
        System.out.print("Введите ID user: ");
        int str = in.nextInt();
        session = factory.getCurrentSession();
        session.beginTransaction();
        Users delUser = session.get(Users.class, str);
        session.delete(delUser);
        session.getTransaction().commit();

        System.out.print("Введите ID product: ");
        int str1 = in.nextInt();
        session = factory.getCurrentSession();
        session.beginTransaction();
        Product delProduct = session.get(Product.class, str1);
        session.delete(delProduct);
        session.getTransaction().commit();
    }
}