#########################################################################
# File Name: refreshDB.sh
# Author: Afar
# mail: 550047450@qq.com
# Created Time: Thursday, December 22, 2016 AM11:24:40 CST
#########################################################################
#!/bin/bash

# in order to run RecurtingSystem Concordion test, need to setup test environment as below

run_container(){
	pwd
	cd ~/twars/assembly/
	docker-compose kill && docker-compose up -d paper-api mongo
}

refreshDB() {
	pwd
	cd ~/twars/paper-api/
	./gradlew flywayclean && ./gradlew flywaymigrate && ./gradlew flywayinfo
}


start_web_api() {
	pwd
	cd ~/twars/web-api/
	export NODE_ENV=test; node app.js 
}

run_test() {
	cd ~/workspace/working-directory/concordion-demo
	./gradlew test
}

#run_container && refreshDB && start_web_api && run_test 
run_container && refreshDB &&  run_test 
