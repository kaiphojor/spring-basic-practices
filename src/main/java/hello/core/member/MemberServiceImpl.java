package hello.core.member;

public class MemberServiceImpl implements MemberService{
    // ctrl + space -> ctrl + shift + enter 하면 code completion이 semicolon과 함께 된다
    private final MemberRepository memberRepository = new MemoryMemberRepository();

    @Override
    public void join(Member member) {

    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
