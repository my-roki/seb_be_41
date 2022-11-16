package com.cafe.member.mapper;

import com.cafe.member.dto.MemberDto;
import com.cafe.member.entity.Member;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface MemberMapper {
    Member memberPostDtoToMember(MemberDto.Post memberPostDto);
    Member memberPatchDtoToMember(MemberDto.Patch memberPatchDto);

    @Mapping(source = "member.stamp.stampCount", target = "stampCount")
    @Mapping(source = "member.memberStatus.status", target = "memberStatus")
    MemberDto.Response memberToMemberResponseDto(Member member);
    List<MemberDto.Response> membersToListMemberResponseDto(List<Member> members);
}