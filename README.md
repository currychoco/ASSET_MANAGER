# ASSET_MANAGER
사내 자산(asset) 관리 시스템 토이 프로젝트

## Spec
- Spring Boot 2.7.18
- Java 21
- Maven Build
- JSP + jQuery
- H2 Database
- JPA (Hibernate) + MyBatis

## Docker 환경 구성
아래 Container Registry 를 참고하여 테스트

### ASSET_MANAGER 서비스
- https://github.com/users/currychoco/packages/container/package/asset-manager
``` bash
docker pull ghcr.io/currychoco/asset-manager:latest
docker run --platform=linux/amd64 -p 8081:8081 ghcr.io/currychoco/asset-manager:latest
```

## 계정 동기화
- [HR_MANAGER](https://github.com/currychoco/HR_MANAGER) 의 인사계정 정보를 동기화하여 자산관리를 진행한다.
