# OCI Autoscaling Getting Started

```
docker run --rm jordi/ab -v 2 http://`hostname`:8080/factorization/12345678909
```

VM configuration

```
scp src/prime-factors/build/distributions/prime-factors-0.1.zip opc@<public-ip>:/home/opc
ssh opc@<public-ip>
sudo yum update -y
sudo yum install jdk-14 -y
sudo firewall-cmd --zone=public --add-port=8080/tcp --permanent
sudo firewall-cmd --reload
unzip prime-factors-0.1.zip
nohub ./prime-factors-0.1/bin/prime-factors > prime-factors.log 2>&1 &
```
