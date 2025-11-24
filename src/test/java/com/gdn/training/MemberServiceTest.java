package com.gdn.training;

import com.gdn.training.dummy.entity.Member;
import com.gdn.training.dummy.repository.MemberRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@DisplayName("Member Service Test")
class MemberServiceTest {

  @Mock
  private MemberRepository memberRepository;

  @InjectMocks
  private MemberService memberService;

  @Test
  @DisplayName("Is Member not Found")
  public void isMemberNotFound() {
    String id = "member-id";
    RuntimeException ex = assertThrows(RuntimeException.class, () -> memberService.suspendMember(id));
    assertEquals("Member not found", ex.getMessage());
  }

  @Test
  @DisplayName("Suspend Active Member")
  public void suspendActiveMember() {
    String id = "12345";

    Member member = new Member();
    member.setId(id);
    member.setName("Name");
    member.setEmail("email@mail.com");
    member.setSuspended(false);
    when(memberRepository.getMember(id)).thenReturn(member);

    //Suspend Active Member and assert
    memberService.suspendMember(member.getId());
    assertTrue(member.isSuspended(), "Member is not suspended");

    verify(memberRepository).save(member);
  }

  @Test
  @DisplayName("Unable to Suspend an Already Suspended Member")
  public void suspendInactiveMember() {
    Member member = new Member();
    member.setId("12345");
    member.setName("Name");
    member.setEmail("email@mail.com");
    member.setSuspended(true);
    when(memberRepository.getMember(member.getId())).thenReturn(member);

    //Suspend Inactive Member and assert
    RuntimeException ex = assertThrows(RuntimeException.class, () -> memberService.suspendMember(
        member.getId()));
    assertEquals("Member already suspended", ex.getMessage());

    assertTrue(member.isSuspended());
    verify(memberRepository, never()).save(member);
  }

  @Test
  @DisplayName("Initialize Member")
  public void initializeMember() {
    Member member = Member.builder()
        .id("12345")
        .name("Name")
        .email("email@mail.com")
        .suspended(false)
        .build();

    assertEquals(member.getId(), "12345");
    assertEquals(member.getName(), "Name");
    assertEquals(member.getEmail(), "email@mail.com");
    assertFalse(member.isSuspended());
  }
}