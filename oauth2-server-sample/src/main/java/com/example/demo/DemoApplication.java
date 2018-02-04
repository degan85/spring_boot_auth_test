package com.example.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;

import com.example.demo.domain.Member;
import com.example.demo.repository.MemberRepository;


@EnableAuthorizationServer	// OAuth2 권한 서버
@SpringBootApplication
public class DemoApplication{

	/**
	 * API를 조회시 출력될 테스트 데이터
	 * @param memberRepository
	 * @return
	 */
	@Bean
	public CommandLineRunner commandLineRunner(MemberRepository memberRepository) {
		return args -> {
			memberRepository.save(new Member("이철수", "chulsoo", "test111"));
			memberRepository.save(new Member("김정인", "jungin11", "test222"));
			memberRepository.save(new Member("류정우", "jwryu991", "test333"));
		};
	}

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
}
