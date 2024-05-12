package org.example;




import org.example.data.Datas;
import org.example.entities.Categories;
import org.example.entities.Clients;
import org.example.entities.Products;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.math.BigDecimal;
import java.util.List;




public class Main {
    public static void main(String[] args) {
        Transaction transaction = null;
        try (StandardServiceRegistry standardServiceRegistry =
                     new StandardServiceRegistryBuilder()
                             .configure()
                             .build();
             SessionFactory sessionFactory = new MetadataSources(standardServiceRegistry)
                     .buildMetadata()
                     .buildSessionFactory();
        ) {
            Session session = sessionFactory.openSession();
            transaction = session.getTransaction();
            transaction.begin();

            List<Categories> categories = Datas.categoriesData();
            categories.forEach(session::persist);

            List<Products> products = Datas.productsData(categories);
            products.forEach(session::persist);

            // Виведення продуктів по категоріях
            for (Categories category : categories) {
                System.out.println("Category: " + category.getName());
                List<Products> productsInCategory = session.createQuery(
                                "select p from Products p join p.categories c where c.id = :categoryId",
                                Products.class)
                        .setParameter("categoryId", category.getId())
                        .list();
                for (Products product : productsInCategory) {
                    System.out.println("\tProduct: " + product.getName());
                }
            }

            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }
}

