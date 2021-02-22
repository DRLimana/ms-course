package com.example.hroauth.feignclients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.hroauth.entities.User;

@Component
//name = nome do serviço que vai conectar
@FeignClient(name = "hr-user", path = "/users")
public interface UserFeignClient {
	
	@GetMapping(value = "/search")
	ResponseEntity<User> findByEmail(@RequestParam String email);
}
