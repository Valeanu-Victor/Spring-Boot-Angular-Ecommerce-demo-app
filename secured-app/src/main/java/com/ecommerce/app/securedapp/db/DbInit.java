package com.ecommerce.app.securedapp.db;

import com.ecommerce.app.securedapp.dto.ItemDto;
import com.ecommerce.app.securedapp.dto.UserDto;
import com.ecommerce.app.securedapp.dtoMapper.ItemMapper;
import com.ecommerce.app.securedapp.dtoMapper.UserMapper;
import com.ecommerce.app.securedapp.jpaRepository.ItemRepository;
import com.ecommerce.app.securedapp.jpaRepository.UserRepository;
import com.ecommerce.app.securedapp.model.Item;
import com.ecommerce.app.securedapp.model.User;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Service
public class DbInit implements CommandLineRunner {
    private UserRepository userRepository;
    private ItemRepository itemRepository;

    private UserMapper userMapper;
    private ItemMapper itemMapper;

    private PasswordEncoder passwordEncoder;

    public DbInit(UserRepository userRepository, ItemRepository itemRepository,
                  PasswordEncoder passwordEncoder, UserMapper userMapper, ItemMapper itemMapper) {
        this.userRepository = userRepository;
        this.itemRepository = itemRepository;
        this.passwordEncoder = passwordEncoder;
        this.userMapper = userMapper;
        this.itemMapper = itemMapper;
    }

    @Override
    public void run(String... args) {

        // Create 3 user entities
        UserDto dan = new UserDto("dan", passwordEncoder.encode("dan123"), 1, "USER", "");
        UserDto admin = new UserDto("admin", passwordEncoder.encode("admin123"), 1, "ADMIN", "");
        UserDto manager = new UserDto("manager", passwordEncoder.encode("manager123"), 1, "MANAGER", "");

        User danEntity = userMapper.toEntity(dan);
        User adminEntity = userMapper.toEntity(admin);
        User managerEntity = userMapper.toEntity(manager);

        // Create 4 item entities
        ItemDto iPhone = new ItemDto("phones", "iPhone", 15, 1000, new Date());
        ItemDto tesla = new ItemDto("cars", "Model X", 5, 20000.50, new Date());
        ItemDto perfume = new ItemDto("soap", "Dove", 150, 2, new Date());
        ItemDto pen = new ItemDto("pens", "ECDL", 200, 10, new Date());

        Item iPhoneEntity = itemMapper.toEntity(iPhone);
        Item teslaEntity = itemMapper.toEntity(tesla);
        Item perfumeEntity = itemMapper.toEntity(perfume);
        Item penEntity = itemMapper.toEntity(pen);

        // add entities to array
        List<User> users = Arrays.asList(danEntity, adminEntity, managerEntity);
        List<Item> items = Arrays.asList(iPhoneEntity, teslaEntity, perfumeEntity, penEntity);

        // Save all to db
        this.userRepository.saveAll(users);
        this.itemRepository.saveAll(items);

    }
}