package com.kosa.springbootmyspace.web;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kosa.springbootmyspace.domain.Member;
import com.kosa.springbootmyspace.service.MemberService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/member")
public class MemberController {

    @Autowired
    private MemberService memberService;

    /**
     * 사용자 정보를 등록하는 엔드포인트 입니다.
     * 
     * @param member
     * @return
     */
    @PostMapping("/save")
    public ResponseEntity<Member> save(@RequestBody Member member) {
        try {
            Member saveMember = memberService.save(member);
            if (saveMember != null) {
                return new ResponseEntity<Member>(saveMember, HttpStatus.CREATED);
            }
        } catch (Exception e) {
            log.error(e.getMessage());
        }
        return new ResponseEntity<Member>(HttpStatus.NO_CONTENT);
    }

    /**
     * 사용자 정보를 수정하는 엔드포인트 입니다.
     * 
     * @param member
     * @return
     */
    @PutMapping("/update")
    public ResponseEntity<Member> update(@RequestBody Member member) {
        try {
            int result = memberService.update(member);
            if (result == 1) {
                Member updateMember = memberService.findById(member.getIdx());
                return new ResponseEntity<Member>(updateMember, HttpStatus.OK);
            }
        } catch (Exception e) {
            log.error(e.getMessage());
        }
        return new ResponseEntity<Member>(HttpStatus.NO_CONTENT);
    }

    /**
     * 사용자 정보를 삭제하는 엔드포인트 입니다.
     * 
     * @param idx
     * @return
     */
    @DeleteMapping("/delete/{idx}")
    public ResponseEntity<Integer> delete(@PathVariable int idx) {
        try {
            int result = memberService.delete(idx);
            if (result == 1) {
                return new ResponseEntity<Integer>(result, HttpStatus.OK);
            }
        } catch (Exception e) {
            log.error(e.getMessage());
        }
        return new ResponseEntity<Integer>(HttpStatus.NO_CONTENT);
    }

    /**
     * idx로 사용자를 조회하는 엔드포인트 입니다.
     * 
     * @param idx
     * @return
     */
    @GetMapping("/{idx}")
    public ResponseEntity<Member> findById(@PathVariable int idx) {
        try {
            Member findMember = memberService.findById(idx);
            if (findMember != null) {
                return new ResponseEntity<Member>(findMember, HttpStatus.OK);
            }
        } catch (Exception e) {
            log.error(e.getMessage());
        }
        return new ResponseEntity<Member>(HttpStatus.NO_CONTENT);
    }

    /**
     * 모든 사용자 정보를 조회하는 엔드포인트 입니다.
     * 
     * @return
     */
    @GetMapping("/findAll")
    public ResponseEntity<List<Member>> findAll() {
        try {
            List<Member> memberList = memberService.findAll();
            if (memberList != null) {
                return new ResponseEntity<List<Member>>(memberList, HttpStatus.OK);
            }
        } catch (Exception e) {
            log.error(e.getMessage());
        }
        return new ResponseEntity<List<Member>>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/principal")
    public ResponseEntity<Member> getPrincipal(Principal principal) {
        if(principal == null) {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
        Member member = memberService.findByLoginId(principal.getName());

        return new ResponseEntity<>(member, HttpStatus.OK);
    }
}
