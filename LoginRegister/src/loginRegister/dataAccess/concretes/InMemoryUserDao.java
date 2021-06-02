package loginRegister.dataAccess.concretes;

import java.util.ArrayList;
import java.util.List;

import loginRegister.dataAccess.abstracts.UserDao;
import loginRegister.entities.concretes.User;

public class InMemoryUserDao implements UserDao{

	List<User> users;
	
	public InMemoryUserDao() {
		this.users = new ArrayList<>();
	}
	@Override
	public void add(User user) {
		users.add(user);
	}

	@Override
	public void update(User user) {
		User userUpdate = this.get(user.getId());
		
		if(userUpdate != null) {
			userUpdate.setAd(user.getAd());
			userUpdate.setSoyad(user.getSoyad());
		}else 
		{
			System.out.println("Kullanýcý bulunamadý");
		}
		
	}

	@Override
	public void delete(User user) {
		for (int i = 0; i < users.size(); i++) {
			if (users.get(i).getId() == user.getId()) {
				users.remove(i);
			}
		}
	}

	@Override
	public User get(int id) {
		for (User user : users) {
			if (user.getId() == id)
				return user;
		}
		return null;
	}

	@Override
	public List<User> getAll() {
		return users;
	}
	
	@Override
	public User getByEmail(String email) {
		for(User user : users) {
			if(user.getEposta() == email)
				return user;
		}
		return null;
	}

	@Override
	public User getByEmailAndPassword(String email, String password) {
		for(User user : users) {
			if(user.getEposta() == email && user.getParola() == password)
				return user;
		}
		return null;
	}

}
