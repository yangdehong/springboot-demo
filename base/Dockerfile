FROM java:8
MAINTAINER JURE
LABEL app="userPO" by="JURE"
ADD ./base/target/base.jar /usr/local/base.jar
EXPOSE 80
VOLUME /usr/local/project/crm/log/
CMD java -Xmx1024m -Xss1024m -jar /usr/local/base.jar