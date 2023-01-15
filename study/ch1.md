# 1. 스프링, 클라우드와 만나다

### 앞으로 배울 것

- 스프링 클라우드, 스프링 부트, 스웨거, 도커, 쿠버네티스, ELK 스택, 그라파나, 프로메테우스
- 마이크로서비스 아키텍처 구현 방법

### 1.1 마이크로서비스 아키텍처로 진화

- N-계층 아키텍처 : 고유 기능이 있는 여러 계층으로 나뉨
    - 장점 : 관심사 분리, 독립적으로 작업 가능, 개발자 찾기 쉬움
    - 단점 : 변경 적용 시 전체 앱을 재시작 해야 함, 비효율적, 리팩토링 어려움

  ![Untitled](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/14e9b003-bda7-4cf3-a441-02e4882383ba/Untitled.png)


### 1.5 클라우드 및 마이크로서비스 기반 애플리케이션

- 클라우드 컴퓨팅 : 인터넷을 통해 컴퓨팅과 가상화된 IT 서비스(DB, Network, Server, Software, Analytics 등)을 제공하는 것

  ![Untitled](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/1bfa7f0c-0d7e-4ed4-8054-c0d7e78e8758/Untitled.png)

    - IaaS : Server, Storage, Network 같은 컴퓨팅 자원에 접근 가능한 Infrastructure 제공 (ex. AWS(EC2), Azure VM, Google Compute Engine, k8s)
    - CaaS : IaaS와 PaaS의 중간 모델로, Container 기반 가상화의 한 형태 (ex. GKE(Google Compute Engine), Amazon의 ECS(Elastic Container Service))
    - PaaS : 애플리케이션의 개발, 실행, 유지관리에 집중할 수 있는 플랫폼과 환경 제공 (ex. Google App Engine, Cloud Foundry, Heroku, AWS Elastic Beanstalk)
    - FaaS : 서버리스 아키텍처. 모든 서버를 제공하는 클라우드 환경에서 기능의 실행 방법을 제공 (ex. AWS(Lambda), Google Cloud Function, Azure Function)
    - SaaS : 주문형 소프트웨어. 애플리케이션, 데이터, 운영체제, 가상화, 서버, 저장소, 네트워크 등 모든 것을 서비스 제공자가 관리 (ex. Salesforce, SAP, Google Business)

### 1.6 마이크로서비스는 코드 작성 이상을 의미한다

- 마이크로서비스 작성 지침
    - 적정 규모 : 마이크로서비스가 너무 많은 책임을 지지 않도록 적절한 마이크로서비스 크기를 유지하는 방법
    - 위치 투명성 : 서비스 호출에 대한 물리적 상세 정보를 관리하는 방법. 서비스 인스턴스가 빠르게 시작/종료될 수 있음
    - 회복성 : 실패한 서비스를 우회하고 “빠른 실패” 방식을 적용하여 마이크로서비스 소비자와 애플리케이션의 전반적인 무결성을 보호하는 방법
    - 반복성 : 서비스의 모든 새 인스턴스가 시작할 때 운영 환경의 다른 서비스와 동일한 구성과 코드베이스를 보장하는 방법
    - 확장성 : 서비스 간 직접적인 종속 관계를 최소화하고 마이크로서비스를 적절히 확장할 수 있도록 통신 방식을 구축하는 방법
- 사용되는 마이크로서비스 패턴 : 핵심 개발 패턴, 라우팅 패턴, 클라이언트 탄력성 패턴, 보안 패턴, 로깅 및 추적 패턴, 애플리케이션 지표 패턴, 빌드 및 배포 패턴

### 1.8 마이크로서비스 라우팅 패턴

- Service discovery : 서비스 디스커버리와 그 핵심 기능인 서비스 레지스트리 사용하여 서비스 위치를 쉽게 찾을 수 있음. 서비스의 물리적 위치를 추상화하고, 확장을 위해 새로운 마이크로서비스 인스턴스를 추가하거나 비정상 서비스 인스턴스를 투명하게 제거 가능 (ex. Netflix Eureka Service Discovery, etcd, Consul, Apache Zookeeper)
- Service routing : 클라이언트에 하나의 논리적 URL을 제공하여 통신하고 권한 부여, 인증, 콘텐츠 검사 등 정책 시행 지점 역할을 함 (ex. Spring Cloud API Gateway)

### 1.9 마이크로서비스 클라이언트 회복성

- client-side load balancing : 마이크로서비스의 여러 인스턴스에 대한 호출이 정산 인스턴스에 분산되도록 서비스 인스턴스 위치를 캐싱
- circuit breaker pattern : 실패 중이거나 성능 문제를 겪고 있는 서비스를 계속 호출하지 않도록 하는 방법
- fallback pattern : 마이크로서비스 호출이 실패할 때 호출되는 마이크로서비스가 아닌 다른 수단으로 서비스 클라이언트가 작업을 수행하도록 ‘플러그인’ 메커니즘을 제공하는 방법
- bulkhead pattern : 한 서비스의 오작동 호출이 애플리케이션의 다른 곳에 나쁜 영향을 미치지 않도록 호출을 격리

### 1.13 마이크로서비스 빌드/배포 패턴

- build and deployment pipelines : 조직의 모든 환경에서 원 버튼 클릭 빌드와 배포를 중시하는 반복적인 빌드 및 배포 프로세스를 구축하는 방법
- infrastructure as code : 소스 제어로 실행되고 관리되는 서비스 프로비저닝 처리 방법
- immutable servers : 마이크로서비스 이미지가 생성되고 배포된 후 절대 변경되지 않도록 하는 방법
- phoenix servers : 개별 컨테이너를 실행하는 서버가 정기적으로 분해되어 불변 이미지로 재생성되도록 하는 방법

---

이미지 출처

[https://learn.microsoft.com/ko-kr/azure/architecture/guide/architecture-styles/n-tier](https://learn.microsoft.com/ko-kr/azure/architecture/guide/architecture-styles/n-tier)

[https://www.whatap.io/ko/blog/9/](https://www.whatap.io/ko/blog/9/)