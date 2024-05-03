package come.ezen.mybatis;

import com.ezen.mybatis.domain.employee.dto.MemberDTO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class MemberTest {

    @Test
    public void createMember(){
        MemberDTO memberDTO = MemberDTO.builder().id("bangry").build();
        log.debug("{}", "객체 생성 테스트");
    }

    @Test
    void test2(){
        log.info("{}", "JUnit 테스트 입니다...");
    }
}
