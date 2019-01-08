package com.mindtree.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.mindtree.entity.Player;
import com.mindtree.entity.Team;

public class DbUtils {
	public static Session createConnection() {
		Configuration configuration = new Configuration()
				.configure()
				.addAnnotatedClass(Team.class)
				.addAnnotatedClass(Player.class);
		
		SessionFactory sf = configuration.buildSessionFactory(); 
		Session session = sf.openSession(); 
		return session;
	}
}