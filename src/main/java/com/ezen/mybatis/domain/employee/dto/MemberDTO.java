package com.ezen.mybatis.domain.employee.dto;

import lombok.*;

//@NoArgsConstructor
//@AllArgsConstructor
//@Setter
//@Getter
//@ToString
//@EqualsAndHashCode
@Data
@Builder
public class MemberDTO {
    private String id;
    private String name;
    private int age;

    public static void main(String[] args) {
//        MemberDTO memberDTO = new MemberDTO();
//        memberDTO.setId("1");
//        memberDTO.setAge(10);
//        memberDTO.setName("aaa");
        MemberDTO memberDTO = MemberDTO.builder()
            .id("1")
//            .age(10)
//            .name("김기정")
            .build();

        System.out.println(memberDTO);
    }
}
