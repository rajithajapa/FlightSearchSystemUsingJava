package com.vc.common;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.vc.persistence.HibernateUtil;

public class FlightApp 
{
    public static void main( String[] args )
    {
        System.out.println("Maven + Hibernate + MySQL");
        create();     }
    
    @SuppressWarnings("unchecked")
	public  List<Flight> search() {

    	Session session = HibernateUtil.getSessionFactory().openSession();
        
//        session.beginTransaction();
 
        Query query = session.createQuery("FROM Flight");
        return query.list();
//        for(Flight s : list) {
//        	System.out.println(s.getFlightId());
//        }
//        session.getTransaction().commit();
    }
    
    private static void update() {

    	Session session = HibernateUtil.getSessionFactory().openSession();
        
        session.beginTransaction();
 
        Query query = session.createQuery("UPDATE Flight set name = :fName "
        		+ "WHERE flightId = :fId");
        query.setParameter("fName", "009");
        query.setParameter("fId", 1234);
        int result = query.executeUpdate();
        System.out.println("result: " + result);
        session.getTransaction().commit();
    }
 
    
    private static void create() {
    	Session session = HibernateUtil.getSessionFactory().openSession();
        
        session.beginTransaction();
        Flight flight = new Flight();
        
        flight.setName("SFO to LA");
        flight.setFare(150);
        flight.setTime("8 AM");
        flight.setStops(0);
        
        session.save(flight);
        session.getTransaction().commit();
    }
}
