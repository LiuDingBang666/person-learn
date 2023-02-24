FROM java:8-alpine
CMD /bin/bash
ADD $PWD/app.jar app.jar
VOLUME ['app.jar','/www/upload']
EXPOSE 8081
ENTRYPOINT nohup java -jar app.jar --spring.profiles.active=pro