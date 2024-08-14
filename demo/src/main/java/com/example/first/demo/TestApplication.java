package com.example.first.demo;

import com.example.first.demo.dao.UserRepo;
import com.example.first.demo.model.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.List;
import java.util.Optional;

@SpringBootApplication
public class TestApplication {


	public static void main(String[] args) {
		ApplicationContext context=SpringApplication.run(TestApplication.class, args);
		UserRepo userRepo=context.getBean(UserRepo.class);

		User u1=new User("Alex",34,"Noida");
		User u2=new User("Bob",45,"Kanpur");
//		For insert------------------------------
		User user=userRepo.save(u2);//saving single user
		System.out.println(user);

		User u3=new User("Jenny",55,"Pune");
		User u4=new User("John",65,"Mumbai");
		List<User> userList=List.of(u3,u4);
		Iterable<User>result=userRepo.saveAll(userList);//Save multiple objects
		result.forEach(u->{
			System.out.println(u);
		});


		//For Update-------------------------
Optional<User>optionalUser=userRepo.findById(2);
//try {
//	User u7 = optionalUser.get();
//	u7.setAge(25);
//	userRepo.save(u7);
//	System.out.println(u7);
//} catch (Exception e) {
//	System.out.println("Id not present");
//}


Iterable<User>iterable= userRepo.findAll();
//		Iterator<User>itr=iterable.iterator();
//		while(itr.hasNext())
//		{
//			User u=itr.next();
//			System.out.println(u);
//		}

//		iterable.forEach(new Consumer<User>() {
//			@Override
//			public void accept(User user) {
//				System.out.println(user);
//			}
//		});

//		iterable.forEach(u->{
//			System.out.println(u);
//		});

		//For delete--------------------------
//		userRepo.deleteById(54);
//
//		Iterable<User>iterable1=userRepo.findAll();
//		iterable1.forEach(u->{
//			System.out.println(u);
//		});
//		userRepo.deleteAll(iterable1);
//		System.out.println("All deleted which were in iterable");

//		Iterable<User>iterable1= userRepo.findAll();
//		List<Integer>integers=new ArrayList<>();
//		iterable1.forEach(u->{
//			System.out.println(u.getId());
//			integers.add(u.getId());
//		});
//
//		userRepo.deleteAllById(integers);
	}


}
