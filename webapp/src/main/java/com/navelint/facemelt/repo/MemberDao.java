package com.navelint.facemelt.repo;

import java.util.List;

import com.navelint.facemelt.domain.Member;

public interface MemberDao
{
    public Member findById(Long id);

    public Member findByEmail(String email);

    public Member findByPath(String path);

    public List<Member> findAllOrderedByName();

    public List<Member> findAllOrderedByPath();

    public void register(Member member);
}
