#!/bin/sh

APP_NAME=${1}
MODULE_NAME=${2}
LEVEL=${3}

echo 'get params 1:' $APP_NAME '2:'$ MODULE_NAME '3:' $LEVEL

pid=`jps -lv |grep "$APP_NAME" | awk '{print $1}'`
echo 'current time server pid = ' $pid

echo 'stop ' $APP_NAME ' server'
if [ "$pid" == '' ]; then
    echo 'Stopping' $APP_NAME '...'
    kill -15 $pid
fi
pid=`jps -lv |grep "$APP_NAME" | awk '{print $1}'`
for i in $pid
do
	echo ">>>kill $APP_NAME pid : $i"
	kill -9 $i ;
done
echo 'stop ' $APP_NAME ' server end'

echo 'backups ' $APP_NAME ' server'
#APP_JAR=$APP_NAME".jar"
#PATH='/service/springboot/'$MODULE_NAME

if [ -f /service/springboot/$MODULE_NAME/*.jar ];
then

    bakUrl=/service/springboot/base/backups/$(date +%Y%m%d%H%M%S)
    bakPrefix=$(date +%Y%m%d%H%M%S)

    echo 'backups ' $APP_NAME ' server doing...'

    mkdir -p $bakUrl
    mv /service/springboot/$MODULE_NAME/*.jar $bakUrl/$APP_NAME.jar-$bakPrefix

fi

echo 'backups ' $APP_NAME ' server done...'

rm -rf /service/springboot/$APP_NAME/*.jar

echo 'start ' $APP_NAME ' server'
cp ./$MODULE_NAME/target/$APP_NAME.jar /service/springboot/$MODULE_NAME/$APP_JAR
nohup java -jar /service/springboot/$MODULE_NAME/$APP_JAR --spring.profiles.active=$LEVEL > $APP_NAME".log" 2>&1 &
echo $APP_NAME Start Success!

