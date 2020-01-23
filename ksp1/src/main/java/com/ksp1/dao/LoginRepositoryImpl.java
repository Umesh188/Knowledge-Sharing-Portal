/*
 * package com.ksp1.dao;
 * 
 * import javax.persistence.EntityManager; import
 * javax.persistence.PersistenceContext; import javax.persistence.TypedQuery;
 * 
 * import org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.stereotype.Component;
 * 
 * import com.ksp1.beans.User;
 * 
 * @Component public class LoginRepositoryImpl {
 * 
 * @PersistenceContext private EntityManager entityManager;
 * 
 * @Autowired private LoginRepository loginRepository;
 * 
 * @SuppressWarnings("unused") User AuthenticateRole(String nm, String pass) {
 * String hql =
 * "SELECT eFROM User e WHERE e.username = :nm and e.password=:pass";
 * TypedQuery<User> query = entityManager.createQuery(hql, User.class);
 * query.setParameter("nm", nm); query.setParameter("pass", pass); return (User)
 * query.getResultList();
 * 
 * }
 * 
 * }
 */