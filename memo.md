# Spring Framework memo

##역사
* Spring 이전 Enterprise Java Beans(EJB) 기술이 있었다.
* entity bean(ORM) 기준도 가지고 있었다
* ORM - 객체를 DB에 쿼리 없이 자동으로 넣어주는 기술
* EJB에 의존적으로 개발하다 보니 복잡하고 느리다는 단점이 있었다. 기술 수준이 낮았다.
* 순수하게 JAVA로 돌아가자는 운동 -> Plain Old Java Object(POJO)
* 엔티티 빈울 대체하는 hibernate(JPA)
* hibernate를 가지고 표준(JPA)을 만듬
* Spring / JPA가 java의 메인 기술이다

## 스프링이란?
* 스프링 프레임워크
    * 핵심기술 - spring DI container, AOP, event, 기타
* 스프링 부트
  * 스프링을 편하게 사용하도록 해주는 기술 
      * 웹서버 내장 - 톰캣 설치 필요 없다
      * 버전 최적화
      * 메트릭 모니터링
  * 스프링 부트는 스프링 프레임워크 , 서드파티 사이에서 편리하게 사용할수 있게 해줌. 스프링 프레임워크를 사용한다.
* 스프링은 뭔가?
  * 스프링 DI 컨테이너 기술
  * 스프링 프레임워크
  * 부트, 프레임워크를 포함한 생태계 전체 
* 스프링은 왜 사용하는가? 왜 만들었나?
  * 핵심 컨셉은 항상 단순하다.
  * 스프링은 자바 - 객체지향 언어 기반이다
  * 좋은 객체지향 APP을 만들수 있게 도와주는 프레임워크
    * 객체지향의 핵심 - 다형성
    * 스프링은 IoC/DI 통해 다형성을 극대화 하도록 지원
* 스프링은 어떻게 사용하는가?

* 객체지향 프로그래밍
  * 프로그램을 객체간 모여서 상호작용 이루는 것으로 보고 개발하는 것
  * 컴포넌트를 유연하게 변경가능하면서 개발하는 방법 -> 다형성

## 다형성
* 정해진 역할을 여러방법으로 구현가능한 것
* 자동차란 역할은 바뀌지 않기 때문에 차가 바뀌어도 운전 가능하다
* 역할과 구현을 구분했기에 차가 바뀌어도 운전자에겐 영향을 주지 않는다
* 모든 배우는 대체 가능해야 한다. 로미오가 바뀌어도 줄리엣에는 영향이 없다
* 클라이언트는 대상 역할(인터페이스)만 알고 내부구조(구현 객체)를 몰라도/변경되어도/바뀌어도 상관없다.
* (객체)클라이언트와 서버간 협력관계(요청& 응답)
* 오버라이딩
* 본질
  * 인터페이스 구현한 객체 인스턴스를 실행 시점에 유연하게 변경
  * 객체간 협력관계에 집중
  * 클라이언트 변경 없이 서버의 구현기능 유연하게 변경
  * 모로가도 서울로 가면 된다.
* 한계
  * 역할이 변하면 클라이언트 / 서버 모두 변경 됨
  * 인터페이스의 안정적 설계가 중요 
## SOLID
* 좋은 객체 지향 설계 5원칙
1. SRP 
   * 한 클래스는 하나의 책임만. 변경이 있을 때 적은 파급효과
2. OCP
   * SW 요소는 확장에는 열려있고 (기존코드)변경에는 닫혀있어야한다.
   * 역할은 고정, 구현은 유연
   * 다형성 만족해도 OCP는 지키지 못하는 경우 있다.
     * service(client) 코드를 바꿔야 repository 변경 적용이 된다.
     * 별도의 설정자가 필요하다(스프링 컨테이너)
3. LSP
   * 악셀 밟을때는 무조건 앞으로 가게 해야한다. 컴파일된다고 능사가 아니다.
4. ISP
   * 특정 클라이언트를 위한 인터페이스 여러개가 범용 인터페이스 하나보다 낫다
5. DIP
   * 구현 클래스 보다 인터페이스에 의존해야한다. 역할에 의존해야.
   * DIP 위반이 되는 경우가 있다. memberRepository뿐만 아니라 MemoryMemberRepository
		
## 정리
* 다형성 만으로는 부품 갈듯이 개발할 수 없다
* 클라이언트도 똑같이 변경된다
* 다형성 만으로는 OCP, DIP 지킬 수 없다
* 뭔가 더 필요하다....
	
	
## DI , DI Container
* 의존관계, 의존성 주입으로 다형성 + OCP/DIP 가능케 함
  * DI : 의존관계 주입
  * DI 컨테이너
	
* 모든 설계에 역할 / 구현 분리
* 실무 고민
  * 인터페이스 도입시 추상화 비용 발생
    * 확장가능성 있으면 구체 클래스 말고 인터페이스 도입
    * 확장안하면 구체 클래스 도입 