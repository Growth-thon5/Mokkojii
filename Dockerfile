
# 필요한 패키지 설치
RUN apt-get update && apt-get install -y \
    locales \
    && sed -i '/ko_KR.UTF-8/s/^# //g' /etc/locale.gen \
    && locale-gen

# 로케일 설정 추가
ENV LANG ko_KR.UTF-8
ENV LANGUAGE ko_KR:kr
ENV LC_ALL ko_KR.UTF-8
FROM eclipse-temurin:17-jdk

WORKDIR /app

ARG JAR_FILE=build/libs/mokkoji-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} app.jar

RUN apt-get update && apt-get install -y \
    locales \
    && sed -i '/ko_KR.UTF-8/s/^# //g' /etc/locale.gen \
    && locale-gen

# 로케일 설정 추가
ENV LANG ko_KR.UTF-8
ENV LANGUAGE ko_KR:kr
ENV LC_ALL ko_KR.UTF-8

ENTRYPOINT ["java","-Dfile.encoding=UTF-8","-jar","app.jar"]
