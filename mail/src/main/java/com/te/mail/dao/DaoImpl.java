package com.te.mail.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import com.te.mail.mailinfo.Mail_Info;
import com.te.mail.usermodel.User_Info;

@Repository
public class DaoImpl implements Dao {
	public EntityManager entityManager() {
		EntityManagerFactory createEntityManagerFactory = Persistence.createEntityManagerFactory("mail");
		return createEntityManagerFactory.createEntityManager();
	}

	@Override
	public boolean create(User_Info info) {
		try {
			EntityManager entityManager = entityManager();
			EntityTransaction transaction = entityManager.getTransaction();
			transaction.begin();
			entityManager.persist(info);
			transaction.commit();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public boolean login(String userName, String password) {
		try {
			EntityManager entityManager = entityManager();
			String query = "select userName from User_Info where password=:password1";
			Query createQuery = entityManager.createQuery(query);
			createQuery.setParameter("password1", password);
			Object singleResult = createQuery.getSingleResult();
			if (singleResult.equals(userName)) {
				return true;
			}
		} catch (Exception e) {
			return false;
		}
		return false;
	}

	@Override
	public boolean forgotPassword(String email, String password) {
		try {
			EntityManager entityManager = entityManager();
			String query = "from User_Info where email=:mail";
			EntityTransaction transaction = entityManager.getTransaction();
			transaction.begin();
			Query createQuery = entityManager.createQuery(query);
			createQuery.setParameter("mail", email);
			User_Info singleResult = (User_Info) createQuery.getSingleResult();
			User_Info find = entityManager.find(User_Info.class, singleResult.getId());
			find.setPassword(password);
			transaction.commit();
			return true;
		} catch (Exception e) {
			return false;
		}

	}

	@Override
	public boolean findById(String id) {
		try {
			EntityManager entityManager = entityManager();
			EntityTransaction transaction = entityManager.getTransaction();
			String query = "from User_Info where userName=:id";
			Query createQuery = entityManager.createQuery(query);
			createQuery.setParameter("id", id);
			Object singleResult = createQuery.getSingleResult();
			if (singleResult != null) {
				return true;
			}

		} catch (Exception e) {
			return false;
		}
		return false;
	}

	@Override
	public boolean compose(Mail_Info info) {
		try {
			EntityManager entityManager = entityManager();
			EntityTransaction transaction = entityManager.getTransaction();
			transaction.begin();
			entityManager.persist(info);
			transaction.commit();
			return true;
		} catch (Exception e) {
			return false;
		}

	}

	@Override
	public List<Mail_Info> inbox(String userName) {
		try {
			EntityManager entityManager = entityManager();
			entityManager.getTransaction();
			Query createQuery = entityManager.createQuery("from Mail_Info where to_Id=:user and status='send'");
			createQuery.setParameter("user", userName);
			List<Mail_Info> resultList = createQuery.getResultList();
			return resultList;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

	@Override
	public List<Mail_Info> sent(String userName) {

		try {
			EntityManager entityManager = entityManager();
			entityManager.getTransaction();
			Query createQuery = entityManager.createQuery("from Mail_Info where from_Id=:user and status='send'");
			createQuery.setParameter("user", userName);
			List<Mail_Info> resultList = createQuery.getResultList();
			return resultList;
		} catch (Exception e) {
			System.out.println("Exception Occured");
		}
		return null;
	}

	@Override
	public List<Mail_Info> draft(String userName) {
		try {
			EntityManager entityManager = entityManager();
			entityManager.getTransaction();
			Query createQuery = entityManager.createQuery("from Mail_Info where from_Id=:user and status='saveToDraft'");
			createQuery.setParameter("user", userName);
			List<Mail_Info> resultList = createQuery.getResultList();
			return resultList;
		} catch (Exception e) {
			System.out.println("Exception Occured");
		}
		return null;
		
	}

}
