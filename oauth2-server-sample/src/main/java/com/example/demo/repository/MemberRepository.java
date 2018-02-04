package com.example.demo.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.example.demo.domain.Member;

@RepositoryRestResource(path="user")
public interface MemberRepository extends PagingAndSortingRepository<Member, Long>{

}
