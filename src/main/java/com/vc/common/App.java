package com.vc.common;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.vc.persistence.HibernateUtil;

public class App 
{
    public static void main( String[] args )
    {
        System.out.println("Maven + Hibernate + MySQL");
        search(); 
    }
    
    @SuppressWarnings("unchecked")
	private static void search() {

    	Session session = HibernateUtil.getSessionFactory().openSession();
        
        session.beginTransaction();
 
        Query query = session.createQuery("FROM Stock");
        List<Stock> list = query.list();
        for(Stock s : list) {
        	System.out.println(s.getStockCode());
        }
        session.getTransaction().commit();
    }
    
    private static void update() {

    	Session session = HibernateUtil.getSessionFactory().openSession();
        
        session.beginTransaction();
 
        Query query = session.createQuery("UPDATE Stock set stockCode = :scode "
        		+ "WHERE stockId = :sId");
        query.setParameter("scode", "009");
        query.setParameter("sId", 1234);
        int result = query.executeUpdate();
        System.out.println("result: " + result);
        session.getTransaction().commit();
    }

    private static void delete() {

    	Session session = HibernateUtil.getSessionFactory().openSession();
        
        session.beginTransaction();
 
        Query query = session.createQuery("DELETE FROM Stock WHERE stockId = :sId");
        query.setParameter("sId", 1236);
        int result = query.executeUpdate();
        System.out.println("result: " + result);
        session.getTransaction().commit();
    }
    
    private static void create() {
    	Session session = HibernateUtil.getSessionFactory().openSession();
        
        session.beginTransaction();
        Stock stock = new Stock();

        stock.setStockCode("4711");
        stock.setStockName("VJC");
        
        session.save(stock);
        session.getTransaction().commit();
    }
}
