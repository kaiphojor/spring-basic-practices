package hello.core.member;

import java.util.HashMap;
import java.util.Map;

// 테스트, 로컬 개발용. 서버 재부팅시 날아감
public class MemoryMemberRepository implements MemberRepository{
    // 동시성 이슈가 있을 수 있으므로 concurrent hashmap을 쓰는 것이 낫다
    // 하지만 간편하게 일단 hashmap 사용
    private static Map<Long, Member> store = new HashMap<>();

    // ctrl + i 로 generate
    @Override
    public void save(Member member) {
        store.put(member.getId(),member);
    }

    @Override
    public Member findById(Long memberId) {
        return store.get(memberId);
    }
}
