#!/bin/sh


# 初始化测试执行环境，并运行测试

twars="/home/afaren/twars"

# 彩色包装函数
color_echo () {
	echo "\033[1;32;40m $@ \033[0m"
}

run_container() {
	color_echo "start containers............."
	pwd
	cd $twars/assembly/ || exit 1
	docker-compose kill && docker-compose up -d paper-api mysql mongo
}

refreshMongo() {
	color_echo "refresh Mongo............"
	pwd
	cd $twars/web-api || exit 1
	npm run refreshMongo
}

refreshMysql() {
	color_echo "refresh Mysql............"
	pwd
	cd $twars/paper-api/ || exit 1
	./gradlew flywayclean && ./gradlew flywaymigrate && ./gradlew flywayinfo
}

refreshDB() {
	refreshMongo && refreshMysql
}

start_web_api() {
	color_echo "start web-api............."
	pwd
	cd $twars/web-api/ || exit 1
	#kill $(lsof  -t -i:3000) 
	(npm run startService&) | kill $(lsof -t -i:3000) && npm run startService &
}

run_test() {
	color_echo "execute test.............."
	cd $twars/automated-test || exit 1
	./gradlew clean test
}

# 初始化环境
initialize() {
	run_container && refreshDB && start_web_api  
}

# 第一次运行测试
init() {
	initialize && run_test
}

# 后续运行
run() {
	refreshDB && run_test
}



action=$1

case $action in 
	init)
		color_echo "-----------initialize execution environment-----------"
		init
		;;
	run)
		color_echo "----------run test----------"
		run
		;;
	*)
		color_echo "用法: (init|run)"
		color_echo "- command: "
		color_echo "init 初始化环境并运行测试"
		color_echo "run 运行测试"
		;;
esac
		

