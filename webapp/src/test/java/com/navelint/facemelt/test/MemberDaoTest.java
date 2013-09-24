package com.navelint.facemelt.test;

import java.util.List;

import junit.framework.Assert;

import com.navelint.facemelt.domain.Member;
import com.navelint.facemelt.repo.MemberDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:test-context.xml",
"classpath:/META-INF/spring/applicationContext.xml"})
@Transactional
@TransactionConfiguration(defaultRollback=true)
public class MemberDaoTest
{
    @Autowired
    private MemberDao memberDao;

    @Test
    public void testFindById()
    {
        Member member = memberDao.findById(0l);

        Assert.assertEquals("John Smith", member.getName());
        Assert.assertEquals("john.smith@mailinator.com", member.getEmail());
        Assert.assertEquals("2125551212", member.getPhoneNumber());
	Assert.assertEquals("johnsmith", member.getPath());
        return;
    }

    @Test
    public void testFindByEmail()
    {
        Member member = memberDao.findByEmail("john.smith@mailinator.com");

        Assert.assertEquals("John Smith", member.getName());
        Assert.assertEquals("john.smith@mailinator.com", member.getEmail());
        Assert.assertEquals("2125551212", member.getPhoneNumber());
	Assert.assertEquals("johnsmith", member.getPath());
        return;
    }

    @Test
    public void testFindByPath()
    {
        Member member = memberDao.findByPath("johnsmith");

        Assert.assertEquals("John Smith", member.getName());
        Assert.assertEquals("john.smith@mailinator.com", member.getEmail());
        Assert.assertEquals("2125551212", member.getPhoneNumber());
	Assert.assertEquals("johnsmith", member.getPath());
        return;
    }

    @Test
    public void testRegister()
    {
        Member member = new Member();
        member.setEmail("jane.doe@mailinator.com");
        member.setName("Jane Doe");
        member.setPhoneNumber("2125552121");
	member.setPath("janedoe");

        memberDao.register(member);
        Long id = member.getId();
        Assert.assertNotNull(id);
        
        Assert.assertEquals(2, memberDao.findAllOrderedByName().size());
        Member newMember = memberDao.findById(id);

        Assert.assertEquals("Jane Doe", newMember.getName());
        Assert.assertEquals("jane.doe@mailinator.com", newMember.getEmail());
        Assert.assertEquals("2125552121", newMember.getPhoneNumber());
	Assert.assertEquals("janedoe", newMember.getPath());
        return;
    }

    @Test
    public void testFindAllOrderedByName()
    {
        Member member = new Member();
        member.setEmail("grace@navy.mil");
        member.setName("Grace Hopper");
        member.setPhoneNumber("2025554321");
	member.setPath("grace");
        memberDao.register(member);

        List<Member> members = memberDao.findAllOrderedByName();
        Assert.assertEquals(2, members.size());
        Member newMember = members.get(0);

        Assert.assertEquals("Grace Hopper", newMember.getName());
        Assert.assertEquals("grace@navy.mil", newMember.getEmail());
        Assert.assertEquals("2025554321", newMember.getPhoneNumber());
	Assert.assertEquals("grace", newMember.getPath());
        return;
    }

    @Test
    public void testFindAllOrderedByPath()
    {
        Member member = new Member();
        member.setEmail("grace@navy.mil");
        member.setName("Grace Hopper");
        member.setPhoneNumber("2025554321");
	member.setPath("grace");
        memberDao.register(member);

        List<Member> members = memberDao.findAllOrderedByPath();
        Assert.assertEquals(2, members.size());
        Member newMember = members.get(0);

        Assert.assertEquals("Grace Hopper", newMember.getName());
        Assert.assertEquals("grace@navy.mil", newMember.getEmail());
        Assert.assertEquals("2025554321", newMember.getPhoneNumber());
	Assert.assertEquals("grace", newMember.getPath());
        return;
    }
}
