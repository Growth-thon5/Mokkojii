FROM eclipse-temurin:17-jdk

WORKDIR /app

# 필요한 패키지 설치 및 로케일 설정
RUN apt-get update && apt-get install -y locales \
    && sed -i '/ko_KR.UTF-8/s/^# //g' /etc/locale.gen \
    && locale-gen

# 로케일 환경변수 설정
ENV LANG=ko_KR.UTF-8
ENV LANGUAGE=ko_KR:ko
ENV LC_ALL=ko_KR.UTF-8

# JAR 파일 복사
ARG JAR_FILE=build/libs/mokkoji-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} app.jar

# 앱 실행
ENTRYPOINT ["java", "-Dfile.encoding=UTF-8", "-jar", "app.jar"]
