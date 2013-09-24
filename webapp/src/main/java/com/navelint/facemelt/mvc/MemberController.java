package com.navelint.facemelt.mvc;

import javax.persistence.NoResultException;
import javax.validation.Valid;

import com.navelint.facemelt.domain.Member;
import com.navelint.facemelt.repo.MemberDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
@RequestMapping(value="/")
public class MemberController
{
    @Autowired
    private MemberDao memberDao;

    @RequestMapping(method=RequestMethod.GET)
    public String displaySortedMembers(Model model)
    {
        model.addAttribute("newMember", new Member());
        model.addAttribute("members", memberDao.findAllOrderedByName());
        return "index";
    }

    @RequestMapping(method=RequestMethod.POST)
    public String registerNewMember(@Valid @ModelAttribute("newMember") Member newMember, BindingResult result, Model model)
    {
        if (!result.hasErrors()) {
            memberDao.register(newMember);
            return "redirect:/";
        }
        else {
            model.addAttribute("members", memberDao.findAllOrderedByName());
            return "index";
        }
    }

    @RequestMapping(value="/{memberPath}", method=RequestMethod.GET)
	public String displayMemberByPath(@PathVariable("memberPath") String memberPath, Model model)
    {
	Member member;
	try 
	    {
		member = memberDao.findByPath(memberPath);
	    } 
	catch (NoResultException e)
	    {
		member = null;
	    }
	model.addAttribute("member", member);
	return "showMember";
    }
}
