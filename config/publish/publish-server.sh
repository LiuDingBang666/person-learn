# 服务端 通过dockerfile构建镜像并同步发布到公仓库
# 当前镜像版本
version=2.3
# 当前镜像名称
server_name=xndb-server
# jar包所在路径
dir=/usr/application/server
docker build -t $server_name:$version $dir
#docker tag $server_name:$version swr.cn-north-4.myhuaweicloud.com/ldb/$server_name:$version
#docker login -u cn-north-4@MH1QVLNVZU0I7O5IH7G1 -p 05c5d71e8739f9f4af0ac3c2238129d434f2f5c83b6ab3c5f22dd0cafa923a9b swr.cn-north-4.myhuaweicloud.com
#docker push swr.cn-north-4.myhuaweicloud.com/ldb/$server_name:$version
docker rm -f $server_name
docker stop $server_name:$version
docker run -id -v /www/upload:/www/upload -p 8081:8081 --name $server_name $server_name:$version "java -jar app.jar"