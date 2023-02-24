# H5端 通过dockerfile构建镜像并同步发布到公仓库
# 当前镜像版本
version=1.0
# 当前镜像名称
server_name=xndb-h5
# 所在路径
dir=/usr/application/env
cd $dir
docker build -t $server_name:$version $dir
docker tag $server_name:$version swr.cn-north-4.myhuaweicloud.com/ldb/$server_name:$version
docker login -u cn-north-4@MH1QVLNVZU0I7O5IH7G1 -p 05c5d71e8739f9f4af0ac3c2238129d434f2f5c83b6ab3c5f22dd0cafa923a9b swr.cn-north-4.myhuaweicloud.com
docker push swr.cn-north-4.myhuaweicloud.com/ldb/$server_name:$version
docker rm -f $server_name
docker stop $server_name:$version
docker run -id -p 80:80 -v "$pwd/nginx/html:/usr/share/nginx/html" "$pwd/nginx/nginx.conf:/etc/nginx/nginx.conf" xndb-h5